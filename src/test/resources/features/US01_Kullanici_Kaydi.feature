@kayit
Feature: US01 Kullanıcı Kayıt Fonksiyonu

  Background: Kullanıcı ana sayfadadır
    Given kullanıcı "url" sayfasına gider

  Scenario: TC01 Yeni kullanıcı kaydı oluşturulabilmeli
    When kullanıcı "Signup / Login" butonuna tıklar
    And yeni kullanıcı kısmında "isim" ve "email" bilgilerini girer
    And "Signup" butonuna tıklar
    And kayıt formundaki zorunlu bilgileri doldurur
    And "Create Account" butonuna tıklar
    Then hesabın başarıyla oluşturulduğunu doğrular