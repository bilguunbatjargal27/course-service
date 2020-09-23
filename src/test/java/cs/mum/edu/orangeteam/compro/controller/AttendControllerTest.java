package cs.mum.edu.orangeteam.compro.controller;

import cs.mum.edu.orangeteam.compro.AbstractTest;
import cs.mum.edu.orangeteam.compro.model.Attend;
import cs.mum.edu.orangeteam.compro.model.AttendType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AttendControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getAllAttends() throws Exception {
        String uri = "/course/attendances";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Attend[] attendlist = super.mapFromJson(content, Attend[].class);
        assertTrue(attendlist.length > 0);


    }

    @Test
    public void getAttendById() throws Exception{
        String uri = "/course/attendances/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void addAttend() throws Exception{
        String uri = "/course/attendances/add";
        Attend attend = new Attend();
        attend.setAttendDate(new Date());
        attend.setAttendType(AttendType.IN_CLASS);

        String inputJson = super.mapToJson(attend);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void updateAttend() throws Exception{
        String uri = "/course/attendances/update";
        Attend attend = new Attend();
        attend.setAttendDate(new Date());
        attend.setId(1L);
        attend.setAttendType(AttendType.IN_CLASS);

        String inputJson = super.mapToJson(attend);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Attend is updated successfully");
    }

   @Test
    public void deleteAttend() throws Exception{
        String uri = "/course/attendances/delete/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Attend is deleted successfully");
    }
}