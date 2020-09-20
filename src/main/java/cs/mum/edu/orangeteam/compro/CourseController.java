package cs.mum.edu.orangeteam.compro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping(value = "/hi")
    public String getHi(){
        return "Hi";
    }
}
