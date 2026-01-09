package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.invoiceDownloadPage;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class invoice_downloadStepDefs {
    invoiceDownloadPage invoiceDownloadPage = new invoiceDownloadPage();

    @Then("faturanın basarıyla indirildigini dogrular")
    public void faturanınBasarıylaIndirildiginiDogrular() {
        // 1. ADIM: Dosya yolunu dinamik yapalım
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "\\Downloads\\invoice.txt";

// 2. ADIM: Varsa eski dosyayı silelim
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }

// 3. ADIM: Butona tıkla ve indirmeyi başlat
        invoiceDownloadPage.downloadButton.click();

// --- EKLEME: Brave "Save As" penceresi için Enter'a basma işlemi ---
        try {
            // Kısa bir bekleme (Pencerenin açılması için)
            ReusableMethods.waitFor(2);

            // Robot class klavyeyi taklit eder
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER); // Enter tuşuna bas
            robot.keyRelease(KeyEvent.VK_ENTER); // Enter tuşunu bırak

        } catch (AWTException e) {
            e.printStackTrace();
        }
// ---------------------------------------------------------------

// 4. ADIM: Dosyanın inmesi için zaman tanı
        ReusableMethods.waitFor(3);

// 5. ADIM: Doğrulama (Assertion)
        Assert.assertTrue("HATA: Fatura dosyası indirilemedi!", file.exists());

        System.out.println("Fatura başarıyla doğrulandı: " + filePath);
    }
}
