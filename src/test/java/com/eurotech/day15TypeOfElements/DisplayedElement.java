package com.eurotech.day15TypeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class DisplayedElement {


    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement helloBtn = driver.findElement(By.xpath("//h4[text()='Hello World!']")); //element burada

       // System.out.println("helloBtn.isDisplayed() = " + helloBtn.isDisplayed());//ancak gorunmuyor
        Assert.assertFalse(helloBtn.isDisplayed());
        WebElement startBtn = driver.findElement(By.xpath("//*[text()='Start']"));

        startBtn.click();
        Thread.sleep(5000);
        Assert.assertTrue(helloBtn.isDisplayed());
        String actualText = helloBtn.getText();
        String expectedText="Hello World!";

        Assert.assertEquals(actualText,expectedText);


        //Task
        //hello button in gorunmedigini  verify et
        //start button a tikla
        // hello button in text ini al
        //"Hello World!" oldugunu verify et
        //String expectedText='Hello World!'


        driver.close();
    }
}
