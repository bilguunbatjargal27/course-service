package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.Attend;
import cs.mum.edu.orangeteam.compro.service.AttendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course/attendances")
public class AttendController {

    @Autowired
    private AttendService attendService;

    @GetMapping("")
    public List<Attend> getAllAttends(){
        return (List<Attend>) attendService.findAll();
    }

    @GetMapping("/{id}")
    public Attend getAttendById(@PathVariable("id") Long id){
        return attendService.findAttendById(id);
    }

    @PostMapping("/add")
    public Attend addAttend(@RequestBody final Attend Attend){
        return attendService.addAttend(Attend);
    }

    @PutMapping("/update")
    public Attend updateAttend(@RequestBody final Attend Attend){
        return attendService.updateAttend(Attend);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteAttend(@PathVariable("id") Long id){
        Attend Attend = attendService.findAttendById(id);
        if(Attend == null) return false;
        attendService.deleteAttend(id);
        return true;
    }
}
