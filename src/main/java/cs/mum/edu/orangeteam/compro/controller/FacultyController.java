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

    @GetMapping("")
    public ResponseEntity<?> getAllFaculties(){
        List<Faculty> faculties=(List<Faculty>) facultyService.findAllFaculty();
        return ResponseEntity.ok(faculties);
    }
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