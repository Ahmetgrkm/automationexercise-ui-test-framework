package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class viewBrandsPage {
    public viewBrandsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Brands']")
    public WebElement Brands;

    // "href" değeri "/brand_products/" ile başlayan tüm linkleri getirir
    @FindBy(xpath = "//a[contains(@href, '/brand_products/')]")
    public List<WebElement> brandsList;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement titleText;
}
