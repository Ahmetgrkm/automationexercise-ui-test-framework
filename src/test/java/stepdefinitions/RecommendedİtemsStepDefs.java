package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.AddToCartPage;
import pages.Recommended_itemsPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class RecommendedİtemsStepDefs {
    Recommended_itemsPage  recommended_itemsPage = new Recommended_itemsPage();
    AddToCartPage cartPage = new AddToCartPage();
    @When("sayfa recommended itemse kadar kaydırılır")
    public void sayfaRecommendedItemseKadarKaydırılır() {

    }

    @And("önerilen ürünlerden sepete eklenir")
    public void önerilenÜrünlerdenSepeteEklenir() throws InterruptedException {
        // 1. ADIM: Başlığa kadar kaydır
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", recommended_itemsPage.recommendedHeader);

        // Sayfanın durulması için biraz bekle
        Thread.sleep(2000);

        // 2. ADIM: İLK ÜRÜNÜ EKLE (JS Click kullanarak)
        // Listede o an görünür olan ilk ürünü ekler (0. index yerine garantici bir index seçelim)
        WebElement firstProduct = recommended_itemsPage.recommendedAddToCartBtns.get(0);
        js.executeScript("arguments[0].click();", firstProduct);

        // Pop-up'ı kapat (Continue Shopping)
        Thread.sleep(1000);
        cartPage.continueShoppingButton.click();

        // 3. ADIM: SLIDER'I KAYDIR
        recommended_itemsPage.nextButton.click();
        Thread.sleep(2000); // Kayma animasyonu için MUTLAKA bekle

        // 4. ADIM: KAYAN KISIMDAN ÜRÜN EKLE (JS Click kullanarak)
        // Kayınca gelen ürünlerden birini (örneğin 3. index) ekle
        WebElement secondProduct = recommended_itemsPage.recommendedAddToCartBtns.get(3);
        js.executeScript("arguments[0].click();", secondProduct);
    }

    @And("alısverise devam butonuna tıklanır")
    public void alısveriseDevamButonunaTıklanır() {
    cartPage.continueShoppingButton.click();
    }

    @Then("sepette olan  ürünü dogrular")
    public void sepetteOlanÜrünüDogrular() {
// 1. Sepet sayfasına git
        cartPage.viewCartButton.click();

        // 2. Sepetteki satır sayısını al
        int actualUrunSayisi = cartPage.cartRows.size();

        System.out.println("Sepetteki ürün sayısı: " + actualUrunSayisi);
        int beklenenSayi=2;
        // 3. Karşılaştır
        Assert.assertEquals("Hata: Sepetteki ürün sayısı beklenenle eşleşmiyor!",
                beklenenSayi, actualUrunSayisi);
    }
}
