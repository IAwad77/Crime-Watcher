package com.crimewatcher.frontend;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FrontendFlowTest {

    private WebDriver driver;

    @BeforeAll
    void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void user_to_hotspot() throws InterruptedException {

        // 1 – sign up
        driver.get("http://localhost:3000/");
        driver.findElement(By.name("name")).sendKeys("Zara");
        driver.findElement(By.name("email")).sendKeys("z@x.com");
        driver.findElement(By.cssSelector("button")).click();
        Thread.sleep(500);

        // 2 – submit report
        driver.get("http://localhost:3000/report");
        driver.findElement(By.name("type")).sendKeys("THEFT");
        driver.findElement(By.name("location")).sendKeys("Main");
        driver.findElement(By.name("description")).sendKeys("Bike");
        driver.findElement(By.cssSelector("button")).click();
        Thread.sleep(500);

        // 3 – admin resolve
        driver.get("http://localhost:3000/admin");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(500);

        // 4 – hotspot check
        driver.get("http://localhost:3000/hotspots");
        String body = driver.findElement(By.tagName("body")).getText();
        Assertions.assertTrue(body.length() > 0);
    }

    @AfterAll
    void close() {
        driver.quit();
    }
}
