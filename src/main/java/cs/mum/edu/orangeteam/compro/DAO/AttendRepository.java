package cs.mum.edu.orangeteam.compro.DAO;

import cs.mum.edu.orangeteam.compro.model.Attend;
import cs.mum.edu.orangeteam.compro.model.Course;
import cs.mum.edu.orangeteam.compro.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendRepository extends JpaRepository<Attend, Long> {

}
