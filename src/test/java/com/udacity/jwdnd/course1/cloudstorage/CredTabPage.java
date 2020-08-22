package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class CredTabPage {

    protected static WebDriver driver;

    public CredTabPage(WebDriver driver){
        PageFactory.initElements(driver, this);
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

    public void createCredential(String Url, String username, String password) throws InterruptedException {
        sleep(2000);
        addCredentialBtn.click();
        sleep(2000);
        credentialUrlText.sendKeys(Url);
        credentialUsernameText.sendKeys(username);
        credentialPasswordText.sendKeys(password);
        sleep(3000);
        credentialSubmitBtn.click();
        sleep(2000);
        returnLink.click();
        sleep(2000);
    }

    public void editCrednetial(String url, String username, String password) throws InterruptedException {
        sleep(5000);
        editCredentialBtn.click();
        sleep(20000);
        credentialUrlText.clear();
        sleep(5000);
        credentialUsernameText.clear();
        sleep(5000);
        credentialPasswordText.clear();
        sleep(5000);
        credentialUrlText.sendKeys(url);
        sleep(5000);
        credentialUsernameText.sendKeys(username);
        credentialPasswordText.sendKeys(password);
        sleep(10000);
        credentialSubmitBtn.click();
        sleep(2000);
        returnLink.click();
        sleep(2000);
    }

    public void deleteCredntial() throws InterruptedException {
        sleep(2000);
        delCredentialBtn.click();
        sleep(2000);
        returnLink.click();
        sleep(2000);
    }
}
