@view_brand
Feature: kullanıcı markaları görüntüler ve doğrular

  Background:
    Given kullanıcı "url" sayfasına gider
    Then Ana sayfanın başarıyla göründüğünü doğrular


  Scenario: Kullanıcı farklı markaları görüntüler ve doğrular
    Then sol menude markaların oldugunu dogrula
    When kullanici markalara ve tıklar ve dogrular