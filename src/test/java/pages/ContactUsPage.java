package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactUsPage {
    public ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(@href, 'contact_us')]")
    public WebElement ContactUsLink;

    @FindBy(xpath = "//*[text()='Get In Touch']")
    public WebElement GetInTouchMessage;

    @FindBy(css = "[data-qa='name']")
    public WebElement NameInput;

    @FindBy(css = "[data-qa='email']")
    public WebElement emailInput;

    @FindBy(css = "[data-qa='subject']")
    public WebElement subjectInput;

    @FindBy(css = "[data-qa='message']")
    public WebElement messageInput;

    @FindBy(xpath = "//*[@type='file' and @name='upload_file']")
    public WebElement uploadFile;

    @FindBy(css = "[data-qa='submit-button']")
    public WebElement  submitButton;

    @FindBy(xpath = "//a[contains(@href, '/')]")
    public WebElement HomePageButton;
}
