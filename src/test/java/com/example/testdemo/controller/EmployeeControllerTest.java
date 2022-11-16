package com.example.testdemo.controller;

import com.example.testdemo.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTest {
  private MockMvc mockMvc;
  @Autowired
  private WebApplicationContext wc;
  public static final Employee employee = Employee.builder().id(1).name("ravi").message("Gain java Knowledge").build();
  ObjectMapper Mapper = new ObjectMapper();

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
  }

  @Test
  public void saveEmployee() throws JsonProcessingException {
  try {
    MvcResult result =
        mockMvc.perform(put("/api/employee").contentType(MediaType.APPLICATION_JSON).content(Mapper.writeValueAsString(employee))).andExpect(status().isOk()).andReturn();
    Employee response = Mapper.readValue(result.getResponse().getContentAsString(),Employee.class);
  }catch (Exception e) {
    
  }
  }

}
