package com.eurotech.tests.day16TypeOfElements2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

public class PopUpAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
    }

    @Test
    public void popUp() throws InterruptedException {

        driver.get("https://www.primefaces.org/primeng/#/confirmpopup");
        Thread.sleep(1000);
         driver.findElement(By.xpath("(//*[text()='Confirm'])[1]")).click();
         driver.findElement(By.xpath("//span[text()='Yes']")).click();

    }

    //@Test
    public void test3() {

        System.out.println("Gerek yok");
    }

    @Test
    public void jSalert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();


        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        Thread.sleep(2000);
        alert.dismiss();

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        alert.sendKeys("Eurotech");
        alert.accept();

        //odev
        //https://the-internet.herokuapp.com/javascript_alerts adresine git
        //her bir js alert ti tikla ve asagida beliren yaziyin textini alip verify et.
        //expectedText = You successfully clicked an alert
        //actualText =

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }
}
