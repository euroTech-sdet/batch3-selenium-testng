package com.eurotech.tests.day23_properties_singleton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.WebDriverFactory;

public class ConfigPropertiesTest {

    @Test
    public  void test1() {

        String browserType = ConfigurationReader.get("browser");
        System.out.println("browserType = " + browserType);

        String myURL = ConfigurationReader.get("url");
        System.out.println("myURL = " + myURL);

    }

    @Test
    public void openBrowserUsingConfReader() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        driver.findElement(By.id("user-name")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

    }


}
