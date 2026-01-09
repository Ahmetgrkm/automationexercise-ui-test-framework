package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ContactUsPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class ContactUsStepDefs {
    ContactUsPage contactUs = new ContactUsPage();
    Faker faker = new Faker();


    @When("Bize ulasin butonuna basar")
    public void bizeUlasinButonunaBasar() {
        contactUs.ContactUsLink.click();
    }

    @Then("Bize ulasin sayfasına gittigini dogrular")
    public void bizeUlasinSayfasinaGittiginiDogrular() {
        Assert.assertEquals("GET IN TOUCH",contactUs.GetInTouchMessage.getText());
    }

    @And("formu doldurur")
    public void formuDoldurur() {
        contactUs.NameInput.sendKeys(faker.name().firstName());
        contactUs.emailInput.sendKeys(faker.internet().emailAddress());
        contactUs.subjectInput.sendKeys("övgü");
        contactUs.messageInput.sendKeys("sitenizi çok beğendimmmm");
        // 1. Dinamik ana dizini al
        String userDir = System.getProperty("user.dir");

        // 2. Dosya yolunu doğru ayraçlarla birleştir (Slas işaretine dikkat!)
        String filePath = userDir + "/src/test/resources/image.jpg";

        // 3. Dosyayı gönder
        contactUs.uploadFile.sendKeys(filePath);
    }

    @When("Submit butonuna basar")
    public void submitButonunaBasar() {
        contactUs.submitButton.click();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().alert().accept();
    }
    @And("Home butonuna tıklar")
    public void homeButonunaTiklar() {
        contactUs.HomePageButton.click();
    }


}
