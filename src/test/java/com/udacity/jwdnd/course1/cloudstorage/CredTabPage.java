package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class CredTabPage {

    protected static WebDriver driver;
    private final JavascriptExecutor js;

    public CredTabPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(id = "addCredential")
    private WebElement addCredentialBtn;

    @FindBy(id="saveCredChanges")
    private WebElement credentialSubmitBtn;

    @FindBy(name = "url")
    private WebElement credentialUrlText;

    @FindBy(name = "username")
    private WebElement credentialUsernameText;

    @FindBy(name = "password")
    private WebElement credentialPasswordText;

    @FindBy(name = "editCredential")
    private WebElement editCredentialBtn;

    @FindBy(name = "delCredential")
    private WebElement delCredentialBtn;

    @FindBy(linkText = "here")
    private WebElement returnLink;

    public void createCredential(String url, String username, String password) throws InterruptedException {
        js.executeScript("arguments[0].click();",addCredentialBtn);
        js.executeScript("arguments[0].value='" + url + "';", credentialUrlText);
        js.executeScript("arguments[0].value='" + username + "';", credentialUsernameText);
        js.executeScript("arguments[0].value='" + password + "';", credentialPasswordText);
        js.executeScript("arguments[0].click();", credentialSubmitBtn);
        js.executeScript("arguments[0].click();", returnLink);
    }

    public void editCrednetial(String url, String username, String password) throws InterruptedException {
        js.executeScript("arguments[0].click();",addCredentialBtn);
        js.executeScript("arguments[0].value='" + url + "';", credentialUrlText);
        js.executeScript("arguments[0].value='" + username + "';", credentialUsernameText);
        js.executeScript("arguments[0].value='" + password + "';", credentialPasswordText);
        js.executeScript("arguments[0].click();", credentialSubmitBtn);
//        js.executeScript("arguments[0].click();", returnLink);
    }

    public void deleteCredntial() throws InterruptedException {
        js.executeScript("arguments[0].click();", delCredentialBtn);
        js.executeScript("arguments[0].click();", returnLink);
    }
}
