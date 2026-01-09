package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AddToCartPage;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.List;

public class AddToCartStepDefs {
    AddToCartPage addToCartPage = new AddToCartPage();

    @When("ilk {int} ürünü sepete ekler")
    public void ilk_urunu_sepete_ekle(Integer urunSayisi) {

        // --- EKLEME YAPMADAN ÖNCE SEPETİ SIFIRLAMA---
        Driver.getDriver().get("https://automationexercise.com/view_cart");
        List<WebElement> deleteButtons = Driver.getDriver().findElements(By.xpath("//a[@class='cart_quantity_delete']"));
        for (WebElement button : deleteButtons) {
            try {
                button.click();
                ReusableMethods.waitFor(1);
            } catch (Exception e) { /* Sepet boşsa geç */ }
        }
        Driver.getDriver().get("https://automationexercise.com/products");


        ReusableMethods.handleGoogleAds();

        for (int i = 0; i < urunSayisi; i++) {
            ReusableMethods.scrollToElement(addToCartPage.allAddToCartButtons.get(i));

            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(addToCartPage.allAddToCartButtons.get(i)).perform();


            ReusableMethods.clickWithJS(addToCartPage.allAddToCartButtons.get(i));

            addToCartPage.continueShoppingButton.click();
            System.out.println((i+1) + ". ürün sepete eklendi.");
        }
    }

    @Then("sepette olan {int} ürünü dogrular")
    public void sepetteOlanÜrünüDogrular(int beklenenSayi) {
        // Eğer zaten sepet sayfasındaysak tekrar tıklayıp hata almamak için kontrol
        if (!Driver.getDriver().getCurrentUrl().contains("view_cart")) {
            addToCartPage.viewCartButton.click();
        }

        // Sepet bazen geç güncelleniyor, kısa bir bekleme ekleyelim
        ReusableMethods.waitFor(2);

        int actualUrunSayisi = addToCartPage.cartRows.size();
        System.out.println("Sepetteki ürün sayısı: " + actualUrunSayisi);

        Assert.assertEquals("Hata: Sepetteki ürün sayısı beklenenle eşleşmiyor!",
                beklenenSayi, actualUrunSayisi);
    }
}