package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class RemoveFromCartPage {
    public RemoveFromCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".cart_quantity_delete")
    public List<WebElement> deleteButtons;

    @FindBy(xpath = "//*[text()='Cart is empty!']")
    public WebElement cartIsEmpty;


}
