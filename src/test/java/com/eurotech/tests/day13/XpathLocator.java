package com.eurotech.tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.eurotech.utilities.WebDriverFactory;

public class XpathLocator {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.co.uk/");

        String product = "Apple";

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
        driver.findElement(By.id("nav-search-submit-button")).click();

        String actualResult = driver.findElement(By.xpath("//span[contains(text(),'results for')]")).getText();

        System.out.println("actualResult = " + actualResult);


        driver.close();
    }
}
