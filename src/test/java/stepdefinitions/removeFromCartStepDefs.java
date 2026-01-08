package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RemoveFromCartPage;
import utilities.ReusableMethods;

public class removeFromCartStepDefs {
    RemoveFromCartPage removeFromCartPage = new RemoveFromCartPage();
    @When("sepet boşalana kadar tüm ürünleri siler")
    public void kullaniciUrunSilmeButonunaBasar() {
        // 1. Döngüye giriyoruz: Silme butonu listesi boş değilse (size > 0) devam et
        while (removeFromCartPage.deleteButtons.size() > 0) {

            // Her seferinde listenin ilk elemanı(0. index)
            removeFromCartPage.deleteButtons.get(0).click();

            // Silme işlemi sonrası reklam çıkarsa diye reklam savar
            ReusableMethods.handleGoogleAds();

            // 2. Kısa bir bekleme(DOM'un güncellenmesi ve ürünün kaybolması için)

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Then("sepetin boş olduğunu dogrular")
    public void sepetinBoşOlduğunuDogrular() {
// Sepet boş yazısının göründüğünü kontrol et
        Assert.assertTrue(removeFromCartPage.cartIsEmpty.isDisplayed());
    }
}
