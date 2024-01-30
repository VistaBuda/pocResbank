Feature: HCM

  @FunctionalTests
  Scenario Outline: Adding absence
    Given A user navigates to HomePage
    When user log in<username> <password>


    Examples:
      | username      | password     |absence_Type|dates|
      | Tshepo.Setshedi | Welcome@1 |             |     |
