package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SubscriptionPage {
    public SubscriptionPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "footer")
    public WebElement footer;

    @FindBy(xpath = "//h2[text()='Subscription']")
    public WebElement subscription;

    @FindBy(id = "susbscribe_email")
    public WebElement susbscribeEmail;

    @FindBy(id = "subscribe")
    public WebElement Sendsubscribe;

    @FindBy(css = "div.form-group") // 'hide' kısmını yazmıyoruz çünkü o değişiyor
    public WebElement flashMessage;
}
