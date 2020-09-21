package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.Attend;
import cs.mum.edu.orangeteam.compro.model.Faculty;
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
    public List<Attend>getAllAttendance(){
        return (List<Attend>) attendService.findAllAttendance();
    }
    @GetMapping("/{id}")
    public Attend getAttendanceById(@PathVariable Long id){
        return attendService.findAttendanceById(id);
    }
    @PostMapping("/add")
    public Attend addAttendance(@RequestBody final Attend attend){
        return attendService.addAttendance(attend);
    }
    @PutMapping("/update")
    public Attend updateAttendance(@RequestBody final Attend attend){
        return attendService.updateAttendance(attend);
    }
    @DeleteMapping("delete/{id}")
    public Boolean deleteAttendanceById(@PathVariable Long id){
        Attend attend = attendService.findAttendanceById(id);
        if(attend == null) return false;
        attendService.deleteAttendanceById(id);
        return true;
    }
}
