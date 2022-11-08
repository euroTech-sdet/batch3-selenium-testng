package com.eurotech.tests.day26_POM;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPassword() {

        driver.get(ConfigurationReader.get("url"));
        WebElement usernameInput = driver.findElement(By.id("loginpage-input-email"));
        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));
        usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        passwordInput.sendKeys("123456");
        driver.findElement(By.id("loginpage-form-btn")).click();

        WebElement warningMessage = driver.findElement(By.xpath("//div[text()='Invalid Credentials!']"));
        Assert.assertEquals(warningMessage.getText(),"Invalid Credentials!");
    }
}
