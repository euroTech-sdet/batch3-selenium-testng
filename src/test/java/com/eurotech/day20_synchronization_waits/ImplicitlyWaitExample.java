package com.eurotech.day20_synchronization_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ImplicitlyWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("cHrOmE");
        driver.manage().window().maximize();

        // Aşağıdaki satır Selenium 4 versiyonu içindir.
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Aşağıdaki satır Selenium 3 versiyonu içindir.
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }


    @Test
    public void implicitlyWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        WebElement itsgone = driver.findElement(By.xpath("//p[@id='message']"));
        System.out.println("itsgone.getText() = " + itsgone.getText());
    }

    @Test
    public void implicitlyWait2() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();

        System.out.println("[@id='message']\")).getText() = " + driver.findElement(By.xpath("//p[@id='message']")).getText());

    }


}
