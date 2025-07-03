package com.crimewatcher.reports.service;
import com.crimewatcher.reports.model.*;import com.crimewatcher.reports.repository.ReportRepository;
import org.junit.jupiter.api.Test;import static org.mockito.Mockito.*;import static org.junit.jupiter.api.Assertions.*;
class ReportServiceTest{
 private final ReportRepository r=mock(ReportRepository.class);
 private final ReportService s=new ReportService(r);
 @Test void submit(){var d=new ReportDTO("THEFT","Main","Bike");when(r.save(any())).thenAnswer(i->i.getArgument(0));assertEquals("PENDING",s.submit(d).getStatus());}
}
