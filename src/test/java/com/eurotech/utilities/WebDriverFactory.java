package com.eurotech.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverFactory {



    public static void main(String[] args) {

        //Odev
        //Static bir method olustur ismi getDriver parametre browserType
        //Parametreye gore "chrome" chromedriver "firefox" firefoxdriver" olustursun
        //Method'un return type driver olacak.

    }
    public static WebDriver getDriver(String browserType){

        WebDriver driver =null;

        switch (browserType.toLowerCase(Locale.ROOT)){
            case  "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
        }
        return driver;
    }
}
