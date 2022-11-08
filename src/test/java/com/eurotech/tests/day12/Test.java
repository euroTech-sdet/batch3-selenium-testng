package com.eurotech.tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebElement;

public class Test {
    public static void main(String[] args) throws InterruptedException {



    //    WebDriver driver = WebDriverFactory.getDriver("chrome");
//        driver.get("https://demoqa.com/sortable");
//        driver.manage().window().maximize();
//
//        driver.findElement(By.xpath("//*[@id=\"userName\"]"));
//
//
//        Thread.sleep(3000);
//        System.out.println("driver.= " + driver.findElement(By.xpath("//div[@class='list-group-item list-group-item-action']")).getText());
//
//        Thread.sleep(2000);


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://eurotech.study/login");

        //click login button
        String name ="Erhan";
        int num = 8;

        WebElement closeUnderstand = driver.findElement(By.id("rcc-confirm-button"));
        closeUnderstand.click();

        String expectedURL = driver.getCurrentUrl();

        WebElement loginBtn= driver.findElement(By.id("loginpage-form-btn"));
        //this is the milestone moment of selenium

        loginBtn.click();

        String actualURL= driver.getCurrentUrl();

        //verify that url did not changed
        //use if else

        Thread.sleep(2000);


        driver.close();
    }
}
