package cs.mum.edu.orangeteam.compro.DAO;

import cs.mum.edu.orangeteam.compro.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
