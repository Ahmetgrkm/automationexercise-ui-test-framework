package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class viewProductAndReviewPage {
    public viewProductAndReviewPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(@href, 'reviews')]")
    public WebElement writeYourReview;

    @FindBy(css = "#name")
    public WebElement name;

    @FindBy(css = "#email")
    public WebElement email;

    @FindBy(css = "#review")
    public WebElement review;

    @FindBy(css = "#button-review")
    public WebElement submitBtn;

    @FindBy(xpath = "//*[@id='review-section']//span")
    public WebElement reviewSuccessMessage;
}
