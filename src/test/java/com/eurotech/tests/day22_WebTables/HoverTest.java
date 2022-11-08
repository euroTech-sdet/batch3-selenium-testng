package com.eurotech.tests.day22_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;
import java.util.List;

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

    @Test
    public void tables() {
        driver.get("https://demoqa.com/webtables");
        WebElement beforeUpdates = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[3]/div/div[1]"));
        System.out.println("beforeUpdates.getText() = " + beforeUpdates.getText());
        WebElement lastNameColumn = driver.findElement(By.xpath("//div[text()='Last Name']"));
     //   lastNameColumn.click();

        System.out.println("beforeUpdates.2 = " + beforeUpdates.getText());

        WebElement afterUpdates = driver.findElement(By.xpath("//div[@class='rt-tbody']//div[.='Kierra']"));
        System.out.println("afterUpdates.getText() = " + afterUpdates.getText());

        //how we gonna use this dynamic code
        //print Cierra infos
        lastNameColumn.click();

        List<WebElement> infoCierra = driver.findElements(By.xpath("//div[@class='rt-tbody']/div[1]/div/div"));
        for (WebElement element : infoCierra) {
            System.out.println("cierra  = " + element.getText());
        }

        List<WebElement> cierraDynamic = driver.findElements(By.xpath("//div[text()='Cierra']/../div"));
        for (WebElement element : cierraDynamic) {
            System.out.println("dynamic = " + element.getText());
        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

