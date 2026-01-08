@post_login_cart_products
  Feature: kullanıcı giriş sonrası seğetteki ürünlerin varlığını kontrol eder.
    Scenario: kullanıcı sepete ürün ekledikten sonra giriş yapıp o ürünlerin varlığını doğrular
      Given kullanıcı "url" sayfasına gider
      Then Ana sayfanın başarıyla göründüğünü doğrular
      When Products butonuna tıkla
      Then ürünler sayfasında olduğunu dogrula
      When kullanici search inputuna "TShirt" yazar
      And arama butonuna tıklar
      Then aranan urunler sayfasinda oldugunu dogrula
      When ilk 2 ürünü sepete ekler
      And kullanici cart sayfasina gider
      Then sepette olan 2 ürünü dogrular
      When Proceed to checkout butonuna basar
      And acılan popda kayit olgiris yap seceneğine basar
      Then  'Hesabınıza giriş yapın' yazısının görünür olduğunu doğrular
      And   Geçerli bir e-posta ve şifre girer
      And   'login' butonuna tıklar
      Then  'Kullanıcı adı olarak giriş yapıldı' yazısının görünür olduğunu doğrular
      And kullanici cart sayfasina gider
      Then sepette olan 2 ürünü dogrular