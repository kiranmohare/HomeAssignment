package uitest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCardPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"cl_login\"]")
    WebElement emailBox;

    @FindBy(xpath = "//*[contains(text(), \"weiter\")]")
    WebElement weiterBtn;

    @FindBy(xpath = "//*[contains(text(), \"Ich möchte als Gast fortfahren\")]")
    WebElement guestOption;

    //error messages Web Elements
    @FindBy(xpath = "//*[contains(text(), \"Bitte wählen Sie Ihre Anrede aus.\")]")
    WebElement genderErrorMsg;

    @FindBy(xpath = "//*[contains(text(), \"Bitte geben Sie Ihren Vornamen an.\")]")
    WebElement vornameErrorMsg;

    @FindBy(xpath = "//*[contains(text(), \"Bitte geben Sie Ihren Nachnamen an.\")]")
    WebElement nachnameErrorMsg;

    @FindBy(xpath = "//*[contains(text(), \"Bitte geben Sie Ihr Geburtsdatum an.\")]")
    WebElement dobErrorMsg;

    @FindBy(xpath = "//*[@id=\"application-form\"]/div/div[1]/div[2]/div[2]/div[2]/form/section[1]/div[4]/div[1]/div[1]/div[2]/label")
    WebElement mobileNumberErrorMsg;

    @FindBy(xpath = "//*[contains(text(), \"Für den Versand der Antragsbestätigung benötigen wir Ihre E-Mail-Adresse.\")]")
    WebElement emailErrorMsg;

    @FindBy(xpath = "//*[@for=\"GENDER_FEMALE\"]")
    WebElement femaleCheckbox;

    @FindBy(xpath = "//*[@for=\"GENDER_MALE\"]")
    WebElement maleCheckbox;

    @FindBy(xpath = "//*[@id=\"GIVEN_NAME\"]")
    WebElement firstNameField;

    @FindBy(xpath = "//*[@id=\"application-form\"]/div/div[1]/div[2]/div[2]/div[2]/form/section[1]/div[2]/div/div[1]/div[1]/div[2]/div")
    WebElement lastNameField;

    @FindBy(xpath = "//*[@id=\"DATE_OF_BIRTH\"]")
    WebElement DOBField;

    @FindBy(xpath = "//*[@id=\"PHONENUMBER_MOBILE\"]")
    WebElement mobileField;

    @FindBy(xpath = "//*[@id=\"CONTACT_EMAIL\"]")
    WebElement emailField;

    public CreditCardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void provideEmailValue(String value){
        emailBox.click();
        emailBox.sendKeys(value);
    }

    public void clickWeiterBtn(){
        weiterBtn.click();
    }

    public void clickGuestloginCheckBox(){
        guestOption.click();
    }

    public boolean isGenderErrorMsgDisplayed(){
        return genderErrorMsg.isDisplayed();
    }

    public boolean isVornameErrorMessageDisplayed(){
        return vornameErrorMsg.isDisplayed();
    }

    public boolean isNachnameErrorMessageDisplayed(){
        return nachnameErrorMsg.isDisplayed();
    }

    public boolean isDOBErrorMessageDisplayed(){
        return dobErrorMsg.isDisplayed();
    }

    public boolean isMobileNumberErrorMessageDisplayed(){
        return mobileNumberErrorMsg.isDisplayed();
    }

    public boolean isEmailErrorMessageDisplayed(){
        return emailErrorMsg.isDisplayed();
    }
}
