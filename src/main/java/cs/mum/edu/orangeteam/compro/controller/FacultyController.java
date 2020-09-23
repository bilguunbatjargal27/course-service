package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.*;
import cs.mum.edu.orangeteam.compro.service.AttendService;
import cs.mum.edu.orangeteam.compro.service.CourseService;
import cs.mum.edu.orangeteam.compro.service.FacultyService;
import cs.mum.edu.orangeteam.compro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("course/faculties")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    // ++++++++++++++++++++++ NOT NECCESSARY CODE
    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private AttendService attendService;
    // ++++++++++++++++++++++ NOT NECCESSARY CODE  END
    @GetMapping("")
    public ResponseEntity<?> getAllFaculties(){
        List<Faculty> faculties=(List<Faculty>) facultyService.findAllFaculty();
        return ResponseEntity.ok(faculties);
    }

    // ++++++++++++++++++++++ NOT NECCESSARY CODE
    @PostMapping("/addCourse")
    public ResponseEntity<?>  addCourse(@Valid @RequestBody final Course course, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body("Course is created successfully");
    }

    @GetMapping("/allCourse")
    public ResponseEntity<?> getAllCourses(){
        List<Course> courses = (List<Course>) courseService.findAll();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/facultyWillTeachCourse/{id}/{date}") // future
    public ResponseEntity<?> getCoursesFacultyWillTeach(@PathVariable Long id ,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        List<Course> courses = courseService.findCoursesFacultyWillTeach(id, date);
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }
    @GetMapping("/facultyTaughtCourse/{id}/{date}") // past
    public ResponseEntity<?> getCoursesFacultyTaught(@PathVariable Long id ,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        List<Course> courses = courseService.findCoursesWithFacultyTaught(id, date);
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @GetMapping("/updateStudentGrade/{id}/{date}/{grade}") // past
    public ResponseEntity<?> updateStudentGrades(@PathVariable Long id ,
                                                 @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                                 @PathVariable("grade") double grade){
       // courses that taught past or teaching now
        Course course = courseService.findCourseByIdInThePast(id, date);
        course.setGrade(grade);
        courseService.updateCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body(course);
    }

    @GetMapping("/addAttendance/{courseId}/{date}/{studentId}/{attendType}") // past
    public ResponseEntity<?> addAttendance(@PathVariable Long courseId,
                                                     @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                                     @PathVariable Long studentId,
                                                     @PathVariable String attendType ){

        Course course = courseService.findCourseById(courseId);
        Student student = studentService.findStudentById(studentId);
        Attend attend = new Attend();
        attend.setStudent(student);
        attend.setCourse(course);
        attend.setAttendDate(date);
        attend.setAttendType(AttendType.valueOf(attendType));
        attendService.addAttend(attend);

        return ResponseEntity.status(HttpStatus.OK).body("Attend added");
    }
    @GetMapping("/assignTa/{courseId}") // past
    public ResponseEntity<?> addAttendance(@PathVariable Long courseId){

        Course course = courseService.findCourseById(courseId);
        course.setTA(true);
        return ResponseEntity.status(HttpStatus.OK).body("Ta setted");
    }



    // ++++++++++++++++++++++ NOT NECCESSARY CODE END

    @GetMapping("/{id}")
    public ResponseEntity<?> getFacultyById(@PathVariable Long id){
       Faculty faculty= facultyService.findFacultyById(id);
        return ResponseEntity.ok(faculty);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addFaculty(@Valid @RequestBody final Faculty faculty, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        facultyService.addFaculty(faculty);
        return ResponseEntity.status(HttpStatus.OK).body("Faculty is created successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateFaculty(@Valid @RequestBody final Faculty faculty,BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        Faculty fac=facultyService.updateFaculty(faculty);
        return ResponseEntity.status(HttpStatus.OK).body("Faculty is updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFaculty(@PathVariable("id") Long id){
        Faculty faculty = facultyService.findFacultyById(id);
        if(faculty == null) return ResponseEntity.badRequest().body("There is no faculty has an id equal to" + id);
       facultyService.deleteFacultyById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Faculty is deleted successfully");
    }
}

//    View a course with all the students attending and their grades and attendance. ??????
//1 course has Students -> id, name, grade, attendance