package com.eurotech.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class LinkTextAndPartialLinkText {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        //FullName locator
        driver.findElement(By.id("userName")).sendKeys("Tom Tailer");

        //Email locator
        driver.findElement(By.id("userEmail")).sendKeys("tomtailer@mail.com");

        //current Adress Locator
        driver.findElement(By.id("currentAddress")).sendKeys("Garten Str. No:8 60706 Frankfurt");

        //Permanent Adres Locator
        driver.findElement(By.id("permanentAddress")).sendKeys("Garten Str. No:8 60706 Frankfurt");

        //Submit button
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        Thread.sleep(4000);
    }
}
