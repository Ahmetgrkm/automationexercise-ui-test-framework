package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RegisterWhenPayingPage;
import utilities.Driver;

public class RegisterWhenPayingStepDefs {
    RegisterWhenPayingPage registerWhenPayingPage = new RegisterWhenPayingPage();

    @When("Proceed to checkout butonuna basar")
    public void proceedToCheckoutButonunaBasar() {
        registerWhenPayingPage.proceedToCheckoutBtn.click();
    }

    @And("acılan popda kayit olgiris yap seceneğine basar")
    public void acılanPopdaKayitOlgirisYapSeceneğineBasar() {
        registerWhenPayingPage.registerBtn.click();
    }

    @When("continue butonuna basar")
    public void continueButonunaBasar() {
        registerWhenPayingPage.continueBtn.click();
    }


    @And("yorum inputunu doldurur")
    public void yorumInputunuDoldurur() {
        registerWhenPayingPage.messageBox.sendKeys("madem dünyaya dargındın mamudo kurban niye doğdun");
    }

    @When("place order butonuna basar")
    public void placeOrderButonunaBasar() {
        registerWhenPayingPage.placeOrderBtn.click();
    }

    @Then("ödeme sayfasında oldugunu dogrular")
    public void ödemeSayfasındaOldugunuDogrular() {
        Assert.assertTrue(registerWhenPayingPage.paymentPageVerification.isDisplayed());


        /*String currentUrl = Driver.getDriver().getCurrentUrl();
        // URL'in içinde "payment_done" veya "success" geçiyor mu?
        Assert.assertTrue(currentUrl.contains("payment_done"));
         */
    }

    @When("kart bilgilerini girer")
    public void kartBilgileriniGirer() {
        registerWhenPayingPage.nameOnCard.sendKeys("mamudo");
        registerWhenPayingPage.cardNumber.sendKeys("1234567890");
        registerWhenPayingPage.cvc.sendKeys("123");
        registerWhenPayingPage.expiry_month.sendKeys("12");
        registerWhenPayingPage.expiry_year.sendKeys("2028");
    }

    @And("ödeme butonuna basar")
    public void ödemeButonunaBasar() {
        registerWhenPayingPage.payButton.click();
    }

    @Then("siparişin başarıyla verildiğini doğrular")
    public void siparişinBaşarıylaVerildiğiniDoğrular() {
        Assert.assertEquals("Congratulations! Your order has been confirmed!", registerWhenPayingPage.OrderPlaced.getText());
    }



}
