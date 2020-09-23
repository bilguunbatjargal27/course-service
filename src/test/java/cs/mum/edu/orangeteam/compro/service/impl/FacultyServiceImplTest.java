package cs.mum.edu.orangeteam.compro.service.impl;

import cs.mum.edu.orangeteam.compro.AbstractComproComponentTest;
import cs.mum.edu.orangeteam.compro.model.Attend;
import cs.mum.edu.orangeteam.compro.model.Faculty;
import cs.mum.edu.orangeteam.compro.service.FacultyService;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FacultyServiceImplTest extends AbstractComproComponentTest {

    @Autowired
    private FacultyService facultyService;

    @BeforeEach
    void setUp() {
        logger.info("FacultyServiceImplTest started");
    }

    @AfterEach
    void tearDown() {
        logger.info("FacultyServiceImplTest completed");
    }

    @Test
    void addFaculty() {
    }

    @Test
    void updateFaculty() {
    }

    @Test
    void deleteFacultyById() {
        Faculty toBeDeleted = facultyService.findFacultyById(2L);
        Assert.assertNotNull("Failure: Expected Faculty to be not null", toBeDeleted);
        facultyService.deleteFacultyById(2L);
        Faculty deletedFaculty = facultyService.findFacultyById(2L);
        Assert.assertNull("Expected faculty to be deleted",deletedFaculty);
    }

    @Test
    void findFacultyById() {
        Long facultyId = 1L;
        Faculty faculty = facultyService.findFacultyById(facultyId);
        Assert.assertNotNull("Failure: expected faculty not to be null", faculty);
        Assert.assertEquals("Failure: expected facultyId to be the same",facultyId, faculty.getId());
        logger.info("Faculty Data: " + faculty);
    }

    @Test
    void findAllFaculty() {
        List<Faculty> faculties = (List<Faculty>) facultyService.findAllFaculty();
        Assert.assertNotNull("Failure: expected Faculties to be not null", faculties);
        Assert.assertEquals("Failure: expected size", 3, faculties.size());
        logger.info("Faculties list data: " + Arrays.toString(faculties.toArray()));
    }
}