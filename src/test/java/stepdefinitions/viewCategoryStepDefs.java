package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.viewCategoryPage;
import utilities.Driver;

import java.util.List;

public class viewCategoryStepDefs {
    viewCategoryPage viewCategoryPage = new viewCategoryPage();

    @Then("sol menude categorynin oldugunu dogrula")
    public void solMenudeCategoryninOldugunuDogrula() {
        Assert.assertTrue(viewCategoryPage.category.isDisplayed());
    }

    @When("kullanici kategorilere ve alt kategorilere tıklar ve dogrular")
    public void kullaniciKategorilereVeAltKategorilereTıklarVeDogrular() {

            // 1. Ana kategorilerin güncel sayısını al (Women, Men, Kids)
            String mainCatXpath = "//div[@id='accordian']//a[@data-toggle='collapse']";
            int mainCatSize = Driver.getDriver().findElements(By.xpath(mainCatXpath)).size();

            for (int i = 0; i < mainCatSize; i++) {
                // Her ana kategori döngüsünde listeyi tazeliyoruz
                List<WebElement> mainCats = Driver.getDriver().findElements(By.xpath(mainCatXpath));

                if (i >= mainCats.size()) break; // Güvenlik kontrolü

                WebElement mainCat = mainCats.get(i);
                mainCat.click();

                // Kısa bir bekleme (Alt kategorilerin açılması için)
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                // 2. Alt kategorileri gez (O an görünür olanlar)
                String subCatXpath = "//div[@class='panel-collapse in']//li/a";
                int subCatSize = Driver.getDriver().findElements(By.xpath(subCatXpath)).size();

                for (int j = 0; j < subCatSize; j++) {
                    // Her tıklama sonrası sayfa değiştiği için alt kategori listesini de tazeliyoruz
                    List<WebElement> subCats = Driver.getDriver().findElements(By.xpath(subCatXpath));

                    if (j >= subCats.size()) break;

                    WebElement subCat = subCats.get(j);
                    String subCatName = subCat.getText().toUpperCase();
                    subCat.click(); // Alt kategoriye tıkla (Sayfa değişti!)

                    // 3. DOĞRULAMA
                    String actualTitle = viewCategoryPage.titleText.getText().toUpperCase();
                    Assert.assertTrue("Başlık beklenen kategoriyi içermiyor!", actualTitle.contains(subCatName));

                    // 4. GERİ DÖN VE YERİNİ BUL
                    Driver.getDriver().navigate().back();

                    // Geri gelince ana kategori kapanmış olabilir, onu tekrar tıklayıp alt menüyü açıyoruz
                    List<WebElement> refreshMain = Driver.getDriver().findElements(By.xpath(mainCatXpath));
                    refreshMain.get(i).click();

                    // Alt menünün açılması için minik bir bekleme
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

