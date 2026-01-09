package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AddressVerificationPage {
    public AddressVerificationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    // Teslimat Adres Bloğunun Tamamı
    @FindBy(xpath = "//ul[@id='address_delivery']")
    public WebElement deliveryAddressBlock;

    // Fatura Adres Bloğunun Tamamı
    @FindBy(xpath = "//ul[@id='address_invoice']")
    public WebElement billingAddressBlock;

    // Eğer adresin içindeki satırlara tek tek ulaşmak istersen (Örn: Sadece Şehir)
    @FindBy(xpath = "//ul[@id='address_delivery']//li")
    public List<WebElement> deliveryAddressDetails;

    // "Place Order" butonu (Bir sonraki adım için)
    @FindBy(xpath = "//a[@href='/payment']")
    public WebElement placeOrderBtn;
}
