package com.eurotech.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Random;

public class TaskSauceDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @Test
    public void testCase1() {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String expectedUrl= "https://www.saucedemo.com/inventory.html";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

    }
    @Test
    public void testCase2() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//*[text()='Sauce Labs Fleece Jacket']")).click();
        Thread.sleep(1000);
        String expectedText= "Sauce Labs Fleece Jacket";
        String actualText=driver.findElement(By.xpath("//*[text()='Sauce Labs Fleece Jacket']")).getText();
        Assert.assertEquals(actualText,expectedText);

        Thread.sleep(2000);
        driver.navigate().back();
       String actualTitle= driver.findElement(By.xpath("//*[text()='Products']")).getText();
       String expectedTitle="PRODUCTS";
       Assert.assertEquals(actualTitle,expectedTitle);

    }
    @Test
    public void testCase3() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

//        Random rn = new Random();
//        int num= rn.nextInt(6)+1;
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie")).click();
       String actualText= driver.findElement(By.cssSelector(".shopping_cart_link>span")).getText();
       Assert.assertEquals(actualText,"1");



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }
}
