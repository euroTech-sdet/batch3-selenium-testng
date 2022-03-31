package com.eurotech.day11;

import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class CallWebDriverFactory {

    public static void main(String[] args) throws InterruptedException {


       WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().window().maximize();

        String pageSource = driver.getPageSource();

        if(pageSource.contains("Exit")){

            System.out.println("Test Passed");
        }else{
            System.out.println("Test Fail");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
