package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", // Konsolu renklendirir
                "html:target/cucumber-reports.html", // HTML rapor üretir
                "json:target/json-reports/cucumber.json", // JSON rapor (opsiyonel)
                "junit:target/xml-report/cucumber.xml" // JUnit rapor (opsiyonel)
        }, // Rapor oluşturur
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "", // Sadece bu tag'li testleri çalıştırır
        dryRun = false  // Eksik adım var mı diye kontrol etmek için true yapabilirsin
)
public class Runner {}