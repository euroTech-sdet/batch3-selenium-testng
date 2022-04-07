package com.eurotech.day15TypeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class RadioButtonDemo {


    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");
        driver.manage().window().maximize();

    //    driver.findElement(By.xpath("(//div[@class='o-chk '])[2]")).click();
        driver.findElement(By.xpath("//div[text()='Legumes']")).click();

    }
}
