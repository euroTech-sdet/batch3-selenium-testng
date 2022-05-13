package com.eurotech.tests.day27_ExtentReports;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    @Test
    public void wrongUsernameTest() {
        // Name of the Test
        extentLogger =report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage= new DashboardPage();

        loginPage.understandBtn.click();
        loginPage.loginBtnBasePage.click();

        loginPage.emailInput.sendKeys("eurotech@gmail");
        extentLogger.info("Enter wrong username");

        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        extentLogger.info("Enter Teacher Password");
        loginPage.loginBtnLoginPage.click();

        String expectedText="Welcome Eurotech"; //test case e baslamadan once bize credentials olarak bize verilecek
        String actualText= dashboardPage.welcomeMessage.getText();

        Assert.assertEquals(actualText,expectedText);
        System.out.println("dashboardPage.welcomeMessage.getText() = " + dashboardPage.welcomeMessage.getText());

    }

    @Test
    public void wrongPassword() {
        //Name of the Test
        extentLogger=report.createTest("Negative Login Test");

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        loginPage.understandBtn.click();
        loginPage.loginBtnBasePage.click();

        String email = ConfigurationReader.get("usernameTeacher");
//        String password = ConfigurationReader.get("passwordTeacher");

        loginPage.emailInput.sendKeys(email);
        extentLogger.info("Entering valid username");
        loginPage.passwordInput.sendKeys("test12345!");
        extentLogger.info("Entering password username");
        loginPage.loginBtnLoginPage.click();
        extentLogger.info("Click on login button");
        String expectedText = "Welcome Eurotech"; //test case e baslamadan once bize credentials olarak bize verilecek
        String actualText = dashboardPage.welcomeMessage.getText();

        Assert.assertEquals(actualText,expectedText);
        System.out.println("dashboardPage.welcomeMessage.getText() = " + dashboardPage.welcomeMessage.getText());
    }
}
