package com.eurotech.tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

    public static void main(String[] args) throws InterruptedException {

        //hey selenium bize bir chrome browser hazirla.
        WebDriverManager.chromedriver().setup();



        //Polymorphism ozelligini kullandik.
        WebDriver driver = new ChromeDriver();


        //Selenium bize google.com u ac.
        driver.get("https://google.com/");
        Thread.sleep(3000);

    }
}
