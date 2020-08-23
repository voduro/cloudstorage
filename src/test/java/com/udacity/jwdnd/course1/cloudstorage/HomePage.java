package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class HomePage {

    protected static WebDriver driver;
    private final JavascriptExecutor js;

    @FindBy(tagName = "Title")
    private WebElement pageTitle;

    @FindBy(name = "logoutBtn")
    private WebElement logoutButton;

    @FindBy(id = "nav-files-tab")
    private WebElement filesTab;

    /// just doesnt work for some reason
    //*[@id="nav-notes-tab"]
    //*[@id="nav-notes-tab"]

//    #nav-notes-tab
    @FindBy(name = "notesTab")
    private WebElement notesTab;

    private By notesTabBy = By.name("notesTab");


    @FindBy(id = "nav-credentials-tab")
    private WebElement credentialsTab;



    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public String getTitle() {
        return pageTitle.getText();
    }

    public void logout(){
        logoutButton.submit();
    }

    public void navNotes() throws InterruptedException{
        js.executeScript("arguments[0].click();", notesTab);
//        sleep(2000);
//        notesTab.click();
    }
    public void navCredentials() throws InterruptedException{
        js.executeScript("arguments[0].click();", credentialsTab);
//        sleep(2000);
//        credentialsTab.click();
    }



//
//
//    }
//
//    public void getLogout(){
//        driver.findElement(logoutBy).click();
////        return new SignUpPage(driver);
//    }
//
//    public void navNotes() throws InterruptedException{
//        driver.findElement(navNotesTabBy).click();
//        sleep(2000);
//    }
//
//    public void navCredentials() throws InterruptedException{
//        driver.findElement(navCredTabBy).click();
//        sleep(2000);
//    }
//
//    public void delCred(){
//
//    }

//
//    public void createCredentials(String url, String username, String password )throws InterruptedException{
//        driver.findElement(addCredBtnBy).click();
//        sleep(5000);
//        driver.findElement(credUrlBy).sendKeys(url);
//        driver.findElement(credUsernameBy).sendKeys(username);
//        driver.findElement(credPasswordBy).sendKeys(password);
//        sleep(5000);
//        driver.findElement(credSubmit).submit();
//        sleep(5000);
//
//        //*[@id="nav-notes"]/button
////*[@id="nav-notes-tab"]
//    }

}
