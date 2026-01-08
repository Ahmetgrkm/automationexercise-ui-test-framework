package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class viewCategoryPage {
    public viewCategoryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='Category']")
    public  WebElement category;

    // Tüm ana kategoriler (Women, Men, Kids)
    @FindBy(xpath = "//div[@id='accordian']//a[@data-toggle='collapse']")
    public List<WebElement> mainCategories;

    // Tıklanan ana kategorinin altındaki aktif/görünür alt kategoriler
    @FindBy(xpath = "//div[@class='panel-collapse in']//li/a")
    public List<WebElement> subCategories;

    // Doğrulama için sayfa başlığı (Örn: "WOMEN - DRESS PRODUCTS")
    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement titleText;
}
