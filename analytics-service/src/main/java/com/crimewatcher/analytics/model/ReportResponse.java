package com.crimewatcher.analytics.model;

public record ReportResponse(Long id,
                             String type,
                             String location,
                             String description,
                             String status) { }
