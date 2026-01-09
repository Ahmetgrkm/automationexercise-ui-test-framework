package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.invoiceDownloadPage;
import utilities.ReusableMethods;

import java.io.File;

public class invoice_downloadStepDefs {
    invoiceDownloadPage invoiceDownloadPage = new invoiceDownloadPage();

    @Then("faturanın basarıyla indirildigini dogrular")
    public void faturanınBasarıylaIndirildiginiDogrular() {
        // 1. ADIM: Dosya yolunu dinamik yapalım (Her bilgisayarda çalışması için)
        // Bu kod kullanıcının Downloads klasörünü bulur: C:\Users\KullaniciAdi\Downloads\invoice.txt
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "\\Downloads\\invoice.txt";

        // 2. ADIM: Varsa eski dosyayı silelim (Testin sağlığı için)
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }

        // 3. ADIM: Butona tıkla ve indirmeyi başlat
        invoiceDownloadPage.downloadButton.click();

        // 4. ADIM: Dosyanın inmesi için biraz zaman tanı (İnternet hızına göre 3-5 sn)
        ReusableMethods.waitFor(3);

        // 5. ADIM: Doğrulama (Assertion)
        Assert.assertTrue("HATA: Fatura dosyası indirilemedi!", file.exists());

        System.out.println("Fatura başarıyla doğrulandı: " + filePath);
    }
}
