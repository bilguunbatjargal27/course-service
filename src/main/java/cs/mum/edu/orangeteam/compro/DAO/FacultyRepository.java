package cs.mum.edu.orangeteam.compro.DAO;

import cs.mum.edu.orangeteam.compro.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}
