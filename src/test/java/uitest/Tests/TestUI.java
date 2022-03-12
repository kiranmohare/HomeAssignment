package uitest.Tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import uitest.Pages.CreditCardPage;
import uitest.Pages.HomePage;

import java.util.Set;

public class TestUI {
    WebDriver driver = null;

    HomePage homePage;
    CreditCardPage creditCardPage;
    String projectPath = System.getProperty("user.dir");

    public static String generateRandomEmailAddress(String domain) {
        String emailAddress = "";
        // Generate random email address
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        while (emailAddress.length() < 5) {
            int character = (int) (Math.random() * 26);
            emailAddress += alphabet.substring(character, character + 1);
        }
        emailAddress += Integer.valueOf((int) (Math.random() * 99))
                .toString();
        emailAddress += "@" + domain;
        return emailAddress;
    }

    @BeforeTest
    public void setup(){
        System.setProperty("WebDriver.chrome.driver", projectPath +"\\src\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://finanzen.check24.de/accounts/d/kreditkarte/result.html");
    }

    @Test(priority = 2)
    public void testCookie(){
        Set<Cookie> cookiesList =  driver.manage().getCookies();
        for(Cookie cookie :cookiesList) {
            if(cookie.equals("ppset=kreditkarte")){
                Assert.assertTrue(true, "cookie present");
            }
            else{
                Assert.assertTrue(false, "cookie not present");
            }
        }
    }

    @Test(priority = 1)
    public void testCreditCardPage() throws InterruptedException{
        homePage = new HomePage(driver);
        creditCardPage = new CreditCardPage(driver);
        homePage.acceptPrivacyPolicy();
        homePage.clickWeiterBtn();
        String email = generateRandomEmailAddress("gmail.com");
        creditCardPage.provideEmailValue(email);
        creditCardPage.clickGuestloginCheckBox();
        creditCardPage.clickGuestloginCheckBox();
        creditCardPage.clickWeiterBtn();
        Thread.sleep(2000);
        creditCardPage.clickWeiterBtn();
        Assert.assertEquals(creditCardPage.isGenderErrorMsgDisplayed(), true, "Error message displayed for not selecting gender");
        Assert.assertEquals(creditCardPage.isVornameErrorMessageDisplayed(), true, "Error message displayed for empty firstname");
        Assert.assertEquals(creditCardPage.isNachnameErrorMessageDisplayed(), true, "Error message displayed for empty lastname");
        Assert.assertEquals(creditCardPage.isDOBErrorMessageDisplayed(), true, "Error message displayed for empty DOB");
        Assert.assertEquals(creditCardPage.isMobileNumberErrorMessageDisplayed(), true, "Error message displayed for empty mobile number");
        Assert.assertEquals(creditCardPage.isEmailErrorMessageDisplayed(), true, "Error message displayed for empty email address");
    }
}
