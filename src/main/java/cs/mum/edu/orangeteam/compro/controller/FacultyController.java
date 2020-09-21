package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.Faculty;
import cs.mum.edu.orangeteam.compro.model.Student;
import cs.mum.edu.orangeteam.compro.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("")
    public List<Faculty>getAllFaculties(){
        return (List<Faculty>) facultyService.findAllFaculty();
    }
    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Long id){
        return facultyService.findFacultyById(id);
    }
    @PostMapping("/add")
    public Faculty addFaculty(@RequestBody final Faculty faculty){
        return facultyService.addFaculty(faculty);
    }

    @PutMapping("/update")
    public Faculty updateFaculty(@RequestBody final Faculty faculty){
        return facultyService.updateFaculty(faculty);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteFaculty(@PathVariable("id") Long id){
        Faculty faculty = facultyService.findFacultyById(id);
        if(faculty == null) return false;
       facultyService.deleteFacultyById(id);
        return true;
    }
}
