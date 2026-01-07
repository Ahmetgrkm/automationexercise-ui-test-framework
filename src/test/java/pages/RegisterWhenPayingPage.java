package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterWhenPayingPage {
    public  RegisterWhenPayingPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Proceed To Checkout']")
    public WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//u[text()='Register / Login']")
    public WebElement registerBtn;

    @FindBy(css = "[data-qa='continue-button']")
    public WebElement continueBtn;

    @FindBy(xpath = "//*[@class ='form-control' and @name='message']")
    public WebElement messageBox;

    @FindBy(xpath = "//*[text()='Place Order']")
    public WebElement placeOrderBtn;

    @FindBy(css = ".active")
    public WebElement paymentPageVerification;

    @FindBy(css = "[data-qa='name-on-card']")
    public WebElement nameOnCard;

    @FindBy(css = "[data-qa='card-number']")
    public WebElement cardNumber;

    @FindBy(css = "[data-qa='cvc']")
    public WebElement cvc;

    @FindBy(css = "[data-qa='expiry-month']")
    public WebElement expiry_month;

    @FindBy(css = "[data-qa='expiry-year']")
    public WebElement expiry_year;

    @FindBy(css = "[data-qa='pay-button']")
    public WebElement payButton;

    @FindBy(xpath = "//*[text()='Congratulations! Your order has been confirmed!']")
    public WebElement OrderPlaced;

}



















