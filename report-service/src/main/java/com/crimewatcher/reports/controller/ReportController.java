package com.crimewatcher.reports.controller;
import com.crimewatcher.reports.model.*;import com.crimewatcher.reports.service.ReportService;
import jakarta.validation.Valid;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.*;import java.util.List;
@RestController @RequestMapping("/api/reports")
public class ReportController{
 private final ReportService svc; public ReportController(ReportService s){this.svc=s;}
 @PostMapping public ResponseEntity<Report> submit(@Valid @RequestBody ReportDTO d){return ResponseEntity.ok(svc.submit(d));}
 @GetMapping public List<Report> all(){return svc.all();}
 @PatchMapping("{id}/status") public ResponseEntity<Report> upd(@PathVariable Long id,@RequestBody @Valid ReportStatusUpdateDTO d){
  return ResponseEntity.ok(svc.updateStatus(id,d.getNewStatus(),d.getAdminNote()));}
}
