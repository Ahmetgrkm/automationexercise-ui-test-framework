@invoice_download
  Feature: fatura indirme
    Background:
      Given kullanıcı "url" sayfasına gider
      Then Ana sayfanın başarıyla göründüğünü doğrular
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

      Scenario: kullanıcı sipariş faturasını indirir ve doğrular
      Then faturanın basarıyla indirildigini dogrular