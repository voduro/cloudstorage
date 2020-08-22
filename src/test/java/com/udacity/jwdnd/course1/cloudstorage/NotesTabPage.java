package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

import static java.lang.Thread.sleep;

public class NotesTabPage {
    protected static WebDriver driver;

    @FindBy(id="nav-notes-tab")
    private WebElement notesTab;

    private By notesTabBy = By.name("notesTab");

    @FindBy(name = "saveChangesButton" )
    private WebElement saveChangesBtn;

    @FindBy(name = "noteTitle")
    private WebElement noteTitleText;

    @FindBy(name = "noteDescription")
    private WebElement noteDescriptionText;

    //*[@id="nav-notes"]/button
    @FindBy(id = "addNoteBtn")
    private WebElement addNoteBtn;

    @FindBy(name = "editNote")
    private WebElement editNoteBtn;

    @FindBy(name = "delNote")
    private WebElement delNoteBtn;

    @FindBy(linkText = "here")
    private WebElement returnLink;

    public NotesTabPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public HomePage navNotes(WebDriver driver) throws InterruptedException{
//        WebDriverWait wait = new WebDriverWait(driver, 1000);
//        wait.until(ExpectedConditions.elementToBeClickable(notesTab));
        notesTab.click();
//        sleep(2000);
        return new HomePage(driver);
    }

    public void createNote(String title, String description)throws InterruptedException{
        sleep(2000);
        addNoteBtn.click();
        sleep(2000);
        noteTitleText.sendKeys(title);
        noteDescriptionText.sendKeys(description);
        sleep(2000);
        saveChangesBtn.click();
        sleep(2000);
        returnLink.click();
        sleep(2000);
    }

    public void editNote(String title, String description) throws InterruptedException {
        sleep(2000);
        editNoteBtn.click();
        sleep(2000);
        noteTitleText.clear();
        noteDescriptionText.clear();
        noteTitleText.sendKeys(title);
        noteDescriptionText.sendKeys(description);
        sleep(2000);
        saveChangesBtn.click();
        sleep(2000);
        returnLink.click();
        sleep(2000);
    }

    public void deleteNote() throws InterruptedException {
        sleep(2000);
        delNoteBtn.click();
        sleep(2000);
        returnLink.click();
        sleep(2000);
    }
}
