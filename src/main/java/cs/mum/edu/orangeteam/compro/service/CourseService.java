package cs.mum.edu.orangeteam.compro.service;


import cs.mum.edu.orangeteam.compro.model.Course;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface CourseService {

    public Course addCourse(Course course);
    public Course updateCourse(Course course);
    public void deleteCourse(Long id);
    public Course findCourseById(Long id);
    public Collection<Course> findAll();
    public List<Course> findByStudent(Long id);
    public List<Course> findCoursesAlreadyTakenWithStudent(Long id, Date date);
    public List<Course> findCoursesFacultyWillTeach(Long id, Date now); // future
    public List<Course> findCoursesWithFacultyTaught(Long id, Date now); // past
    public List<Course> findCoursesByFaculty(Long id); // future and past
    public Course findCourseByIdInThePast(Long id, Date now); // future and past

}
