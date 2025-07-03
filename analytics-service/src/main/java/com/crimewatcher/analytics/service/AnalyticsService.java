package com.crimewatcher.analytics.service;

import com.crimewatcher.analytics.model.HotspotDTO;
import com.crimewatcher.analytics.model.ReportResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnalyticsService {

    private final RestTemplate rest;

    public AnalyticsService(RestTemplate rest) {
        this.rest = rest;
    }

    public List<HotspotDTO> hotspots() {

        ReportResponse[] reports = rest.getForObject(
                "http://localhost:8082/api/reports",
                ReportResponse[].class
        );

        if (reports == null) {
            return List.of();
        }

        Map<String, Long> grouped =
                Arrays.stream(reports)
                      .collect(Collectors.groupingBy(
                              ReportResponse::location,
                              Collectors.counting()
                      ));

        return grouped.entrySet()
                      .stream()
                      .filter(e -> e.getValue() >= 2)
                      .map(e -> new HotspotDTO(e.getKey(), e.getValue()))
                      .toList();
    }
}
