package com.crimewatcher.analytics.controller;

import com.crimewatcher.analytics.model.HotspotDTO;
import com.crimewatcher.analytics.service.AnalyticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService service;

    public AnalyticsController(AnalyticsService service) {
        this.service = service;
    }

    @GetMapping("/hotspots")
    public ResponseEntity<List<HotspotDTO>> hotspots() {
        return ResponseEntity.ok(service.hotspots());
    }
}
