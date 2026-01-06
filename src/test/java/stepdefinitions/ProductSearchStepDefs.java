package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.ProductSearchPage;

public class ProductSearchStepDefs {
    ProductSearchPage productSearch = new ProductSearchPage();

    @When("kullanici search inputuna {string} yazar")
    public void kullaniciSearchInputunaYazar(String arg0) {
        productSearch.searchInput.sendKeys(arg0);

    }

    @And("arama butonuna tıklar")
    public void aramaButonunaTıklar() {
        productSearch.searchButton.click();
    }

    @Then("aranan urunler sayfasinda oldugunu dogrula")
    public void arananUrunlerSayfasindaOldugunuDogrula() {
        Assert.assertEquals("SEARCHED PRODUCTS", productSearch.searchedProducts.getText());
    }

    @Then("Arama ile ilgili tüm ürünlerin görünür olduğunu doğrulayın")
    public void aramaIleIlgiliTümÜrünlerinGörünürOlduğunuDoğrulayın() {
        for (WebElement product : productSearch.searchedProductNames) {
            // .toLowerCase(Locale.ROOT) veya (Locale.ENGLISH) kullanarak
            // "I" harfinin "ı" değil, "i" olmasını sağlıyoruz.
            String originalName = product.getText().toLowerCase(java.util.Locale.ENGLISH);

            System.out.println("Kontrol ediliyor (English Locale): " + originalName);

            // Şimdi hem 't' hem 'shirt' (noktalı i ile) güvenle aranabilir
            boolean containsT = originalName.contains("t");
            boolean containsShirt = originalName.contains("shirt");

            Assert.assertTrue("Hata: " + originalName + " ürünü beklenen kelimeleri içermiyor!",
                    containsT && containsShirt);
        }
    }
}
