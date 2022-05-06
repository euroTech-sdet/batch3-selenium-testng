package com.eurotech.tests.day19_multipleWindows_frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class frames_iframes {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("cHrOmE");
        driver.manage().window().maximize();

    }

    @Test
    public void frameTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");

        // Switch to frame(iframe) using by nameOrId
        //driver.switchTo().frame("mce_0_ifr");

        // Switch to frame using by index number(java index)
        //driver.switchTo().frame(0);

        // Switch to frame using by locator like a normal web element
        WebElement frameWebElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameWebElement);

        WebElement textBox = driver.findElement(By.cssSelector("#tinymce"));

        Thread.sleep(2000);

        textBox.clear();
        Thread.sleep(2000);

        textBox.sendKeys("Welcome Home");

        // Switch back to main HTML
        // just one level HTML up
        driver.switchTo().parentFrame();

        WebElement header = driver.findElement(By.xpath("//h3"));
        System.out.println("header.getText() = " + header.getText());

    }

    @Test
    public void iframeTest() {

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Switch to frame-top
        driver.switchTo().frame("frame-top");

        // Switch to frame-left
        driver.switchTo().frame("frame-left");

        // get the text
        System.out.println("Text of Left Frame = " + driver.findElement(By.tagName("body")).getText());

        // Switch to parent frame
        driver.switchTo().parentFrame();

        // Switch to frame-middle using by index number
        driver.switchTo().frame(1);

        // get the text
        System.out.println("Text of Middle Frame = " + driver.findElement(By.id("content")).getText());

        // Switch to main HTML directly
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();

        // Switch to Bottom frame
        driver.switchTo().frame("frame-bottom");

        // get the text
        System.out.println("Text of Bottom Frame = " + driver.findElement(By.tagName("body")).getText());


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }



}
