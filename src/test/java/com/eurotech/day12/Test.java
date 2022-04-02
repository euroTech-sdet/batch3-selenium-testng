package com.eurotech.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class Test {
    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();


        Thread.sleep(3000);
        driver.findElement(By.id("hobbies-checkbox-1")).click();

        Thread.sleep(2000);

        driver.close();
    }
}
