package com.eurotech.day15TypeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class AttributeTest {

    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demo.aspnetawesome.com/");

        WebElement radioBtn = driver.findElement(By.xpath("(//input[@type='radio'])[10]"));

        System.out.println(radioBtn.getAttribute("type"));
        System.out.println(radioBtn.getAttribute("value"));
        System.out.println(radioBtn.getAttribute("name"));

        //not: bazen getText ile alamadigimiz text leri getAttribute methodu ile aliyoruz.


    }
}
