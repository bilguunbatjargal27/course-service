package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.model.Course;
import cs.mum.edu.orangeteam.compro.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public List<Course> getAllCourses(){
        return (List<Course>) courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") Long id){
        return courseService.findCourseById(id);
    }

    @PostMapping("/add")
    public Course addCourse(@RequestBody final Course course){
        return courseService.addCourse(course);
    }

    @PutMapping("/update")
    public Course updateCourse(@RequestBody final Course course){
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCourse(@PathVariable("id") Long id){
        Course course = courseService.findCourseById(id);
        if(course == null) return false;
        courseService.deleteCourse(id);
        return true;
    }


}
