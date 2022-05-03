package com.eurotech.day21_actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.Duration;

public class FilePathExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void fileUpload() {

        System.out.println("System.getProperty(\"os.name\") = " +  System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));


        //     /Users/erhanilgar/IdeaProjects/seleniumProject/src/main/batch3-selenium-testng
        //     src/test/resources/eurotech.txt

        String projectPath= System.getProperty("user.dir");
        String filePath="src/test/resources/eurotech.txt ";


        String fullPath=projectPath+"/"+filePath;
        System.out.println("fullPath = " + fullPath);

        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.name("file"));
        chooseFile.sendKeys(fullPath);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

