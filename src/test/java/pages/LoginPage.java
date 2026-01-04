package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this); // BU SATIR EKSİKSE NPE ALIRSIN!
    }

    @FindBy(xpath = "//*[text()='Features Items']")
    public WebElement HomePageAssert;

    @FindBy(xpath = "//*[text()='Login to your account']")
    public WebElement LoginYourAccount;

    @FindBy(xpath = "//*[text()='Your email or password is incorrect!']")
    public WebElement HataliGiris;

    @FindBy(css = "[data-qa='login-email']")
    public WebElement Loginemail;

    @FindBy(css = "[data-qa='login-password']")
    public WebElement Loginpassword;

    @FindBy(css = "[data-qa='login-button']")
    public WebElement Loginbutton;

    @FindBy(xpath = "//li//a[text()=' Logged in as']")
    public WebElement LoginMessage;

    @FindBy(xpath = "//a[contains(@href, 'delete_account')]")
    public WebElement deleteAccount;

    @FindBy(xpath = "//a[contains(@href, 'logout')]")
    public WebElement Logout;

    @FindBy(css = "[data-qa='account-deleted']")
    public WebElement AccountdeletedMessage;
}
