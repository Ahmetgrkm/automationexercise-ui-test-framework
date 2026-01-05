package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TestCasePage;

public class TestCaseStepDefs {

    TestCasePage testCasePage = new TestCasePage();
    @When("Test case e tıklar")
    public void testCaseETiklar() {
        testCasePage.testCaseBtn.click();
    }

    @Then("Test case sayfasinda oldugunu dogrular")
    public void testCaseSayfasindaOldugunuDogrular() {
        Assert.assertEquals(testCasePage.testCaseBtn.getText(), "Test Cases");
    }
}
