# 🚀 Automation Exercise: Full Stack UI Test Automation Framework

Bu proje, [Automation Exercise](https://automationexercise.com/) e-ticaret platformunun tüm kritik iş akışlarını doğrulamak amacıyla geliştirilmiş, **BDD (Behavior Driven Development)** yaklaşımına dayalı profesyonel bir test otomasyon freameworküdür.

## 🛠 Kullanılan Teknolojiler
* **Java 11:** Güçlü ve tip güvenli programlama dili.
* **Selenium WebDriver:** Tarayıcı etkileşimleri ve otomasyon süreçleri için.
* **Cucumber & Gherkin:** İş birimleriyle ortak dil kullanımı ve okunabilir senaryolar.
* **Maven:** Bağımlılık yönetimi ve build süreçleri.
* **JUnit:** Testlerin koşturulması ve doğrulama (assertion) işlemleri.
* **Java Faker:** Dinamik ve gerçekçi test verileri üretimi.

---

## 📌 Proje Özellikleri ve Teknik Çözümler
Proje, standart bir otomasyonun ötesinde şu gelişmiş teknik yaklaşımları barındırır:

* **✅ Page Object Model (POM):** Kod tekrarını önleyen ve bakımı kolaylaştıran merkezi element yönetimi.
* **✅ Ad-Blocking System:** Test akışını bozan Google reklamlarını (`aswift` iframe'leri) DOM üzerinden temizlemek için geliştirilen `JavaScriptExecutor` katmanı.
* **✅ Cross-Browser Testing:** Chrome ve Brave tarayıcı desteği. Brave'in yerleşik reklam engelleyici özellikleri konfigürasyon üzerinden framework'e dahil edilmiştir.
* **✅ Dynamic Data Persistence:** Kayıt aşamasında üretilen verilerin (adres, email vb.) testin ilerleyen aşamalarında (ödeme, fatura) doğrulanması için `static` veri taşıma mimarisi kullanılmıştır.
* **✅ File Download Verification:** Sipariş sonrası faturanın (`invoice.txt`) yerel Downloads klasörüne indiği Java `File` kütüphanesi ile doğrulanmaktadır.
* **✅ Advanced UI Interaction:** Sayfadaki gizli veya uzak elementlere ulaşmak için `scrollIntoView` ve `Actions` sınıfı entegrasyonu.
* **✅ Error Handling:** `ElementClickInterceptedException` gibi hatalara karşı "Zırhlı Click" (JS Click) metodları uygulanmıştır.

---

## 📋 Otomatize Edilen Test Senaryoları
Framework kapsamında toplam **26 ana test durumu** başarıyla otomatize edilmiştir:
1.  **Kullanıcı Yönetimi:** Kayıt olma, Login/Logout, Mevcut email ile kayıt hatası senaryoları.
2.  **Ürün & Sepet:** Tüm ürünleri görüntüleme, ürün arama, miktar doğrulama ve sepetten ürün çıkarma.
3.  **Ödeme Süreci:** Adres bilgilerinin ödeme sayfasında otomatik doğrulanması ve ödeme akışı.
4.  **Abonelik:** Ana sayfa ve sepet altındaki abonelik (Subscription) kontrolleri.
5.  **İletişim & UI:** Bize ulaşın formu, sayfayı aşağı kaydırma ve "Yukarı Ok" butonu fonksiyon testleri.
6.  **Dokümantasyon:** Sipariş sonrası dinamik fatura indirme ve dosya varlık kontrolü.

---

## 📂 Framework Yapısı
```text
src/test/java
├── runners           # Testlerin tetiklendiği merkez (JUnit Runner)
├── stepdefinitions   # Gherkin adımlarının Java kod karşılıkları
├── pages             # Web elementlerinin bulunduğu Page Object sınıfları
└── utilities         # Driver, ConfigReader ve ReusableMethods (JS, Scroll, Click)
src/test/resources
└── features          # Senaryoların yazıldığı .feature dosyaları
```
## Kurulum ve Çalıştırma
1.Projeyi Klonlayın
```bash
git clone [https://github.com/Ahmetgrkm/automationexercise-ui-tests.git](https://github.com/Ahmetgrkm/automationexercise-ui-tests.git)
```
2.Konfigürasyon
src/test/resources/configuration.properties dosyasını açarak tarayıcı seçiminizi yapın
```Properties
browser=chrome  # veya brave
brave.path=C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe
```

3. Testleri Çalıştırın
IDE üzerinden Runner sınıfını çalıştırabilir veya terminale şu komutu yazabilirsiniz:
```bash
mvn test
```
--Hazırlayan--
Ahmed Görkem Çalışkan

LinkedIn: www.linkedin.com/in/ahmet-görkem-çalışkan-b91780251

GitHub: https://github.com/Ahmetgrkm















