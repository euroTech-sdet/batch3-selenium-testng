package com.eurotech.tests.day24_TestBase_BasePage;

import com.eurotech.pages.BasePage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase{

    @Test
    public void loginTest() throws InterruptedException {

//        WebDriver driver = Driver.get();
//        driver.get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();

//        String username = ConfigurationReader.get("username");
//        String password = ConfigurationReader.get("password");

        //driver.findElement(By.id("user-name")).sendKeys(username);
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("username"));
        Thread.sleep(2000);
        //driver.findElement(By.id("password")).sendKeys(password);
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("password"));
        Thread.sleep(2000);
        //driver.findElement(By.id("login-button")).click();
        loginPage.loginButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


    }




}
