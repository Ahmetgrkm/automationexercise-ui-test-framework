package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.viewBrandsPage;
import utilities.Driver;

import java.util.List;

public class viewBrandStepDefs {
    viewBrandsPage viewBrandsPage = new viewBrandsPage();
    @Then("sol menude markaların oldugunu dogrula")
    public void solMenudeMarkalarınOldugunuDogrula() {
        Assert.assertTrue(viewBrandsPage.Brands.isDisplayed());
    }

    @When("kullanici markalara ve tıklar ve dogrular")
    public void kullaniciMarkalaraVeTıklarVeDogrular() {
        // href'i '/brand_products/' içeren tüm a etiketleri
        String brandsXpath = "//a[contains(@href, '/brand_products/')]";

        // 2. Toplam kaç marka olduğunu o anki sayfadan alıyoruz (Polo, H&M vb.)
        int brandsSize = Driver.getDriver().findElements(By.xpath(brandsXpath)).size();

        for (int i = 0; i < brandsSize; i++) {
            // REKLAM KONTROLÜ: Sayfa her yenilendiğinde Google reklamı çıkabilir
            if (Driver.getDriver().getCurrentUrl().contains("#google_vignette")) {
                Driver.getDriver().navigate().refresh();
            }

            // 3. LİSTEYİ TAZELE: Her döngü başında listeyi yeniden buluyoruz (Index hatasını önlemek için)
            List<WebElement> brands = Driver.getDriver().findElements(By.xpath(brandsXpath));

            // Marka ismini temizleyelim (Örn: "(6) POLO" -> "POLO")
            // Önce sayıyı siliyoruz, sonra harfleri büyütüyoruz
            String expectedBrandName = brands.get(i).getText().replaceAll("\\(\\d+\\)", "").trim().toUpperCase();

            // 4. TIKLA
            brands.get(i).click();

            // 5. DOĞRULAMA
            // Sayfa başlığında (H2 Title) seçtiğimiz markanın ismi var mı?
            String actualTitle = viewBrandsPage.titleText.getText().toUpperCase();

            System.out.println("Test Edilen Marka: " + expectedBrandName);
            Assert.assertTrue("HATA: Başlıkta " + expectedBrandName + " bulunamadı! Mevcut başlık: " + actualTitle,
                    actualTitle.contains(expectedBrandName));

            // 6. GERİ DÖN: Bir sonraki markaya tıklamak için ana listeye geri gidiyoruz
            Driver.getDriver().navigate().back();

            // Sayfanın yüklenmesi için çok kısa bir bekleme
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}
