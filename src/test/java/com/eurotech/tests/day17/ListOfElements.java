package com.eurotech.tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @Test
    public void testName() {
        driver.get("https://demoqa.com/");
        List<WebElement> menuList = driver.findElements(By.cssSelector(".card.mt-4.top-card"));
        System.out.println("menuList.size() = " + menuList.size());

        for (WebElement menu : menuList) {
            System.out.println("menu.getText() = " + menu.getText());
            Assert.assertTrue(menu.isDisplayed());
        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }
}
