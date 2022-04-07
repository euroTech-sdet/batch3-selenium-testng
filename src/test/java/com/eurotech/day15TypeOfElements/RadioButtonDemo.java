package com.eurotech.day15TypeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class RadioButtonDemo {


    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");
        driver.manage().window().maximize();

    //    driver.findElement(By.xpath("(//div[@class='o-chk '])[2]")).click();
      WebElement legume= driver.findElement(By.xpath("//div[text()='Legumes']"));
      WebElement vegetables= driver.findElement(By.xpath("//div[text()='Vegetables']/../div[1]"));

      legume.click();

        System.out.println("legume.isSelected() = " + legume.isSelected());
        System.out.println("vegetables.isSelected() = " + vegetables.isSelected());


        driver.close();
    }

    @Test
    public void test2() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)"));
        System.out.println("element.isSelected() = " + element.isSelected());

        WebElement element2 = driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)"));

        System.out.println("element2.isSelected() = " + element2.isSelected());


        driver.close();
    }
}
