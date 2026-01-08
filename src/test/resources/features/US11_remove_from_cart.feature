@remove_from_cart
  Feature: kullanıcı sepetten ürün siler
    Background:
      Given kullanıcı "url" sayfasına gider
      Then Ana sayfanın başarıyla göründüğünü doğrular
      When ilk 2 ürünü sepete ekler
      And kullanici cart sayfasina gider
      Then sepette olan 2 ürünü dogrular

      Scenario: kullanıcı sepetten ürün siler
        When sepet boşalana kadar tüm ürünleri siler
        Then sepetin boş olduğunu dogrular