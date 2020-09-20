package cs.mum.edu.orangeteam.compro.service.impl;

import cs.mum.edu.orangeteam.compro.DAO.CourseRepository;
import cs.mum.edu.orangeteam.compro.DAO.StudentRepository;
import cs.mum.edu.orangeteam.compro.model.Course;
import cs.mum.edu.orangeteam.compro.model.Student;
import cs.mum.edu.orangeteam.compro.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;

    @Override
    public Course addCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Course findCourseById(Long id) {
        if(repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    @Override
    public Collection<Course> findAll() {
        return repository.findAll();
    }
}
