package com.eurotech.tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.eurotech.utilities.WebDriverFactory;

public class NameLocatorTest {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
       // driver.get("https://www.browserstack.com/users/sign_up");
        driver.manage().window().maximize();

       // lazy way
        driver.findElement(By.name("user[full_name]")).sendKeys("Paul Mark");

       //ikinci yol
        WebElement inputName = driver.findElement(By.name("user[full_name]"));
        inputName.sendKeys("Mike");


        Thread.sleep(3000);
        driver.close();
    }
}
