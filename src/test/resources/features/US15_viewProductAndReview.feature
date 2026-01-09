@view_Product
  Feature: ürün detayı
    Background:
      Given kullanıcı "url" sayfasına gider
      Then Ana sayfanın başarıyla göründüğünü doğrular
      When Products butonuna tıkla
      Scenario: kulanıcı ürünü görüntüler ve  başarılı bir yorum yapar
      And ilk ürünün ürünü görüntüle butonuna basılır
      Then Write your review yazısını doğrular
      When yorum kısmını doldurur ve gönderir
      Then cıkan mesajı dogrular
