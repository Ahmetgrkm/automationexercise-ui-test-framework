@Contact_us
  Feature: Kullanıcı bize ulaşın işlemini yapar
    Background: Kullanıcı ana sayfadadır
      Given kullanıcı "url" sayfasına gider

    Scenario: Kullanıcı bize ulaşın işlemini yapar
      Then  Ana sayfanın başarıyla göründüğünü doğrular
      When Bize ulasin butonuna basar
      Then Bize ulasin sayfasına gittigini dogrular
      And formu doldurur
      When Submit butonuna basar
      And Home butonuna tıklar
      Then  Ana sayfanın başarıyla göründüğünü doğrular


