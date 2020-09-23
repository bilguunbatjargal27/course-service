package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.Course;
import cs.mum.edu.orangeteam.compro.model.Student;
import cs.mum.edu.orangeteam.compro.service.CourseService;
import cs.mum.edu.orangeteam.compro.service.StudentService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("course/students")
@CrossOrigin(origins = "*") //this line
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public ResponseEntity<?> getAllStundets(){
        List<Student> students = (List<Student>) studentService.findAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/allCourse")
    public ResponseEntity<?> getAllCourses(){
        List<Course> courses = (List<Course>) courseService.findAll();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id){
        Student student = studentService.findStudentById(id);
        return ResponseEntity.ok(student);
    }
    @GetMapping("noticeCpt/{id}")
    public ResponseEntity<?> noticeCptReport(@PathVariable("id") Long id){
        Student student = studentService.findStudentById(id);
        System.out.println(student.getName() + " please fill your CPT report");
        return ResponseEntity.ok().body("student got notice");
    }

    @GetMapping("/bytminstructor/{id}")
    public ResponseEntity<?> getStudentsByTmInstructor(@PathVariable("id") Long id){
        List<Student> students = studentService.findByTmInstructor(id);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/byCoach/{id}")
    public ResponseEntity<?> getStudentsByCoach(@PathVariable("id") Long id){
        List<Student> students = studentService.findByCoachId(id);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/byjob/{id}")
    public ResponseEntity<?> getStudentsbyJobId(@PathVariable("id") Long id){
        List<Student> students = studentService.findByCoachId(id);
        return ResponseEntity.ok(students);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addStudent(@Valid @RequestBody final Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        Student student1 = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(student1);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody final Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        Student stu = studentService.updateStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(stu);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
        Student student = studentService.findStudentById(id);
        if(student == null) return ResponseEntity.badRequest().body("There is no student has an id equal to" + id);
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Student is deleted successfully");
    }


    @GetMapping("registercourse/{courseId}/{studentId}")
    public ResponseEntity<?> registerCourse(@PathVariable("courseId") Long courseId, @PathVariable("studentId") Long studentId){
        Course course = courseService.findCourseById(courseId);
        Date newDate = DateUtils.addMonths(new Date(), 2);
        if(course.getStartDate().compareTo(newDate) < 0){
            Student student = studentService.findStudentById(studentId);
            course.setStudentId(student);
            courseService.updateCourse(course);
            return ResponseEntity.ok("Student registered course");
        }
        return ResponseEntity.badRequest().body("Student cannot register course if course isn't 2 months ahead ");
    }

    // @TODO update CPT report if it is before the due date
}
