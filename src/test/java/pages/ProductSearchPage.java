package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ProductSearchPage {
    public ProductSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "#search_product")
    public WebElement searchInput;

    @FindBy(xpath = "//*[@type = 'button' and @id='submit_search']")
    public WebElement searchButton;

    @FindBy(xpath = "//h2[@class='title text-center' and text()='Searched Products']")
    public WebElement searchedProducts;

    // Aranan ürünlerin isimlerini içeren tüm elementleri liste olarak alıyoruz
    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    public List<WebElement> searchedProductNames;
}
