@AddToCart
  Feature: Kullanıcı sepete 2 farklı ürün ekler ve doğrulamasını yapar.

    Background: Background: Kullanıcı ana sayfadadır
      Given kullanıcı "url" sayfasına gider
      Then Ana sayfanın başarıyla göründüğünü doğrular
      When Products butonuna tıkla
      Then ürünler sayfasında olduğunu dogrula
      When kullanici search inputuna "TShirt" yazar
      And arama butonuna tıklar
      Then aranan urunler sayfasinda oldugunu dogrula


      Scenario: kullanıcı sepete iki ürün ekler ve doğrular
        When ilk 2 ürünü sepete ekler
        And kullanici cart sayfasina gider
        Then sepette olan 2 ürünü dogrular

