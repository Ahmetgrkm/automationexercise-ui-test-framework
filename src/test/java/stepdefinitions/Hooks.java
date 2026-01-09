package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.time.Duration;

public class Hooks {
    @Before

    public void setUp() {
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(java.util.logging.Level.OFF);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Tarayıcıyı açtıktan sonra sepeti tam temizlemek için:
        Driver.getDriver().get("https://automationexercise.com"); // Siteye gitmeden temizlik yapamaz
        Driver.getDriver().manage().deleteAllCookies();
        // JavaScript ile Local ve Session Storage'ı patlatıyoruz
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.localStorage.clear();");
        js.executeScript("window.sessionStorage.clear();");
        Driver.getDriver().navigate().refresh();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_screenshot");
        }
        Driver.closeDriver();
    }
}