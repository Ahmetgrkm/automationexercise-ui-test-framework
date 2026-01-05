package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestCasePage {
    public TestCasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[contains(@href, 'test_cases')]")
    public WebElement testCaseBtn;

    @FindBy(xpath = "//*[text()='Test Cases']")
    public WebElement testCase;
}
