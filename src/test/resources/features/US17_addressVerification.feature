@address_verification
  Feature: adres doğrulama
    Background:
      Given kullanıcı "url" sayfasına gider
      Then Ana sayfanın başarıyla göründüğünü doğrular
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

      Scenario:kullanıcı sepete eklediği ürünlere ödeme yaparekn adresini doğrular
        Then olusturulan adre ile hafızadaki adresi karsılastırır.
