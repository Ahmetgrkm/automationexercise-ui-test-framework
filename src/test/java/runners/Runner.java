package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports.html"}, // Rapor oluşturur
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@view_category", // Sadece bu tag'li testleri çalıştırır
        dryRun = false  // Eksik adım var mı diye kontrol etmek için true yapabilirsin
)
public class Runner {}