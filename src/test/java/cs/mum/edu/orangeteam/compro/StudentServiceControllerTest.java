package cs.mum.edu.orangeteam.compro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs.mum.edu.orangeteam.compro.model.Address;
import cs.mum.edu.orangeteam.compro.model.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;


public class StudentServiceControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getStudentsList() throws Exception {
        String uri = "/course/students";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Student[] productlist = super.mapFromJson(content, Student[].class);
        assertTrue(productlist.length > 0);
    }
    @Test
    public void getStudentById() throws Exception {
        String uri = "/course/students/610000";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void createProductSuccessfully() throws Exception {
        String uri = "/course/students/add";
        Student student = new Student();
        Address address = new Address();
        address.setState("AA");
        address.setStreet("MyStreet");
        address.setZipCode("ZipCode");
        address.setCity("CITY");
        student.setId(610000L);
        student.setName("Ginger");
        student.setAddress(address);
        student.setGPA(2);
        student.setEnrollmentDate(new Date());

        String inputJson = super.mapToJson(student);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        assertEquals(content, "Student is created successfully");
    }

    @Test
    public void createProductFailure() throws Exception {
        String uri = "/course/students/add";
        Student student = new Student();
        Address address = new Address();
        address.setState("AA");
        address.setStreet("MyStreet");
        address.setZipCode("ZipCode");
        address.setCity("CITY");
        student.setId(610000L);
        student.setName("");
        student.setAddress(address);
        student.setGPA(2);
        student.setEnrollmentDate(new Date());

        String inputJson = super.mapToJson(student);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }

    @Test
    public void updateProductSuccessfully() throws Exception {
        String uri = "/course/students/update";
        Student student = new Student();
        Address address = new Address();
        address.setState("AA");
        address.setStreet("MyStreet");
        address.setZipCode("ZipCode");
        address.setCity("CITY");
        student.setId(610000L);
        student.setName("Name");
        student.setAddress(address);
        student.setGPA(2);
        student.setEnrollmentDate(new Date());
        String inputJson = super.mapToJson(student);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Student is updated successfully");
    }
   @Test
    public void updateProductFailure() throws Exception {
        String uri = "/course/students/update";
        Student student = new Student();
        Address address = new Address();
        address.setState("AA");
        address.setStreet("MyStreet");
        address.setZipCode("ZipCode");
        address.setCity("CITY");
        student.setId(610000L);
        student.setName("Name");
        student.setAddress(address);
        student.setGPA(10);
        student.setEnrollmentDate(new Date());
        String inputJson = super.mapToJson(student);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }

    @Test
    public void deleteProduct() throws Exception {
        String uri = "/course/students/delete/610000";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Student is deleted successfully");
    }

    @Test
    public void getStudentsListByTmConstuctorId() throws Exception {
        String uri = "/course/students/bytminstructor/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Student[] productlist = super.mapFromJson(content, Student[].class);
        assertTrue(productlist.length > 0);
    }
    @Test
    public void getStudentsListByCoachId() throws Exception {
        String uri = "/course/students/byCoach/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Student[] productlist = super.mapFromJson(content, Student[].class);
        assertTrue(productlist.length > 0);
    }
    @Test
    public void getStudentsListByJobId() throws Exception {
        String uri = "/course/students/byjob/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Student[] productlist = super.mapFromJson(content, Student[].class);
        assertTrue(productlist.length > 0);
    }


}
