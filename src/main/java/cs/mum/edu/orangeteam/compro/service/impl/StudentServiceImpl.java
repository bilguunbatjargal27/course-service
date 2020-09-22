package cs.mum.edu.orangeteam.compro.service.impl;

import cs.mum.edu.orangeteam.compro.repository.StudentRepository;
import cs.mum.edu.orangeteam.compro.model.Student;
import cs.mum.edu.orangeteam.compro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findStudentById(Long id) {
        if(studentRepository.findById(id).isPresent()) return studentRepository.findById(id).get();
        else return null;
    }

    @Override
    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }


    @Override
    public List<Student> findByTmInstructor(Long id) {
        return studentRepository.findByTmInstructor(id);
    }

    @Override
    public List<Student> findByJobId(Long id) {
        return studentRepository.findByJobId(id);
    }

    @Override
    public List<Student> findByCoachId(Long id) {
        return studentRepository.findByCoachId(id);
    }
}
