package stepdefinitions;


import io.cucumber.java.en.Then;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.viewProductAndReviewPage;
import utilities.Driver;

import java.time.Duration;

public class viewProductAndReviewStepDefs {
    viewProductAndReviewPage viewProductAndReviewPage = new viewProductAndReviewPage();

    @Then("Write your review yazısını doğrular")
    public void writeYourReviewYazısınıDoğrular() {
        Assert.assertTrue(viewProductAndReviewPage.writeYourReview.isDisplayed());
    }

    @Then("yorum kısmını doldurur ve gönderir")
    public void yorumKısmınıDoldururVeGönderir() {
        viewProductAndReviewPage.name.sendKeys("jeku");
        viewProductAndReviewPage.email.sendKeys("jeku4444@gmail.com");
        viewProductAndReviewPage.review.sendKeys("selamun aleykum haci dayi");
        viewProductAndReviewPage.submitBtn.click();
    }

    @Then("cıkan mesajı dogrular")
    public void cıkanMesajıDogrular() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        try {
            // 1. ADIM: Yazının (text) element içinde belirmesini bekle
            // Bu yöntem class'ın hide olup olmadığına bakmaz, direkt içeriğe odaklanır
            wait.until(ExpectedConditions.textToBePresentInElement(
                    viewProductAndReviewPage.reviewSuccessMessage, "Thank you for your review."));

            // 2. ADIM: Metni al ve temizle
            String actualMessage = viewProductAndReviewPage.reviewSuccessMessage.getText().trim();
            System.out.println("Yakalanan Mesaj: " + actualMessage);

            // 3. ADIM: Doğrulama
            Assert.assertEquals("Mesaj içeriği eşleşmiyor!", "Thank you for your review.", actualMessage);

        } catch (Exception e) {
            // Hata anında o anki HTML yapısını görelim ki neden bulamadığını anlayalım
            System.out.println("Hata anındaki element class'ı: " +
                    Driver.getDriver().findElement(By.id("review-section")).getAttribute("class"));
            Assert.fail("Başarı mesajı 10 saniye içinde görünür olmadı veya metin gelmedi!");
        }
    }
}






















