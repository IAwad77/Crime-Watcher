package com.crimewatcher.reports.repository;
import com.crimewatcher.reports.model.Report;import org.springframework.data.jpa.repository.JpaRepository;
public interface ReportRepository extends JpaRepository<Report,Long>{}
