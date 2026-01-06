@Subscription

Feature: Kullanıcı abone olur ve doğrulanır
  Background: Background: Kullanıcı ana sayfadadır
    Given kullanıcı "url" sayfasına gider
    Then Ana sayfanın başarıyla göründüğünü doğrular

    Scenario: kullanıcı abone olur ve başarıyla abone olduğu doğrulanır

      When sayfa altbilgiye kaydirilir
      Then Abonelik yazısı dogrulanir
      When Kullanici e-posta girer
      And ok tusuna basar
      Then Basari mesajini dogrular

      @Cart_Subscription
      Scenario: Kullanıcı cart sayfasında abone olur ve doğrulanır
        Given kullanici cart sayfasina gider
        When sayfa altbilgiye kaydirilir
        Then Abonelik yazısı dogrulanir
        When Kullanici e-posta girer
        And ok tusuna basar
        Then Basari mesajini dogrular
