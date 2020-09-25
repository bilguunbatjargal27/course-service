package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.AbstractTest;
import cs.mum.edu.orangeteam.compro.model.Address;
import cs.mum.edu.orangeteam.compro.model.Course;
import cs.mum.edu.orangeteam.compro.model.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CourseServiceControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getCoursesList() throws Exception {
        String uri = "course/courses";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Course[] courselist = super.mapFromJson(content, Course[].class);
        assertTrue(courselist.length > 0);
    }

    @Test
    public void getCourseById() throws Exception {
        String uri = "course/courses/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void deleteCourse() throws Exception {
        String uri = "course/courses/delete/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void getCourseListByFacultyId() throws Exception {
        String uri = "course/courses/faculty/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Student[] studentlist = super.mapFromJson(content, Student[].class);
        assertTrue(studentlist.length > 0);
    }

}
