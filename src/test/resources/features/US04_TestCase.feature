@Test_case
  Feature: Kullanıcı test case sayfasına gider ve doğrular
    Background: Kullanıcı ana sayfadadır
      Given kullanıcı "url" sayfasına gider

      Scenario: Kullanıcı test case sayfasına gider.
        Then  Ana sayfanın başarıyla göründüğünü doğrular
        When Test case e tıklar
        Then Test case sayfasinda oldugunu dogrular