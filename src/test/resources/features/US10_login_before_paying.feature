@login_before_paying
  Feature: kulanıcı giriş yaptıktan sonra ödeme yapar
    Background:
    Background:
      Given kullanıcı "url" sayfasına gider
      Then Ana sayfanın başarıyla göründüğünü doğrular
      When kullanıcı "Signup / Login" butonuna tıklar
      Then  'Hesabınıza giriş yapın' yazısının görünür olduğunu doğrular
      And   Geçerli bir e-posta ve şifre girer
      And   'login' butonuna tıklar
      Then  'Kullanıcı adı olarak giriş yapıldı' yazısının görünür olduğunu doğrular

      Scenario: kullanıcı girişden sonra ödeme yapar
        When ilk 2 ürünü sepete ekler
        And kullanici cart sayfasina gider
        Then sepette olan 2 ürünü dogrular
        When Proceed to checkout butonuna basar
        And yorum inputunu doldurur
        When place order butonuna basar
        Then ödeme sayfasında oldugunu dogrular
        When kart bilgilerini girer
        And ödeme butonuna basar
        Then siparişin başarıyla verildiğini doğrular
        When  'Delete Account' butonuna tıklar
        Then  'HESAP SILINDI!' yazısının görünür olduğunu doğrular