package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.Student;
import cs.mum.edu.orangeteam.compro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course/students")
public class StudentController {

    @Autowired
    private StudentService service;


    @GetMapping("")
    public List<Student> getAllStundets(){
        return (List<Student>) service.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return service.findStudentById(id);
    }


    @PostMapping("/add")
    public Student addStudent(@RequestBody final Student student){
        return service.addStudent(student);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody final Student student){
        return service.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteStudent(@PathVariable("id") Long id){
        service.deleteStudent(id);
        return true;
    }
}
