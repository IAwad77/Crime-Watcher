package com.crimewatcher.reports.model;
import jakarta.persistence.*;import jakarta.validation.constraints.*;import lombok.*;import java.time.LocalDateTime;
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Report{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String type;
 @NotBlank private String location;
 @NotBlank @Size(max=500) private String description;
 private LocalDateTime timestamp;
 @NotBlank private String status;
 private String adminNote;
}
