package uitest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"501100\"]//div[@class=\"product-panel__controls__button\"]")
    WebElement furtherBtn;

    @FindBy(xpath = "//*[@class = \"c24-cookie-consent-button\" and contains(text(), \"Akzeptieren\")]")
    WebElement privacyPolicy;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWeiterBtn(){
        furtherBtn.click();
    }

    public void acceptPrivacyPolicy(){
        privacyPolicy.click();
    }
}
