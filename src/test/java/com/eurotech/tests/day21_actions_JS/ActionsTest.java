package com.eurotech.tests.day21_actions_JS;

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

public class ActionsTest {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void actionsTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");
        Thread.sleep(2000);
        WebElement img1 = driver.findElement(By.xpath("(//img)[2]"));

       // Actions actions = new Actions(driver);
       // actions.moveToElement(img1).perform();

        WebElement view_profile = driver.findElement(By.linkText("View profile"));
        System.out.println("view_profile.getText() = " + view_profile.getText());
        Assert.assertTrue(view_profile.isDisplayed());

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.cssSelector("#droppable"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(source,target).perform();
        Thread.sleep(2000);

       String  actualText=driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
       String expectedText="Dropped!";

       Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void dragAndDrop2() {
        driver.get("https://demoqa.com/droppable");

        WebElement source = driver.findElement(By.cssSelector("#draggable"));
        WebElement target = driver.findElement(By.cssSelector("#droppable"));

        Actions actions = new Actions(driver);

        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(4000).release().perform();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
