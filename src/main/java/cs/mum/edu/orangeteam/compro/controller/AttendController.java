package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.Attend;
import cs.mum.edu.orangeteam.compro.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("course/attendances")
public class AttendController {

    @Autowired
    private AttendService attendService;

    @GetMapping("")
    public ResponseEntity<?> getAllAttends(){
        List<Attend>attendances= (List<Attend>) attendService.findAll();
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAttendById(@PathVariable("id") Long id){
        Attend attend=attendService.findAttendById(id);
        return ResponseEntity.ok(attend) ;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAttend(@Valid @RequestBody final Attend Attend, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        attendService.addAttend(Attend);
        return ResponseEntity.status(HttpStatus.OK).body("Attend is created successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAttend(@Valid @RequestBody final Attend attend, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
       Attend att= attendService.updateAttend(attend);
        return ResponseEntity.status(HttpStatus.OK).body("Attend is updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAttend(@PathVariable("id") Long id){
        Attend Attend = attendService.findAttendById(id);
        if(Attend == null) return ResponseEntity.badRequest().body("There is no attendance has an id equal to" + id);
        attendService.deleteAttend(id);
        return ResponseEntity.status(HttpStatus.OK).body("Attend is deleted successfully");
    }
}
