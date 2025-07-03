package com.crimewatcher.users.controller;
import com.crimewatcher.users.model.UserDTO;import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest @AutoConfigureMockMvc
class UserControllerIntegrationTest{
 @Autowired MockMvc mvc; @Autowired ObjectMapper om;
 @Test void crud() throws Exception{
  
  var d=new UserDTO("Layla","l@x.com","CITIZEN");
  
  mvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(d))).andExpect(status().isOk());
  
  mvc.perform(get("/api/users")).andExpect(status().isOk()).andExpect(jsonPath("$[0].email").value("l@x.com"));
 }
}
