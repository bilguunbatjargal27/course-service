package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.Student;
import cs.mum.edu.orangeteam.compro.service.CourseService;
import cs.mum.edu.orangeteam.compro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("course/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> getAllStundets(){
        return (List<Student>) studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/bytminstructor/{id}")
    public List<Student> getStudentsByTmInstructor(@PathVariable("id") Long id){
        return studentService.findByTmInstructor(id);
    }

    @GetMapping("/byjob/{id}")
    public List<Student> getStudentsbyJobId(@PathVariable("id") Long id){
        return studentService.findByJobId(id);
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody final Student student){
        return studentService.addStudent(student);
    }

    @PatchMapping("/update")
    public Student updateStudent(@RequestBody final Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteStudent(@PathVariable("id") Long id){
        Student student = studentService.findStudentById(id);
        if(student == null) return false;
        studentService.deleteStudent(id);
        return true;
    }


}
