Feature: HCM

  @FunctionalTests
  Scenario Outline: Adding absence
    Given A user navigates to HomePage
    And user log in<username> <password>
    And user click on time absences module
    And user click on add absence component
    And user select type of absence
    And user capture time
    Then saves and close

    Examples:
      | username      | password     |absence_Type|dates|
      | Tshepo.Setshedi | Welcome@1 |             |     |
