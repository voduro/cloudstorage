package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class SignupPage {
    protected static WebDriver driver;
    private final JavascriptExecutor js;

    @FindBy(tagName = "Title")
    private WebElement pageTitle;

    @FindBy(id = "login-link")
    private WebElement loginLink;

    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(name = "lastName")
    private WebElement lastNameField;

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signupBtn")
    private WebElement signupButton;

    public SignupPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }


    public String getTitle() {
        return pageTitle.getText();
    }

    public void signup(String firstName, String lastName, String username, String password){
        js.executeScript("arguments[0].value='" + firstName + "';", firstNameField);
        js.executeScript("arguments[0].value='" + lastName + "';", lastNameField);
        js.executeScript("arguments[0].value='" + username + "';", usernameField);
        js.executeScript("arguments[0].value='" + password + "';", passwordField);
        js.executeScript("arguments[0].click();", signupButton);

//        firstNameField.clear();
//        lastNameField.clear();
//        usernameField.clear();
//        passwordField.clear();
//
//        firstNameField.sendKeys(firstName);
//        lastNameField.sendKeys(lastName);
//        usernameField.sendKeys(username);
//        passwordField.sendKeys(password);
//        signupButton.click();
    }


}
