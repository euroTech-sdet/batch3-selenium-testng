package com.eurotech.tests.day26_POM;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class DashboardTest extends TestBase {

    /**
        Go to http://www.eurotech.study/
        Enter teacher credentials
        Get the text of the dashboard menus
  */


    @Test
    public void dashboardMenus() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        Thread.sleep(1000);
        loginPage.understandBtn.click();
        //Thread.sleep(1000);
        loginPage.loginBtnBasePage.click();

//        loginPage.emailInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
//        loginPage.passwordInput.sendKeys("passwordTeacher");
//        loginPage.loginBtnLoginPage.click();

        loginPage.loginTeacher();
        Thread.sleep(2000);

        //List<WebElement> dashboardMenuList = dashboardPage.dashboardMenus;

        for (WebElement menuName : dashboardPage.dashboardMenus) {
            System.out.println("menuName.getText() = " + menuName.getText());
        }
    }

    @Test
    public void navigateToMenu() throws InterruptedException {

        /**
         Go to http://www.eurotech.study/
         Enter teacher credentials
         Navigate to All Posts menu and then
         Navigate to Developers menu back
         */

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        loginPage.understandBtn.click();
        //Thread.sleep(1000);
        loginPage.loginBtnBasePage.click();

        loginPage.loginTeacher();

//        dashboardPage.allPostsMenu.click();
//        Thread.sleep(1000);
         dashboardPage.navigateToMenu("All Posts");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

//        dashboardPage.developersMenu.click();
        dashboardPage.navigateToMenu("Developers");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        actions.moveToElement(dashboardPage.myAccountMenu).perform();
        //dashboardPage.myAccountMenu.click();

        dashboardPage.logOutButton.click();

        System.out.println("After logging out = " + driver.getCurrentUrl());


    }
}
