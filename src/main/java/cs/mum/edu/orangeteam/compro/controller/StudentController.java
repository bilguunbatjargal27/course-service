package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.Student;
import cs.mum.edu.orangeteam.compro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("course/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public ResponseEntity<?> getAllStundets(){
        List<Student> students = (List<Student>) studentService.findAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id){
        Student student = studentService.findStudentById(id);
        return ResponseEntity.ok(student);
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

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@Valid @RequestBody final Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("Student is created successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody final Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        Student stu = studentService.updateStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("Student is updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
        Student student = studentService.findStudentById(id);
        if(student == null) return ResponseEntity.badRequest().body("There is no student has an id equal to" + id);
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Student is deleted successfully");
    }

}
