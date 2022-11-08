package com.eurotech.tests.day24_TestBase_BasePage;

import com.eurotech.pages.BasePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase{

    @Test
    public void loginTest() throws InterruptedException {
       LoginPage loginPage = new LoginPage();
       DashboardPage dashboardPage= new DashboardPage();

       loginPage.understandBtn.click();
       loginPage.loginBtnBasePage.click();

       String email= ConfigurationReader.get("usernameTeacher");
       String password= ConfigurationReader.get("passwordTeacher");

       loginPage.emailInput.sendKeys(email);
       loginPage.passwordInput.sendKeys(password);
       loginPage.loginBtnLoginPage.click();

       String expectedText="Welcome Eurotech"; //test case e baslamadan once bize credentials olarak bize verilecek
       String actualText= dashboardPage.welcomeMessage.getText();

       Assert.assertEquals(actualText,expectedText);
       System.out.println("dashboardPage.welcomeMessage.getText() = " + dashboardPage.welcomeMessage.getText());

    }

   @Test
   public void loginWithTeacher() {
       LoginPage loginPage = new LoginPage();
       loginPage.understandBtn.click();
       loginPage.loginBtnBasePage.click();
       DashboardPage dashboardPage = new DashboardPage();
       loginPage.loginTeacher();
       Assert.assertEquals(dashboardPage.welcomeMessage.getText(),"Welcome Eurotech");
   }

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage();
        BrowserUtils.clickWithJS(loginPage.understandBtn);
       // loginPage.understandBtn.click();
        loginPage.loginBtnBasePage.click();
        loginPage.login(ConfigurationReader.get("usernameDeveloper"),ConfigurationReader.get("passwordDeveloper"));
        loginPage.loginBtnLoginPage.click();
    }

    @Test
    public void loginWithStudent() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage= new DashboardPage();

        loginPage.understandBtn.click();
        loginPage.loginBtnBasePage.click();

        String email= ConfigurationReader.get("usernameStudent");
        String password= ConfigurationReader.get("passwordStudent");

        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtnLoginPage.click();

    }

    @Test
    public void window() {
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        BrowserUtils.switchToWindow("New Window");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

    @Test
    public void hover() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img1 = driver.findElement(By.xpath("(//img)[2]"));
        BrowserUtils.hover(img1);

    }
}
