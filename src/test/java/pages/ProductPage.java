package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductPage {
    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[text()=' Products']")
    public WebElement products;

    @FindBy(xpath = "(//a[contains(@href, '/product_details/')])[1]")
    public WebElement firstProductViewButton;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    public WebElement productName;

    @FindBy(xpath = "//p[contains(text(), 'Category:')]")
    public WebElement category;

    @FindBy(xpath = "//span[contains(text(), 'Rs.')]")
    public WebElement productPrice;

    @FindBy(xpath = "//p[b[contains(text(), 'Availability:')]]")
    public WebElement availability;

    @FindBy(xpath = "//p[b[contains(text(), 'Condition:')]]")
    public WebElement condition;

    @FindBy(xpath = "//p[b[contains(text(), 'Brand:')]]")
    public WebElement brand;

    // Mevcut URL'yi getiren metot
    public String getCurrentPageUrl(){
        return Driver.getDriver().getCurrentUrl();
    }

    // URL'nin belirli bir kelimeyi içerip içermediğini kontrol eden metot
    public boolean isUrlCorrect(String expectedKeyword) {
        return  Driver.getDriver().getCurrentUrl().contains(expectedKeyword);
    }
}




















