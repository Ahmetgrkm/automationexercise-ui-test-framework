package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Yeni import
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();

                    // Reklam ve Pop-up engelleme ayarları
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--remote-allow-origins=*"); // Bağlantı hatalarını önlemek için

                    driver = new ChromeDriver(options); // Ayarlarla birlikte başlat
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "brave":
                    // Brave, Chromium tabanlı olduğu için ChromeOptions kullanıyoruz
                    ChromeOptions braveOptions = new ChromeOptions();

                    // Config'den Brave'in .exe yolunu çekiyoruz
                    String bravePath = ConfigReader.getProperty("brave.path");
                    braveOptions.setBinary(bravePath);

                    // Hazır elimiz değmişken Brave'in kendi reklam engelleyicisini de aktif tutalım
                    braveOptions.addArguments("--start-maximized");

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(braveOptions);
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}