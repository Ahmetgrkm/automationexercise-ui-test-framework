@upArrow
  Feature: yukarı ok tuşu
    Background:
      Given kullanıcı "url" sayfasına gider
      Then Ana sayfanın başarıyla göründüğünü doğrular

      Scenario: kullanıcı sayfayı aşağı kaydırdıktan sonra sayfanın sağ altındaki yukarı ok tuşuna basar
        When sayfayı asagı kaydirir
        And yukari ok tusuna basar
        Then sayfanın basındaki baslıgı dogrular

        @orphan_upward_scroll
        Scenario:  kullanıcı ok tuşu kullanmadan yukarı ve aşağı gider
          When sayfayı asagı kaydirir
          Then Abonelik yazısı dogrulanir
          When sayfayı ok olmadan yukarı kaydırır
          Then sayfanın basındaki baslıgı dogrular