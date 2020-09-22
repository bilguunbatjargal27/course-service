package cs.mum.edu.orangeteam.compro.DAO;

import cs.mum.edu.orangeteam.compro.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByTmInstructor(Long id);
    List<Student> findByJobId(Long id);
}
