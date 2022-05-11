package com.eurotech.tests.day24_TestBase_BasePage;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void negativeLoginTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage= new DashboardPage();

        loginPage.understandBtn.click();
        loginPage.loginBtnBasePage.click();

        String email= ConfigurationReader.get("usernameTeacher");
        String password= "Test123";

        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtnLoginPage.click();

        String expectedText= "Invalid Credentials!";
        String actualText= loginPage.invalidText.getText();

        Assert.assertEquals(actualText,expectedText);
    }
}
