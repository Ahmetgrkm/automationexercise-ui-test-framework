@recommended_items
  Feature: kullanıcı öenerilen ürünleri sepete ekler
    Background:
      Given kullanıcı "url" sayfasına gider
      Then Ana sayfanın başarıyla göründüğünü doğrular
      Scenario: kullanıcı sayfayı önerilen ürünlere kadar kaydırır ve önerilen ürünleri sepetine ekler ve doğrular
        When sayfa recommended itemse kadar kaydırılır
        And önerilen ürünlerden sepete eklenir
        And alısverise devam butonuna tıklanır
        And kullanici cart sayfasina gider
        Then sepette olan  ürünü dogrular