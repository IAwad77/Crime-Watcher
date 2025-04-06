package com.crimewatcher.reports.service;
import com.crimewatcher.reports.model.*;import com.crimewatcher.reports.repository.ReportRepository;
import org.springframework.stereotype.Service;import java.time.LocalDateTime;import java.util.List;

@Service
public class ReportService{
 private final ReportRepository repo; public ReportService(ReportRepository r){this.repo=r;}
 public Report submit(ReportDTO d){
  var r=new Report(null,d.getType(),d.getLocation(),d.getDescription(),LocalDateTime.now(),"PENDING",null);
  return repo.save(r);
 }

 public List<Report> all(){return repo.findAll();}

 public Report updateStatus(Long id,String s,String note){

  var r=repo.findById(id).orElseThrow();

  if(!List.of("PENDING","UNDER_REVIEW","RESOLVED").contains(s)) throw new IllegalArgumentException();

  r.setStatus(s); if(note!=null) r.setAdminNote(note);
  
  return repo.save(r);
 }
}
