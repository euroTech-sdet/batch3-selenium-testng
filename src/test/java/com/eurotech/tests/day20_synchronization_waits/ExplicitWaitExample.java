package com.eurotech.tests.day20_synchronization_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;

public class ExplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("cHrOmE");
        driver.manage().window().maximize();

        // Aşağıdaki satır Selenium 4 versiyonu içindir.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Aşağıdaki satır Selenium 3 versiyonu içindir.
       // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }


    @Test
    public void explicitWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        driver.findElement(By.tagName("button")).click();

//        WebDriverWait wWait = new WebDriverWait(driver,Duration.ofSeconds(20));
//        wWait.until(ExpectedConditions.elementToBeClickable(By.id("//xpath")));
//        wWait.until(ExpectedConditions.elementToBeClickable(By.xpath("gjfhgjf")));

        WebElement helloText = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[.='Hello World!']")));

        System.out.println("helloText.getText() = " + helloText.getText());

    }

    @Test
    public void explicitWait2() {

            driver.get("https://google.com/ncr");

            driver.findElement(By.name("q")).sendKeys("peynir");
            WebElement googledaAra = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
            googledaAra.click();

            WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));

            // Print the first result
            System.out.println("firstResult.getText() = " + firstResult.getText());

    }
}
