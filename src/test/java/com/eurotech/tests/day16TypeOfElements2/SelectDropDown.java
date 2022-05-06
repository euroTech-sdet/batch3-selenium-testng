package com.eurotech.tests.day16TypeOfElements2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.util.List;

public class SelectDropDown {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://demoqa.com/select-menu");

        WebElement colourDropDown = driver.findElement(By.cssSelector("#oldSelectMenu"));

        //select class indan obje olusturduk
        Select colour = new Select(colourDropDown);


        //getOptions methodu select classina bagli tum elementleri list olarak dondurur
        List<WebElement> colourList = colour.getOptions();

        for (WebElement option : colourList) {
            System.out.println("option.getText() = " + option.getText());
        }

        //verify that default colour is Red
        String expectedOption = "Red";
        String actualOption = colour.getFirstSelectedOption().getText();
        //  System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(actualOption, expectedOption, "verify that default colour is RED");

        //Select class i kullaranak elemente nasil tiklanir?

        //1 using visible text
        Thread.sleep(2000);
        colour.selectByVisibleText("Purple"); //purple a tiklayan line burasi

        expectedOption = "Purple";
        actualOption = colour.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify that default colour is Purple");

        //2 select using index
        Thread.sleep(2000);

        colour.selectByIndex(1);
        expectedOption = "Blue";
        actualOption = colour.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption, "verify that default colour is Blue");

        //3 select by value
        colour.selectByValue("8");
        expectedOption = "Indigo";
        actualOption = colour.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
