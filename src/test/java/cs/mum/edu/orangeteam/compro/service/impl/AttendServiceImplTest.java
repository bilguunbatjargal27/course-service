package cs.mum.edu.orangeteam.compro.service.impl;

import cs.mum.edu.orangeteam.compro.AbstractComproComponentTest;
import cs.mum.edu.orangeteam.compro.model.Attend;
import cs.mum.edu.orangeteam.compro.model.Student;
import cs.mum.edu.orangeteam.compro.service.AttendService;
import cs.mum.edu.orangeteam.compro.service.StudentService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Transactional
class AttendServiceImplTest extends AbstractComproComponentTest {

    @Autowired
    private AttendService attendService;
    @Autowired
    private StudentService studentService;


    @BeforeEach
    void setUp() {
        logger.info("AttendServiceImplTest started");
    }

    @AfterEach
    void tearDown() {
        logger.info("AttendServiceImplTest completed");
    }

    @Test
    void addAttend() {
        Attend attend = new Attend();
        Attend savedAttend= attendService.addAttend(attend);
        Assert.assertNotNull("Failure: expected not null", savedAttend);
        Assert.assertNotNull("Failure expected attendId to be not null", savedAttend.getId());
        List<Attend> attendances = (List<Attend>) attendService.findAll();
        Assert.assertEquals("Failure: expected size", 4, attendances.size());
        logger.info("Courses list data: "+ Arrays.toString((attendances.toArray())));
    }

    @Test
    void updateAttend() {
        Attend toUpdate = attendService.findAttendById(1L);
        Student student = studentService.findStudentById(2L);
        toUpdate.setStudent(student);
//        Assert.assertNotNull("Failure: expected attend not to be null", toUpdate);
//        Assert.assertNotNull("Failure: expected attendId  to be the same",toUpdate.getId());
//        Assert.assertNotNull("Failure: expected attendId  to be the same",toUpdate.getAttendDate());
//        Assert.assertNotNull("Failure: expected attendId  to be the same",toUpdate.getAttendType());
//
        Attend update = new Attend();
        Attend Updated = attendService.updateAttend(update);
//        Assert.assertNotNull("Failure: expected attend not to be null", toUpdate);
//        Assert.assertNotNull("Failure: expected attendId  to be the same",toUpdate.getId());
//        Assert.assertNull("Failure: expected attendId  to be the same",toUpdate.getAttendDate());
//        Assert.assertNull("Failure: expected attendId  to be the same",toUpdate.getAttendType());
//        logger.info("Attend Data: " + updated);
    }

    @Test
    void deleteAttend() {
//       Attend toBeDeleted = attendService.findAttendById(1L);
//        Assert.assertNotNull("Failure: Expected attend to be not null", toBeDeleted);
//        attendService.deleteAttend(1L);
//        Attend deletedAttend = attendService.findAttendById(1L);
//        Assert.assertNull("Expected attend to be deleted",deletedAttend);
    }

    @Test
    void findAttendById() {
       Long attendId = 1L;
        Attend attend = attendService.findAttendById(attendId);
        Assert.assertNotNull("Failure: expected attend not to be null", attend);
        Assert.assertEquals("Failure: expected attendId to be the same",attendId, attend.getId());
        logger.info("Attendance Data: " + attend);
    }

    @Test
    void findAll() {
        List<Attend> attendances = (List<Attend>) attendService.findAll();
        Assert.assertNotNull("Failure: expected Attendances to be not null", attendances);
        Assert.assertEquals("Failure: expected size", 3, attendances.size());
        logger.info("Attendance list data: " + Arrays.toString(attendances.toArray()));
    }
}