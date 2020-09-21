package cs.mum.edu.orangeteam.compro.service;

import cs.mum.edu.orangeteam.compro.model.Course;
import cs.mum.edu.orangeteam.compro.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {

    Student addStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Long id);
    Student findStudentById(Long id);
    Collection<Student> findAll();
    List<Student> findByTmInstructor(Long id);
}
