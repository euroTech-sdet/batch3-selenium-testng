package com.eurotech.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        String title = driver.getTitle();

        Thread.sleep(2000);

        driver.close();

        driver=new ChromeDriver();

        driver.get("https://www.google.com");

        Thread.sleep(2000);
        //calistigimiz uzerinde oldugumuz sayfayi kapatir
        driver.close();


       //tum browser i kapatir.
        driver.quit();

    }
}
