package com.eurotech.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class Test {
    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/sortable");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"userName\"]"));


        Thread.sleep(3000);
        System.out.println("driver.= " + driver.findElement(By.xpath("//div[@class='list-group-item list-group-item-action']")).getText());

        Thread.sleep(2000);

        driver.close();
    }
}
