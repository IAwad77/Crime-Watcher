package com.crimewatcher.reports.model;import lombok.*;import jakarta.validation.constraints.NotBlank;

@Data @NoArgsConstructor @AllArgsConstructor

public class ReportStatusUpdateDTO{ @NotBlank private String newStatus; private String adminNote; }
