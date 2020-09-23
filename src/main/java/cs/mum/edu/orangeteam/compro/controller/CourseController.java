package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.Course;
import cs.mum.edu.orangeteam.compro.model.Student;
import cs.mum.edu.orangeteam.compro.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("course/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public ResponseEntity<?> getAllCourses(){
        List<Course> courses = (List<Course>) courseService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getCourseById(@PathVariable("id") Long id){
        Course course = courseService.findCourseById(id);
        return ResponseEntity.status(HttpStatus.OK).body(course);
    }

    @PostMapping("/add")
    public ResponseEntity<?>  addCourse(@Valid @RequestBody final Course course, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body("Course is created successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<?>  updateCourse(@Valid @RequestBody final Course course, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        courseService.updateCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body("Student is updated successfully");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deleteCourse(@PathVariable("id") Long id){
        Course course = courseService.findCourseById(id);
        if(course == null) return ResponseEntity.badRequest().body("There is no course has an id equal to" + id);
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body("Course is deleted successfully");
    }
    @GetMapping("/faculty/{id}")
    public ResponseEntity<?>  getAllCoursesByFacultyId(@PathVariable Long id ){
        List<Course> courses = courseService.findCoursesByFaculty(id);
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }
    @GetMapping("/student/{id}")    
    public ResponseEntity<?> getAllCoursesByStudent(@PathVariable Long id ){
        List<Course> courses = courseService.findByStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }
    @GetMapping("/student/taken/{id}/{date}")
    public ResponseEntity<?> getCoursesTakenByStudent(@PathVariable Long id ,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        List<Course> courses = courseService.findCoursesAlreadyTakenWithStudent(id, date);
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }
    @GetMapping("/faculty/teach/{id}/{date}") // future
    public ResponseEntity<?> getCoursesFacultyWillTeach(@PathVariable Long id ,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        List<Course> courses = courseService.findCoursesFacultyWillTeach(id, date);
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @GetMapping("/faculty/taught/{id}/{date}") // past
    public ResponseEntity<?> getCoursesFacultyTaught(@PathVariable Long id ,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        List<Course> courses = courseService.findCoursesWithFacultyTaught(id, date);
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }



}
