package com.eurotech.day21_actions_JS;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class JavaScriptExecutorDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");


    }

    @Test
    public void actionsTest() {
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

