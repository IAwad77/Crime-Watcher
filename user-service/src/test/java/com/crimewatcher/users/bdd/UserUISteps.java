package com.crimewatcher.users.bdd;
import io.cucumber.java.en.*;import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;import org.openqa.selenium.chrome.ChromeDriver;import java.time.Duration;import static org.junit.jupiter.api.Assertions.*;
public class UserUISteps{
 private static WebDriver d;
 @Given("the signup page is open") public void open(){ if(d==null){WebDriverManager.chromedriver().setup();d=new ChromeDriver();d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));} d.get("file:///"+System.getProperty("user.dir")+"/src/test/resources/signup.html");}
 @When("I register user {string} with email {string}") public void reg(String n,String e){d.findElement(By.id("name")).sendKeys(n);d.findElement(By.id("email")).sendKeys(e);d.findElement(By.id("role")).sendKeys("CITIZEN");d.findElement(By.id("submit")).click();}
 @Then("I should see confirmation containing {string}") public void conf(String x){assertTrue(d.findElement(By.id("msg")).getText().contains(x));d.quit();d=null;}
}
