package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
public class CourseControllerTest {

 @Autowired
 private MockMvc mockMvc;

 @Test
 public void testGetCourses() throws Exception {
     mockMvc.perform(get("/api/courses")
             .accept(MediaType.APPLICATION_JSON))
             .andExpect(status().isOk())
             .andExpect(jsonPath("$[0].title").value("React Basics"))
             .andExpect(jsonPath("$[1].title").value("Advanced JavaScript"))
             .andExpect(jsonPath("$[2].title").value("Backend with Node.js"));
 }
}
