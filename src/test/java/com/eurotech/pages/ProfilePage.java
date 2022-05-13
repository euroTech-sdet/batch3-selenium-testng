package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    @FindBy(name = "githubusername")
    public WebElement githubUsername;

    @FindBy(linkText = "Go Back")
    public WebElement goBackBtn;
}
