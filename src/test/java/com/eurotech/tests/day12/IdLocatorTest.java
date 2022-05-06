package com.eurotech.tests.day12;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.eurotech.utilities.WebDriverFactory;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        Faker faker = new Faker();

        WebElement userName = driver.findElement(By.id("userName"));
       // userName.sendKeys("Paul Mark");
        userName.sendKeys(faker.name().firstName());

       

        Thread.sleep(2000);

        driver.close();

    }
}
