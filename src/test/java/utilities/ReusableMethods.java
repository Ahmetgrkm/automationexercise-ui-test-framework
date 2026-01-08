package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.List;

public class ReusableMethods {

    // Reklam engelini aşmak için JavaScript ile tıklama metodu
    public static void clickWithJS(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("JS Click hatası: " + e.getMessage());
        }
    }

    // Elementin görünür olmasını bekleyen metod
    public static void waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void handleGoogleAds() {
        try {
            // 1. Önce sayfanın reklamlı URL'de kalıp kalmadığını kontrol et
            if (Driver.getDriver().getCurrentUrl().contains("#google_vignette")) {
                // Eğer URL'de bu varsa, sayfayı yenilemek reklamı %90 oranında öldürür
                Driver.getDriver().navigate().refresh();
            }

            // 2. Iframe'ler arasında kaybolmamak için JavaScript ile doğrudan DOM'daki tüm 'dismiss-button'ları bul ve tıkla
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

            // Bu script, sayfadaki tüm iframe'leri gezer ve içindeki dismiss-button'a "ne olursa olsun tıkla" der
            String script = "var frames = document.getElementsByTagName('iframe');" +
                    "for (var i = 0; i < frames.length; i++) {" +
                    "  var innerDoc = frames[i].contentDocument || frames[i].contentWindow.document;" +
                    "  var btn = innerDoc.getElementById('dismiss-button');" +
                    "  if (btn) { btn.click(); break; }" +
                    "}";
            js.executeScript(script);

        } catch (Exception e) {
            // Reklam yoksa veya tıklanamazsa testi durdurma
        }
    }
    public static void clickWithRobot() {
        try {
            Robot robot = new Robot();
            // Farenin koordinatlarını ekranın yaklaşık orta-üst kısmına getir
            // (Bu koordinatlar ekran çözünürlüğüne göre değişebilir ama genelde işe yarar)
            robot.mouseMove(500, 300);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void removeAdsWithJS() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            // Sayfadaki tüm google reklamlarını ve iframe'lerini bulup söküp atar
            js.executeScript("var ads = document.querySelectorAll('ins.adsbygoogle, div[id*=\"google_ads\"], iframe[id*=\"aswift\"], #dismiss-button');" +
                    "for (var i = 0; i < ads.length; i++) { ads[i].remove(); }");
            // Sayfanın üzerindeki gri/şeffaf katmanı (reklam örtüsü) kaldırır
            js.executeScript("document.body.style.overflow = 'auto';");
        } catch (Exception e) {}
    }
}