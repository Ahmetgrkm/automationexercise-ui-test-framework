package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class upArrowPage {
    public upArrowPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//i[contains(@class ,'fa fa-angle-up')]")
    public WebElement upArrow;

    @FindBy(xpath = "//*[text()='Full-Fledged practice website for Automation Engineers']")
    public WebElement message;
}
