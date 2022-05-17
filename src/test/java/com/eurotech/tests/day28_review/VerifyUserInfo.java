package com.eurotech.tests.day28_review;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.ProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {

    /*
    --Login as teacher
    --Verify that login is successful
    --Click on Edit Profile button
    --Verify that Github name is eurotech123
    --Click on Go Back button
    --Verify that user's title is Test Automation Engineer
     */

    @Test
    public void userInfo() {

        DashboardPage dashboardPage = new DashboardPage();
        ProfilePage profilePage = new ProfilePage();
        extentLogger= report.createTest("User Info Verification");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Click understand button");
        loginPage.understandBtn.click();

        extentLogger.info("Click on login button");
        loginPage.loginBtnBasePage.click();

        extentLogger.info("Enter Username");
        loginPage.emailInput.sendKeys(ConfigurationReader.get("usernameTeacher"));

        extentLogger.info("Enter Password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));

        extentLogger.info("Click Login Button");
        loginPage.loginBtnLoginPage.click();

        //                 Dashboard               //

        String expectedMessage= "Welcome Eurotech";
        String actualMessage = new DashboardPage().welcomeMessage.getText();

        extentLogger.info("Verify that message is "+expectedMessage);
        Assert.assertEquals(actualMessage,expectedMessage);

        extentLogger.info("Click on edit profile button");
        dashboardPage.editProfile.click();

        extentLogger.info("Get username info");
        String actualName=profilePage.githubUsername.getAttribute("value");
        String expectedName= "eurotech123";

        extentLogger.info("Verify that guthub username is "+expectedName);
        Assert.assertEquals(actualName,expectedName);

        extentLogger.info("Click on go back button");
        profilePage.goBackBtn.click();

        String expectedUsersTitle= "Test Automation Engineer";
        String actualUsersTitle= dashboardPage.usersTitle.getText();

        extentLogger.info("Verify that user's title is "+expectedUsersTitle);
        Assert.assertEquals(actualUsersTitle,expectedUsersTitle);

        extentLogger.pass("Passed");

    }
}
