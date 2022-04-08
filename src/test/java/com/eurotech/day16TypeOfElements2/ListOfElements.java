package com.eurotech.day16TypeOfElements2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test2() {

        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> menuList = driver.findElements(By.tagName("li"));

        //FindElements methodu ile locator ederken mutlaka size ina bakmaliyiz.
        //Locator hatali ise list element no such an element hatasi donmez.

        System.out.println("menuList.size() = " + menuList.size());
        int expectedSize= 44;
        int actualSize=menuList.size();
        Assert.assertEquals(actualSize,expectedSize,"verify that size is 44");


        for (WebElement menu : menuList) {
            System.out.println(menu.getText());
        }

        //menuList.get(43).click();
        System.out.println("menuList.get(8).getText() = " + menuList.get(8).getText());



    }

    @Test
    public void test1() {
        driver.get("https://demoqa.com/elements");
        List<WebElement> elements = driver.findElements(By.cssSelector(".header-text"));

        int expectedSize =6;

        System.out.println("elements.size() = " + elements.size());
        //size 6 oldugunu verify et
        Assert.assertEquals(elements.size(),expectedSize,"verify that size is 6");

        //menu listesinin textini yazdir
        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
        }

        //butun elementler gorunuyor mu verify et
        for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed());
        }


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }

}
