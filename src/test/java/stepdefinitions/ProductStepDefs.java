package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ProductPage;
import utilities.ReusableMethods;

import java.util.List;

public class ProductStepDefs {

    ProductPage productPage = new ProductPage();

    @When("Products butonuna tıkla")
    public void productsButonunaTıkla() {
        productPage.products.click();
    }

    @Then("ürünler sayfasında olduğunu dogrula")
    public void ürünlerSayfasındaOlduğunuDogrula() {
        String expectedUrlPart = "products";
        String actualUrl = productPage.getCurrentPageUrl();

        // JUnit kullanarak doğrulama
        Assert.assertTrue("Hata: URL beklenen metni içermiyor! Mevcut URL: " + actualUrl,
                actualUrl.contains(expectedUrlPart));
    }

    @And("ilk ürünün ürünü görüntüle butonuna basılır")
    public void ilkÜrününÜrünüGörüntüleButonunaBasılır() {
        ReusableMethods.clickWithJS(productPage.firstProductViewButton);
    }

    @Then("Tüm ürünler sayfasına gidildiğini dogrula:")
    public void tümÜrünlerSayfasınaGidildiğiniDogrula(List<String> fields) {
        for (String field : fields) {
            switch (field) {
                case "Product Name":
                    Assert.assertTrue(productPage.productName.isDisplayed());
                    break;
                case "Price":
                    Assert.assertTrue(productPage.productPrice.isDisplayed());
                    break;
                case "Availability":
                    Assert.assertTrue(productPage.availability.isDisplayed());
                    break;
                case "category":
                    Assert.assertTrue(productPage.category.isDisplayed());
                    break;
                case "condition":
                    Assert.assertTrue(productPage.condition.isDisplayed());
                    break;
                case "brand":
                    Assert.assertTrue(productPage.brand.isDisplayed());
                    break;
            }
        }
    }

}
