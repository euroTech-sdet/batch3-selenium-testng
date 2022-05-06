package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

//    @FindBy(id = "user-name")
//    public WebElement usernameInput;

    @FindBy(xpath = "//input[@data-test='username']")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(css = ".submit-button.btn_action")
    public WebElement loginButton;


//    @FindAll({
//            @FindBy(id = "login-buttonn"),
//            @FindBy(name = "login-button"),
//            @FindBy(xpath = "//input[@data-test='login-button']")
//    })
//    public WebElement loginButton;

//    @FindBys({
//            @FindBy(id = "login-button"),
//            @FindBy(name = "login-button")
//    })
//    public WebElement loginButton;

}
