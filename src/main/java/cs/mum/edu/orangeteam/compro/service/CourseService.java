package cs.mum.edu.orangeteam.compro.service;


import cs.mum.edu.orangeteam.compro.model.Course;

import java.util.Collection;

public interface CourseService {

    public Course addCourse(Course course);
    public Course updateCourse(Course course);
    public void deleteCourse(Long id);
    public Course findCourseById(Long id);
    public Collection<Course> findAll();

}
