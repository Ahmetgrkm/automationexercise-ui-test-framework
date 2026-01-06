@product_search
  Feature: Kullanıcı siteye girip ürün arar

    Background: Background: Kullanıcı ana sayfadadır
      Given kullanıcı "url" sayfasına gider
      Then Ana sayfanın başarıyla göründüğünü doğrular
      When Products butonuna tıkla
      Then ürünler sayfasında olduğunu dogrula

      Scenario: Kullanıcı ürün aratır ve doğrular
        When kullanici search inputuna "TShirt" yazar
        And arama butonuna tıklar
        Then aranan urunler sayfasinda oldugunu dogrula
        Then Arama ile ilgili tüm ürünlerin görünür olduğunu doğrulayın