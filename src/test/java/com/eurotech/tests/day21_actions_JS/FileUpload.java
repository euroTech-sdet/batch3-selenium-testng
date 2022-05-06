package com.eurotech.tests.day21_actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;

public class FileUpload {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

    }

    @Test
    public void fileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.name("file"));
        chooseFile.sendKeys("/Users/erhanilgar/Desktop/Eurotech.txt");
        driver.findElement(By.id("file-submit")).click();
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualText,"File Uploaded!");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
