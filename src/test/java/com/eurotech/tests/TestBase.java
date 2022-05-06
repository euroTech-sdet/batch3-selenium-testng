package com.eurotech.tests;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;


    @BeforeMethod
    public void setUp() {

        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get(ConfigurationReader.get("url"));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2500);
        Driver.closeDriver();
    }
}
