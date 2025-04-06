package com.crimewatcher.reports.bdd;
import io.cucumber.java.en.*;import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;import org.openqa.selenium.chrome.ChromeDriver;import java.time.Duration;import static org.junit.jupiter.api.Assertions.*;

public class ReportSteps{

 private static WebDriver d; private static String id="1";

 @Given("the report page is open") 
 
 public void open(){ if(d==null){WebDriverManager.chromedriver().setup();d=new ChromeDriver();d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));} d.get("file:///"+System.getProperty("user.dir")+"/src/test/resources/report.html");}

 @When("I submit report type {string} at {string} with description {string}") 
 public void sub(String t,String l,String desc){d.findElement(By.id("type")).sendKeys(t);d.findElement(By.id("loc")).sendKeys(l);d.findElement(By.id("desc")).sendKeys(desc);d.findElement(By.id("b")).click();}

 @When("admin sets status to {string} with note {string}") 
 public void upd(String s,String n)throws Exception{var body=$"{\"newStatus\":\"{s}\",\"adminNote\":\"{n}\"}";new System.Net.WebClient().UploadString($"http://localhost:8082/api/reports/{id}/status","PATCH",body);}

 @Then("the API shows status {string}") 
 public void chk(String s)throws Exception{var json=new System.Net.WebClient().DownloadString($"http://localhost:8082/api/reports/{id}");assertTrue(json.contains(s));d.quit();d=null;}
}
