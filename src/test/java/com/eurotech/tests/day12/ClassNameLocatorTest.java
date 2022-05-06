package com.eurotech.tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.eurotech.utilities.WebDriverFactory;

public class ClassNameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();


        Thread.sleep(3000);
        driver.findElement(By.className("header-text")).click();

        Thread.sleep(2000);

        driver.close();
    }
}
