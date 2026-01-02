package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.AutomationPage;
import utilities.ConfigReader;
import utilities.Driver;

public class RegistrationStepDefs {

    // Page objesini oluşturarak elementlere ulaşıyoruz
    AutomationPage page = new AutomationPage();
    Faker faker = new Faker(); // Sahte veri üretici

    @Given("kullanıcı {string} sayfasına gider")
    public void kullanici_sayfasina_gider(String urlKey) {
        Driver.getDriver().get(ConfigReader.getProperty(urlKey));
    }

    @When("kullanıcı {string} butonuna tıklar")
    public void kullanici_butonuna_tiklar(String string) {
        page.signupLoginButonu.click();
    }

    @When("yeni kullanıcı kısmında {string} ve {string} bilgilerini girer")
    public void yeni_kullanici_kisminda_ve_bilgilerini_girer(String isim, String email) {
        page.signupNameKutusu.sendKeys(faker.name().fullName());
        page.signupEmailKutusu.sendKeys(faker.internet().emailAddress());
    }

    @When("{string} butonuna tıklar")
    public void butonuna_tiklar(String butonIsmi) {
        if (butonIsmi.equalsIgnoreCase("Signup / Login")) {
            page.signupLoginButonu.click();
        } else if (butonIsmi.equalsIgnoreCase("Signup")) {
            page.signupButonu.click();
        } else if (butonIsmi.equalsIgnoreCase("Create Account")) {
            // Reklam çıkma ihtimaline karşı JS ile tıklıyoruz (Daha garanti)
            utilities.ReusableMethods.clickWithJS(page.createAccountButonu);
        }
    }

    @When("kayıt formundaki zorunlu bilgileri doldurur")
    public void kayit_formundaki_zorunlu_bilgileri_doldurur() {
        page.genderRadio.click();
        page.passwordKutusu.sendKeys("Pass1234!");
        page.dayDropdown.click();
        page.selectDay();
        page.monthDropdown.click();
        page.selectMonth();
        page.yearDropdown.click();
        page.selectYear();
        page.firstNameKutusu.sendKeys(faker.name().firstName());
        page.lastNameKutusu.sendKeys(faker.name().lastName());
        page.companyKutusu.sendKeys("Microsoft");
        page.adressKutusu.sendKeys(faker.address().fullAddress());
        page.selectCountry();
        page.stateKutusu.sendKeys(faker.address().state());
        page.cityKutusu.sendKeys(faker.address().city());
        page.zipcodeKutusu.sendKeys(faker.address().zipCode());
        page.mobileNumberKutusu.sendKeys(faker.phoneNumber().phoneNumber());


    }

    @Then("hesabın başarıyla oluşturulduğunu doğrular")
    public void hesabin_basariyla_olusturuldugunu_dogrular() {
        AutomationPage freshPage = new AutomationPage();
        Assert.assertTrue(page.accountCreatedYazisi.isDisplayed());
    }
}