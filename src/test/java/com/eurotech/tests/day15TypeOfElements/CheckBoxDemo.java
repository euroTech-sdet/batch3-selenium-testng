package com.eurotech.tests.day15TypeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

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

    @Test
    public void testIsSelected() {

        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.get("https://www.autohero.com/nl/search/?brand=bmw&MID=NL_SES_3000_11_11_502-700-2-0-0-0_693-0-0-0-0-0_2&nw=g&kw=bmw&mt=p&ap=&cr=590660503143&dv=c&pl=&loc=9102707&gclid=CjwKCAjwjZmTBhB4EiwAynRmD6N-fgXOWF0GhrSBzAAmrsqLjpUqAZ3ywshjg8zTBjY-5wLQFLeodhoCfOYQAvD_BwE");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[text()='Transmissie']")).click();

        WebElement handgesc=  driver.findElement(By.xpath("//div[text()='Handgeschakeld']//../span/span"));

        System.out.println("handgesc.isSelected() = " + handgesc.isSelected());
        Assert.assertFalse(handgesc.isSelected());
        handgesc.click();
        System.out.println(handgesc.getAttribute("class"));
        Assert.assertTrue(handgesc.getAttribute("class").contains("checked"));


    }
}
