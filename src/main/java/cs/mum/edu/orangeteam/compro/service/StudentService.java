package cs.mum.edu.orangeteam.compro.service;

import cs.mum.edu.orangeteam.compro.model.Course;
import cs.mum.edu.orangeteam.compro.model.Student;

import java.util.Collection;

public interface StudentService {

    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(Long id);
    public Student findStudentById(Long id);
    public Collection<Student> findAll();
    public Collection<Course> findAllCourses();
}
