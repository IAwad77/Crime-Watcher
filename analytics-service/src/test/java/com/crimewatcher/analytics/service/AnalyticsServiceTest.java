package com.crimewatcher.analytics.service;

import com.crimewatcher.analytics.model.ReportResponse;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AnalyticsServiceTest {

    @Test
    void hotspots_returnsGroupedLocations() {

        RestTemplate mockRest = mock(RestTemplate.class);

        ReportResponse[] stub = {
                new ReportResponse(1L,"T","A","d","PENDING"),
                new ReportResponse(2L,"T","A","d","PENDING"),
                new ReportResponse(3L,"T","B","d","PENDING")
        };

        when(mockRest.getForObject(anyString(), eq(ReportResponse[].class))).thenReturn(stub);

        var service = new AnalyticsService(mockRest);

        var list = service.hotspots();

        assertEquals(1, list.size());
        assertEquals("A", list.getFirst().location());
        assertEquals(2,  list.getFirst().count());
    }
}
