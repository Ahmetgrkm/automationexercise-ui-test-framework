package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Recommended_itemsPage {
    public Recommended_itemsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    // başlık doğrulaması
    @FindBy(xpath = "//h2[text()='recommended items']")
    public WebElement recommendedHeader;

    // 2. Tavsiye edilen ürünlerin "Add to Cart" butonları
    @FindBy(xpath = "//div[@id='recommended-item-carousel']//a[@data-product-id]")
    public List<WebElement> recommendedAddToCartBtns;

    // 3. Sağ taraftaki kaydırma butonu (Ok işareti)
    @FindBy(xpath = "//a[@class='right recommended-item-control']")
    public WebElement nextButton;
}


















