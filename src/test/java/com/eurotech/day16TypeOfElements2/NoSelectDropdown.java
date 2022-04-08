package com.eurotech.day16TypeOfElements2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;

public class NoSelectDropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void testName() {

        driver.get("https://demo.aspnetawesome.com/");

        //once dropwdown menunun acilmasi icin element locate edilir ve click yapilir.
        driver.findElement(By.xpath("(//div[text()='Papaya'])[1]")).click();

        //butun elementleri goren locator bulunur ve list elemente atilir.
       List<WebElement> papaya = driver.findElements(By.xpath("(//ul[@class='o-mnits'])[10]/li"));
        System.out.println("papaya.size() = " + papaya.size());

        for (WebElement webElement : papaya) {
            System.out.println("webElement.getText() = " + webElement.getText());
        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);

        driver.close();

    }
}
