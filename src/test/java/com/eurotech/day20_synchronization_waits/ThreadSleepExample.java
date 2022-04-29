package com.eurotech.day20_synchronization_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class ThreadSleepExample {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("cHrOmE");
        driver.manage().window().maximize();

    }@AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }


    @Test
    public void threadSleepExample() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[.='Start']")).click();

        Thread.sleep(6000);

        System.out.println("getText() = " + driver.findElement(By.cssSelector("#finish > h4")).getText());


    }
}
