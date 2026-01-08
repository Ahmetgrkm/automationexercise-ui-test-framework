@view_category
Feature: kullanıcı kategorileri görüntüler ve doğrular

  Background:
    Given kullanıcı "url" sayfasına gider
    Then Ana sayfanın başarıyla göründüğünü doğrular

    Scenario: Kullanıcı farklı senaryoları görüntüler ve doğrular
      Then sol menude categorynin oldugunu dogrula
      When kullanici kategorilere ve alt kategorilere tıklar ve dogrular
