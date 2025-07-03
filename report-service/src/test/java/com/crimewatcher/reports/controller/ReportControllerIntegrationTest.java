package com.crimewatcher.reports.controller;
import com.crimewatcher.reports.model.ReportDTO;import com.crimewatcher.reports.model.ReportStatusUpdateDTO;
import com.fasterxml.jackson.databind.ObjectMapper;import org.junit.jupiter.api.Test;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest @AutoConfigureMockMvc
class ReportControllerIntegrationTest{
 @Autowired MockMvc mvc; @Autowired ObjectMapper om;
 @Test void flow() throws Exception{
  var d=new ReportDTO("SUSPICIOUS","5th","Van"); mvc.perform(post("/api/reports").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(d))).andExpect(status().isOk());
  var p=new ReportStatusUpdateDTO("RESOLVED","done");
  mvc.perform(patch("/api/reports/1/status").contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsString(p))).andExpect(status().isOk()).andExpect(jsonPath("$.status").value("RESOLVED"));
 }
}
