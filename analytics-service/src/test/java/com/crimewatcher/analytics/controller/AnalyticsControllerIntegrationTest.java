package com.crimewatcher.analytics.controller;

import com.crimewatcher.analytics.model.HotspotDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AnalyticsControllerIntegrationTest {

    @Autowired
    MockMvc mvc;

    @Test
    void hotspots_endpointResponds() throws Exception {

        mvc.perform(get("/api/analytics/hotspots"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.length()", greaterThanOrEqualTo(0)));
    }
}
