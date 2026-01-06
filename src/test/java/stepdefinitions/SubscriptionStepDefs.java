package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SubscriptionPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class SubscriptionStepDefs {
    SubscriptionPage subscriptionPage = new SubscriptionPage();

    @When("sayfa altbilgiye kaydirilir")
    public void sayfaAltbilgiyeKaydirilir() {
        ReusableMethods.scrollToElement(subscriptionPage.footer); // Sayfayı kaydır
    }

    @Then("Abonelik yazısı dogrulanir")
    public void abonelikYazısıDogrulanir() {
        String subscription = subscriptionPage.subscription.getText();
        Assert.assertEquals("SUBSCRIPTION", subscription);
    }

    @When("Kullanici e-posta girer")
    public void kullaniciEPostaGirer() {
        subscriptionPage.susbscribeEmail.sendKeys("mehmet44@gmail.com");
    }

    @And("ok tusuna basar")
    public void okTusunaBasar() {
        subscriptionPage.Sendsubscribe.click();
    }

    @Then("Basari mesajini dogrular")
    public void basariMesajiniDogrular() {

        // 1.ADIM : 5 saniye boyunca her milisaniyede sayfayı kontrol edecek
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        try {
            // 2. ADIM: "hide" class'ı gidene kadar bekle
            // Bu satır, mesajın görünür olduğu o 1 saniyelik anı yakalar
            wait.until(ExpectedConditions.not(
                    ExpectedConditions.attributeContains(subscriptionPage.flashMessage, "class", "hide")
            ));

            // 3. ADIM: Mesaj göründüğü an metni kap
            // toLowerCase(Locale.ENGLISH) ile Türkçe karakter (i/ı) riskini sıfırlıyoruz
            String actualMessage = subscriptionPage.flashMessage.getText().toLowerCase(java.util.Locale.ENGLISH);

            System.out.println("Yakalanan Mesaj: " + actualMessage);

            // 4. ADIM: Doğrulama (Assertion)
            // Mesajın içinde beklediğimiz anahtar kelimeler geçiyor mu?
            String expectedKeyword = "successfully subscribed";

            Assert.assertTrue("Hata: Beklenen mesaj içeriği bulunamadı! Alınan: " + actualMessage,
                    actualMessage.contains(expectedKeyword));

        } catch (Exception e) {
            // Eğer 5 saniye içinde 'hide' class'ı kaybolmazsa burası çalışır
            Assert.fail("Başarı mesajı belirlenen sürede görünür olmadı veya 'hide' class'ı kalkmadı!");
        }
    }
}
