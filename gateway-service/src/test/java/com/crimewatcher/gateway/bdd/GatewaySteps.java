package com.crimewatcher.gateway.bdd;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GatewaySteps {

    private WebDriver driver;

    @Given("the gateway test page is open")
    public void open_page() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.ofSeconds(4));

        String path = System.getProperty("user.dir")
                       + "/src/test/resources/gateway.html";

        driver.get("file:///" + path);
    }

    @When("I click load users")
    public void click_button() {
        driver.findElement(By.id("b")).click();
    }

    @Then("results contain '['")
    public void check_response() throws InterruptedException {

        Thread.sleep(1000);

        String txt = driver.findElement(By.id("out")).getText();
        assertTrue(txt.contains("["));

        driver.quit();
    }
}
