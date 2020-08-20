package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class HomePage {

    protected static WebDriver driver;

    @FindBy(tagName = "Title")
    private WebElement pageTitle;

    @FindBy(name = "logoutBtn")
    private WebElement logoutButton;

    @FindBy(id = "nav-files-tab")
    private WebElement filesTab;

    /// just doesnt work for some reason
    //*[@id="nav-notes-tab"]
//    #nav-notes-tab
    @FindBy(linkText = "Notes")
    private WebElement notesTab;


    private By notesTabBy = By.name("notesTab");

    @FindBy(id = "nav-credentials-tab")
    private WebElement credentialsTab;

    @FindBy(id = "noteSubmit")
    private WebElement noteSubmitBtn;

    @FindBy(name = "noteTitle")
    private WebElement noteTitleText;

    @FindBy(name = "noteDescription")
    private WebElement noteDescriptionText;

    //*[@id="nav-notes"]/button
    @FindBy(xpath = "//*[@id='nav-notes']/button")
    private WebElement addNoteBtn;

    @FindBy(name = "editNote")
    private WebElement editNoteBtn;

    @FindBy(name = "delNote")
    private WebElement delNoteBtn;

    @FindBy(name = "addCredential")
    private WebElement addCredentialBtn;

    @FindBy(id = "credentialSubmit")
    private WebElement credentialSubmitBtn;

    @FindBy(name = "url")
    private WebElement credentialUrlText;

    @FindBy(name = "username")
    private WebElement credentialUsernameText;

    @FindBy(name = "password")
    private WebElement credentialPasswordText;

    @FindBy(name = "editCredential")
    private WebElement editCredentialBtn;

    @FindBy(name = "delNote")
    private WebElement delCredentialBtn;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return pageTitle.getText();
    }

    public void logout(){
        logoutButton.submit();
    }

    public void navNotes(WebDriver driver) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 1000);

        WebElement tabMarker = wait.until(ExpectedConditions.elementToBeClickable(notesTab));
//        driver.findElement(notesTabBy).click();
        notesTab.click();
        sleep(5000);
    }

    public void navCredentials() throws InterruptedException{
        credentialsTab.click();
        sleep(2000);
    }

    public void createNote(String title, String description)throws InterruptedException{
        sleep(5000);

        addNoteBtn.click();
        noteTitleText.sendKeys(title);
        noteDescriptionText.sendKeys(description);
        noteSubmitBtn.click();
    }

    public void editNote(String title, String description){
        notesTab.click();
        editNoteBtn.submit();
        noteTitleText.sendKeys(title);
        noteDescriptionText.sendKeys(description);
        noteSubmitBtn.click();
    }

    public void deleteNote(){
        notesTab.click();
        delNoteBtn.click();
    }

    public void createCredential(String Url, String username, String password){

        addCredentialBtn.click();
        credentialUrlText.sendKeys(Url);
        credentialUsernameText.sendKeys(username);
        credentialPasswordText.sendKeys(password);
        credentialSubmitBtn.click();
    }

    public void editCrednetial(String url, String username, String password){
        notesTab.click();
        editNoteBtn.click();
        credentialUrlText.sendKeys(url);
        credentialUsernameText.sendKeys(username);
        credentialPasswordText.sendKeys(password);
        credentialSubmitBtn.click();
    }

    public void deleteCredntial(){
        notesTab.click();
        delNoteBtn.click();
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
