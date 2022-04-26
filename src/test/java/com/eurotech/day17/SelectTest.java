package com.eurotech.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;

public class SelectTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @Test
    public void testName() throws InterruptedException {
       driver.get("https://demoqa.com/select-menu");

        WebElement oldSelectMenu = driver.findElement(By.id("oldSelectMenu"));

        Select select = new Select(oldSelectMenu);

        System.out.println("getFirst " + select.getFirstSelectedOption().getText());

        select.selectByValue("5"); //black secti

        System.out.println("getFirst " + select.getFirstSelectedOption().getText());

        Thread.sleep(1000);
        select.selectByIndex(0); //red
        System.out.println("getFirst " + select.getFirstSelectedOption().getText());

        Thread.sleep(1000);
        select.selectByVisibleText("Yellow"); //Yellow
        System.out.println("getFirst " + select.getFirstSelectedOption().getText());

        List<WebElement> colourList = select.getOptions();
        for (WebElement colour : colourList) {
            System.out.println("colour.getText() = " + colour.getText());

        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }

}
