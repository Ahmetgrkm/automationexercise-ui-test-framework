package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.AddToCartPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class AddToCartStepDefs {
    AddToCartPage addToCartPage = new AddToCartPage();

    @When("ilk {int} ürünü sepete ekler")
    public void ilk_urunu_sepete_ekle(Integer urunSayisi) {
        for (int i = 0; i < urunSayisi; i++) {
            // 1. Ürünün üstüne gel (Bazen hover gerekebilir, gerekmiyorsa direkt tıkla)
            // Listeler 0'dan başlar, i=0 ilk üründür.

            // Önce sayfayı o elemente kaydır (Öğrendiğimiz metot)
            ReusableMethods.scrollToElement(addToCartPage.allAddToCartButtons.get(i));

            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(addToCartPage.allAddToCartButtons.get(i)).perform();

            // Butona tıkla
            addToCartPage.allAddToCartButtons.get(i).click();

            // 2. Çıkan onay kutusunda "Continue Shopping"e tıkla (Bir sonrakini ekleyebilmek için)
            addToCartPage.continueShoppingButton.click();

            System.out.println((i+1) + ". ürün sepete eklendi.");
        }
    }


    @Then("sepette olan {int} ürünü dogrular")
    public void sepetteOlanÜrünüDogrular(int beklenenSayi) {
// 1. Sepet sayfasına git
        addToCartPage.viewCartButton.click();

        // 2. Sepetteki satır sayısını al
        int actualUrunSayisi = addToCartPage.cartRows.size();

        System.out.println("Sepetteki ürün sayısı: " + actualUrunSayisi);

        // 3. Karşılaştır
        Assert.assertEquals("Hata: Sepetteki ürün sayısı beklenenle eşleşmiyor!",
                beklenenSayi, actualUrunSayisi);
    }
}
