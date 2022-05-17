package com.eurotech.tests.day28_review;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StaleElement extends TestBase {

    @Test
    public void staleProblem() {

        driver.get("https://www.freecrm.com/");
        WebElement loginBtn= driver.findElement(By.linkText("Login"));
        loginBtn.click();

        WebElement emailInput=driver.findElement(By.name("email"));
        emailInput.sendKeys("Eurotech");

        WebElement passwordInput=driver.findElement(By.name("password"));
        passwordInput.sendKeys("Password");

        driver.navigate().refresh();
        BrowserUtils.waitFor(2);

        emailInput.sendKeys("Eurotech Again");

    }

    @Test
    public void staleFix() {
        driver.get("https://www.freecrm.com/");
        BrowserUtils.waitFor(2);
        WebElement loginBtn= driver.findElement(By.linkText("Login"));
        loginBtn.click();

        WebElement emailInput=driver.findElement(By.name("email"));
        emailInput.sendKeys("Eurotech");

        WebElement passwordInput=driver.findElement(By.name("password"));
        passwordInput.sendKeys("Password");

        driver.navigate().refresh();
        BrowserUtils.waitFor(3);

        try{
            emailInput.sendKeys("Eurotech Again");
        }
        catch (StaleElementReferenceException e){
            emailInput=driver.findElement(By.xpath("//input[@placeholder='E-mail address']"));
            emailInput.sendKeys("Eurotech Again");
        }

    }
}
