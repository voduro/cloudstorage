package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LoginPage {
    protected static WebDriver driver;
    private final JavascriptExecutor js;

    @FindBy(tagName = "Title")
    private WebElement pageTitle;

    @FindBy(id = "signup-link")
    private WebElement signupLink;

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "loginBtn")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){

        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public String getTitle() {
        return pageTitle.getText();
    }

    public void login(String username, String password) {
        js.executeScript("arguments[0].value='" + username + "';", usernameField);
        js.executeScript("arguments[0].value='" + password + "';", passwordField);
        js.executeScript("arguments[0].click();",  loginButton);

//        usernameField.clear();
//        passwordField.clear();
//
//        usernameField.sendKeys(username);
//        passwordField.sendKeys(password);
//        loginButton.click();

//        return new HomePage(driver);
    }


}
