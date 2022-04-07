package com.eurotech.day15TypeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class CheckBoxDemo {

    @Test
    public void test1() throws InterruptedException {

            WebDriver driver= WebDriverFactory.getDriver("Chrome");
            driver.get("https://the-internet.herokuapp.com/checkboxes");
            driver.manage().window().maximize();

            Thread.sleep(2000);
            WebElement element1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
            element1.click();
            Thread.sleep(2000);
            Assert.assertTrue(element1.isSelected());
            WebElement element2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
            element2.click();
            Thread.sleep(2000);
            Assert.assertFalse(element2.isSelected());

            //Go to this url
        //click checkbox box 1
        //verify that checkbox is selected
        //click checkbox 2
        // verify that checkbox 2 is unselected

    }
}
