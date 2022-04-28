package com.eurotech.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

       driver.findElement(By.xpath("//*[text()='Remove']")).click();
       driver.findElement(By.cssSelector(".shopping_cart_link")).click();

       String  cartText = driver.findElement(By.cssSelector(".shopping_cart_link")).getText();
       Assert.assertEquals(cartText,"");

    }

    @Test
    public void testCase4() {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        WebElement orderMenu= driver.findElement(By.cssSelector(".product_sort_container"));
        Select select = new Select(orderMenu);

        String expectedResult = "Name (A to Z)";
        String actualResult = select.getFirstSelectedOption().getText();

        Assert.assertEquals(actualResult,expectedResult);

        select.selectByValue("lohi");
        String actualOrder= driver.findElement(By.cssSelector(".active_option")).getText();
        System.out.println("actualOrder = " + actualOrder);
        Assert.assertEquals(actualOrder,"PRICE (LOW TO HIGH)");

    }

    @Test
    public void testCase5() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Murat");
        driver.findElement(By.id("last-name")).sendKeys("Abi");
        driver.findElement(By.id("postal-code")).sendKeys("12357");
        driver.findElement(By.id("continue")).click();

        String expectedPrice = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();
        String actualPrice=driver.findElement(By.cssSelector(".summary_subtotal_label")).getText();

        System.out.println("expectedPrice = " + expectedPrice);
        System.out.println("actualPrice = " + actualPrice);

        Assert.assertTrue(actualPrice.contains(expectedPrice));

        driver.findElement(By.xpath("//*[text()='Finish']")).click();

        String expectedResult="THANK YOU FOR YOUR ORDER";
        String actualResult=driver.findElement(By.tagName("h2")).getText();

        Assert.assertEquals(actualResult,expectedResult);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }
}
