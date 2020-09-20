package cs.mum.edu.orangeteam.compro.service.impl;

import cs.mum.edu.orangeteam.compro.DAO.StudentRepository;
import cs.mum.edu.orangeteam.compro.model.Student;
import cs.mum.edu.orangeteam.compro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
//
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Student findStudentById(Long id) {
        if(repository.findById(id).isPresent()) return repository.findById(id).get();
        else return null;
    }

    @Override
    public Collection<Student> findAll() {
        return repository.findAll();
    }
}
