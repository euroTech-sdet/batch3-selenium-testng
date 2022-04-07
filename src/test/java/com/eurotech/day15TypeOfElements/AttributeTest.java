package com.eurotech.day15TypeOfElements;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class AttributeTest {

    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demo.aspnetawesome.com/");

    }
}
