package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.upArrowPage;
import utilities.Driver;

public class upArrowStepDefs {

    upArrowPage upArrowPage = new upArrowPage();
    @When("sayfayı asagı kaydirir")
    public void sayfayıAsagıKaydirir() {
        // Actions yerine bunu kullan çünkü Actions verdiğimiz elemanı görmeyebiliyor.
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //sayfanın en altına gitmeyi sağlar.
    }

    @And("yukari ok tusuna basar")
    public void yukariOkTusunaBasar() {
        upArrowPage.upArrow.click();
    }

    @Then("sayfanın basındaki baslıgı dogrular")
    public void sayfanınBasındakiBaslıgıDogrular() {
        Assert.assertEquals("Full-Fledged practice website for Automation Engineers",upArrowPage.message.getText());
    }
}
