@product
  Feature: Tüm ürünler ve ürün detay sayfası doğrulanır
    Background: Background: Kullanıcı ana sayfadadır
      Given kullanıcı "url" sayfasına gider

      Scenario: Ürünleri ve ürün detayını doğrulama

        Then Ana sayfanın başarıyla göründüğünü doğrular
        When Products butonuna tıkla
        Then ürünler sayfasında olduğunu dogrula
        And ilk ürünün ürünü görüntüle butonuna basılır
        Then Tüm ürünler sayfasına gidildiğini dogrula:
          | Field         |
          | Product Name  |
          | Category      |
          | Price         |
          | Availability  |
          | Condition     |
          | Brand         |

