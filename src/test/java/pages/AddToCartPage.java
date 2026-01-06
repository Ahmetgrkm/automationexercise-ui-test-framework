package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AddToCartPage {
    public AddToCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    // Sayfadaki tüm "Add to Cart" butonlarını topluca yakalıyoruz
// Not: Locator'ı senin sitene göre (class veya xpath) güncellemelisin.
    @FindBy(xpath = "//div[@class='productinfo text-center']//a[text()='Add to cart']")
    public List<WebElement> allAddToCartButtons;

    // Sepete ekledikten sonra çıkan "Continue Shopping" butonu
    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShoppingButton;


    // Sepetteki her bir ürün satırını yakalar
    @FindBy(xpath = "//table[@id='cart_info_table']//tbody/tr")
    public List<WebElement> cartRows;

    // Sepete git butonu (Eğer popup içindeyse oradan, değilse menüden)
    @FindBy(xpath = "//a[contains(@href, 'view_cart')]")
    public WebElement viewCartButton;
}
