package com.eurotech.day22_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.Duration;

public class HoverTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void hoverTest() throws InterruptedException {
        /*
        --> go to website https://the-internet.herokuapp.com/hovers
        -->hover over each image
        -->verify each 'name:user' text is displayed
         */
        driver.get("https://the-internet.herokuapp.com/hovers");

        driver.findElement(By.xpath("(//img)[2]"));

        for (int i = 2; i <=4; i++) {
            String imgXpath="(//img)["+i+"]";
            WebElement img= driver.findElement(By.xpath(imgXpath));
            System.out.println(imgXpath);

            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            String textPath= "//h5[text()='name: user"+(i-1)+"']";
            WebElement text= driver.findElement(By.xpath(textPath));
            System.out.println(textPath);
            Assert.assertTrue(text.isDisplayed(),"verify user "+(i-1)+" is displayed");
        }
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

