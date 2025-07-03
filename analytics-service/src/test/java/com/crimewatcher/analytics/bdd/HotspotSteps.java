package com.crimewatcher.analytics.bdd;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HotspotSteps {

    private WebDriver driver;

    @Given("the hotspot page is open")
    public void open_page() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.ofSeconds(4));

        String path = System.getProperty("user.dir")
                       + "/src/test/resources/hotspot.html";

        driver.get("file:///" + path);
    }

    @When("I request hotspots")
    public void press_button() {
        driver.findElement(By.id("btn")).click();
    }

    @Then("at least {int} hotspots are shown")
    public void check_text(int min) throws InterruptedException {

        Thread.sleep(1000); 

        String text = driver.findElement(By.id("out")).getText();
        assertTrue(text.length() >= min);

        driver.quit();
    }
}
