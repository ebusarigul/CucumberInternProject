package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent{

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(id="mat-input-0")
    private WebElement username;

    @FindBy(id="mat-input-1")
    private WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath="(//span[contains(text(),'Dashboard')])[2]")
    private WebElement dashboard;

    @FindBy(xpath="//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath="//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath="//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath="//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;

    @FindBy(xpath="//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priority;

    @FindBy(xpath="//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

    @FindBy(xpath = "//ms-text-field[@placeholder=\"GENERAL.FIELD.NAME\"]/input")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogButton;

    @FindBy(xpath = "//*[text()='Accept all cookies']")
    private WebElement acceptAllCookies;

    //------------------------------------------------------

    @FindBy(xpath = "(//mat-select[@role=\"combobox\"])[3]")
    private WebElement classroomSelect;

    @FindBy(xpath = "//span[text()=\" Other \"]")
    private WebElement other;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='capacity']//input")
    private WebElement capacity;

    @FindBy(xpath = "(//ms-edit-button//button)[1]")
    private WebElement editButton;

    @FindBy(xpath = "(//mat-slide-toggle)[1]")
    private WebElement slideToggle;

    @FindBy(xpath = "//span[text()=\"Section\"]")
    private WebElement section;


    WebElement myElement;
    public void findAndSend(String strElement, String value){  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement)
        {
            case "username" : myElement =username; break;
            case "password" : myElement =password; break;
            case "nameInput" : myElement =nameInput; break;
            case "codeInput" : myElement =codeInput; break;
            case "shortName" : myElement =shortName; break;
            case "searchInput" : myElement =searchInput; break;
            case "integrationCode" : myElement =integrationCode; break;
            case "priority" : myElement =priority; break;
            case "capacity" : myElement =capacity; break;
        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement){  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement)
        {
            case "loginButton" : myElement =loginButton; break;
            case "addButton" : myElement =addButton; break;
            case "saveButton" : myElement =saveButton; break;
            case "closeDialog" : myElement =closeDialog; break;
            case "searchButton" : myElement =searchButton; break;
            case "deleteButton" : myElement =deleteButton; break;
            case "deleteDialogButton" : myElement =deleteDialogButton; break;
            case "acceptAllCookies" : myElement =acceptAllCookies; break;
            case "classroomSelect" : myElement =classroomSelect; break;
            case "other" : myElement =other; break;
            case "editButton" : myElement =editButton; break;
            case "slideToggle" : myElement =slideToggle; break;
            case "section" : myElement =section; break;
        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text){  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement)
        {
            case "dashboard" : myElement =dashboard; break;
            case "successMessage" : myElement =successMessage; break;
            case "alreadyExist" : myElement =alreadyExist; break;
        }

        verifyContainsText(myElement,text);
    }

    public void searchAndDelete(String searchText){

        findAndSend("searchInput",searchText);//arama kutucuguna kelimeyi yaz
        findAndClick("searchButton");//arama butonuna bas

        waitUntilLoading();

        //GWD.Bekle(2);  // TODO: incelenecek
        findAndClick("deleteButton");//silme butonuna bas
        findAndClick("deleteDialogButton");//dialogdaki silme butonuna bas

    }

}


