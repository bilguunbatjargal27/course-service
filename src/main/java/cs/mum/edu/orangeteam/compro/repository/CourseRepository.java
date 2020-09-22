package cs.mum.edu.orangeteam.compro.repository;

import cs.mum.edu.orangeteam.compro.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    public List<Course> findByStudentId(Long id);
    public List<Course> findByStudentIdAndEndDateBefore(Long id, Date date);
    public List<Course> findByFacultyIdAndStartDateAfter(Long id, Date now); // future
    public List<Course> findByFacultyIdAndEndDateBefore(Long id, Date now); // past
    public List<Course> findByFacultyId(Long id); // future and past


// we have 1 use case front side for student - faculity front side
//    in the date?
// in the faculity we have function that named findByCourseIdAndStartDateBefore (courseID,startDate) -> courses
// we have List<COurse> findByFacuiltyIdAndStartDateBefore( f_id, startDate) -> list courses

}
