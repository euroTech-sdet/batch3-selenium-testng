package com.eurotech.day15TypeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class DisableElementsDemo {


    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        WebElement element = driver.findElement(By.cssSelector("#input-example>input"));
        WebElement enableButton = driver.findElement(By.cssSelector("#input-example>button"));

      //  System.out.println(element.isEnabled());

        Assert.assertFalse(element.isEnabled());
        enableButton.click();
        Thread.sleep(6000);

        Assert.assertTrue(element.isEnabled());

        driver.close();
    }
}
