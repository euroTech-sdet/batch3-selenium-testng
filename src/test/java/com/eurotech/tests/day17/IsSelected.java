package com.eurotech.tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class IsSelected {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void isSelected() {

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

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }
}
