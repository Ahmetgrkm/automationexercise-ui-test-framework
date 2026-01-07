@register_when_paying
Feature: Kullanıcı ödeme yaparken kayıt olur

  Background:
    Given kullanıcı "url" sayfasına gider
    Then Ana sayfanın başarıyla göründüğünü doğrular


  Scenario: Kullanıcı ödeme yaparken kayıt olma işlemi
    When ilk 2 ürünü sepete ekler
    And kullanici cart sayfasina gider
    Then sepette olan 2 ürünü dogrular
    When Proceed to checkout butonuna basar
    And acılan popda kayit olgiris yap seceneğine basar
    And yeni kullanıcı kısmında "isim" ve "email" bilgilerini girer
    And "Signup" butonuna tıklar
    And kayıt formundaki zorunlu bilgileri doldurur
    And "Create Account" butonuna tıklar
    Then hesabın başarıyla oluşturulduğunu doğrular
    When continue butonuna basar
    Then  'Kullanıcı adı olarak giriş yapıldı' yazısının görünür olduğunu doğrular
    And kullanici cart sayfasina gider
    When Proceed to checkout butonuna basar
    And yorum inputunu doldurur
    When place order butonuna basar
    Then ödeme sayfasında oldugunu dogrular
    When kart bilgilerini girer
    And ödeme butonuna basar
    Then siparişin başarıyla verildiğini doğrular
    When  'Delete Account' butonuna tıklar
    Then  'HESAP SILINDI!' yazısının görünür olduğunu doğrular

  @registration_before_payment
  Scenario: kullanıcı ödeme öncesi kayıt olur
    When kullanıcı "Signup / Login" butonuna tıklar
    And yeni kullanıcı kısmında "isim" ve "email" bilgilerini girer
    And "Signup" butonuna tıklar
    And kayıt formundaki zorunlu bilgileri doldurur
    And "Create Account" butonuna tıklar
    Then hesabın başarıyla oluşturulduğunu doğrular
    When continue butonuna basar
    Then  'Kullanıcı adı olarak giriş yapıldı' yazısının görünür olduğunu doğrular
    When ilk 2 ürünü sepete ekler
    And kullanici cart sayfasina gider
    Then sepette olan 2 ürünü dogrular
    When Proceed to checkout butonuna basar
    And yorum inputunu doldurur
    When place order butonuna basar
    Then ödeme sayfasında oldugunu dogrular
    When kart bilgilerini girer
    And ödeme butonuna basar
    Then siparişin başarıyla verildiğini doğrular
    When  'Delete Account' butonuna tıklar
    Then  'HESAP SILINDI!' yazısının görünür olduğunu doğrular







