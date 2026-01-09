@CorrectLogin

Feature: US02 Kullanıcı başarılı bir şekilde login olabilmeli

  Background: Kullanıcı ana sayfadadır
    Given kullanıcı "url" sayfasına gider

    Scenario: TC01 Yeni kullanıcı başarılı şekilde login olabilmeli
      Then  Ana sayfanın başarıyla göründüğünü doğrular
      When kullanıcı "Signup / Login" butonuna tıklar
      Then  'Hesabınıza giriş yapın' yazısının görünür olduğunu doğrular
      And   Geçerli bir e-posta ve şifre girer
      And   'login' butonuna tıklar
      Then  'Kullanıcı adı olarak giriş yapıldı' yazısının görünür olduğunu doğrular


      @FalseLogin
      Scenario: TC01 Kullanıcı yanlış mail ve şifre girerek login olamaz
        Then  Ana sayfanın başarıyla göründüğünü doğrular
        When kullanıcı "Signup / Login" butonuna tıklar
        Then  'Hesabınıza giriş yapın' yazısının görünür olduğunu doğrular
        And Yanlis Mail ve Sifre girer.
        And   'login' butonuna tıklar
        Then 'Your email or password is incorrect!' yazısının görünür olduğunu doğrular


        @Logout
        Scenario: Kullanıcı çıkış işlemi yapar
          Then  Ana sayfanın başarıyla göründüğünü doğrular
          When kullanıcı "Signup / Login" butonuna tıklar
          Then  'Hesabınıza giriş yapın' yazısının görünür olduğunu doğrular
          And   Geçerli bir e-posta ve şifre girer
          And   'login' butonuna tıklar
          Then  'Kullanıcı adı olarak giriş yapıldı' yazısının görünür olduğunu doğrular
          When  'Logout' butonuna tıklar
          Then  'Hesabınıza giriş yapın' yazısının görünür olduğunu doğrular

