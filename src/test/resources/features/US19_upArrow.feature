@upArrow
  Feature: yukarı ok tuşu
    Background:
      Given kullanıcı "url" sayfasına gider
      Then Ana sayfanın başarıyla göründüğünü doğrular

      Scenario: kullanıcı sayfayı aşağı kaydırdıktan sonra sayfanın sağ altındaki yukarı ok tuşuna basar
        When sayfayı asagı kaydirir
        And yukari ok tusuna basar
        Then sayfanın basındaki baslıgı dogrular