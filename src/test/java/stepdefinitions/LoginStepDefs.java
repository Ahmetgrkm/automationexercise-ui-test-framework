package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Wait;
import pages.LoginPage;
import pages.RegisterPage;
import utilities.Driver;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Then("Ana sayfanın başarıyla göründüğünü doğrular")
    public void anaSayfaninBasariylaGorunduğunuDogrular() {
        // URL doğrulaması
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals("HATA: URL hatalı!", expectedUrl, Driver.getDriver().getCurrentUrl());

        // Title (Başlık) doğrulaması
        String expectedTitle = "Automation Exercise";
        Assert.assertTrue("HATA: Sayfa başlığı yanlış!", Driver.getDriver().getTitle().contains(expectedTitle));
    }

    @Then("{string} yazısının görünür olduğunu doğrular")
    public void CikanMesajiDogrular(String expectedMessage) {
        if (expectedMessage.equalsIgnoreCase("Login to your account")){
            Assert.assertEquals(expectedMessage, loginPage.LoginYourAccount.getText());
        } else if (expectedMessage.contains("Logged in as")) { // Bu metin genelde dinamiktir (isim içerir)
            Assert.assertTrue(loginPage.LoginMessage.getText().contains(expectedMessage));
        } else if (expectedMessage.equalsIgnoreCase("ACCOUNT DELETED!")){
            Assert.assertTrue(loginPage.AccountdeletedMessage.isDisplayed());
        }else if (expectedMessage.equalsIgnoreCase("Your email or password is incorrect!")){
            Assert.assertTrue(loginPage.HataliGiris.isDisplayed());
        }else if (expectedMessage.equalsIgnoreCase("Email Address already exist!")){
            Assert.assertTrue(registerPage.EmailALreadyExist.isDisplayed());
        }
    }

    @And("Geçerli bir e-posta ve şifre girer")
    public void geçerliBirEPostaVeŞifreGirer() {
        loginPage.Loginemail.sendKeys("mehmet44@gmail.com");
        loginPage.Loginpassword.sendKeys("12345");
    }

    @And("Yanlis Mail ve Sifre girer.")
    public void yanlisMailVeSifreGirer() {
        loginPage.Loginemail.sendKeys("23233242@gmail.com");
        loginPage.Loginpassword.sendKeys("12345");
    }
}
