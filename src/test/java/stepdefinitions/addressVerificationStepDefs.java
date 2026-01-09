package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AddressVerificationPage;

public class addressVerificationStepDefs {
  AddressVerificationPage  addressVerificationPage = new AddressVerificationPage();
  RegistrationStepDefs registrationStepDefs = new RegistrationStepDefs();

    @Then("olusturulan adre ile hafızadaki adresi karsılastırır.")
    public void olusturulanAdreIleHafızadakiAdresiKarsılastırır() {
        // 1. Sitedeki adres bloğunu al ve tüm boşluklarını temizle
        String actualAddress = addressVerificationPage.deliveryAddressBlock.getText().trim();

        // 2. Hafızadaki adresi al (Signup sayfasından gelen)
        String expectedAddress = registrationStepDefs.kayıtEdilenAdres.trim();

        // Konsolda neyi neyle kıyasladığını görmek için yazdıralım (Hata ayıklama için)
        System.out.println("Beklenen Adres: " + expectedAddress);
        System.out.println("Sitedeki Adres: " + actualAddress);

        // 3. DOĞRULAMA: assertEquals yerine assertTrue + contains kullanıyoruz
        // Çünkü sitedeki blokta isim, telefon vb. ek bilgiler de olabilir.
        Assert.assertTrue("HATA: Sitedeki adres bloğu (" + actualAddress + ") beklenen adresi (" + expectedAddress + ") içermiyor!",
                actualAddress.contains(expectedAddress));
    }
}
