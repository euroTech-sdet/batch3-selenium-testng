package com.eurotech.tests.day24_TestBase_BasePage;

import com.eurotech.pages.BasePage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase{

    @Test
    public void loginTest() throws InterruptedException {


       LoginPage loginPage = new LoginPage();
       loginPage.understandBtn.click();
       loginPage.loginBtnBasePage.click();

    }

}
