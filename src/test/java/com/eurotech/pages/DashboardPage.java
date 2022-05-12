package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//p[text()=' Welcome ']")
    public WebElement welcomeMessage;

    @FindBy(className = "nav__menu-item")
    public List<WebElement> dashboardMenus;

    @FindBy(xpath = "//a[text()='All Posts']")
    public WebElement allPostsMenu;

    @FindBy(xpath = "//a[text()='Developers']")
    public WebElement developersMenu;

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccountMenu;

    @FindBy(xpath = "//span[text()='Logout']")
    public WebElement logOutButton;

}
