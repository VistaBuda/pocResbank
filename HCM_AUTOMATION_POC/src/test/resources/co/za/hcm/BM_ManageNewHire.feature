Feature: Benefit

  @FunctionalTests
  Scenario Outline: New employee benefits
    Given A user navigates to HomePage
    And user log in<username> <password>
    And user click on benefits module
    And user click on start enrolment
    And user add people to cover
    And user add Beneficiary Organizations
    Then saves and close

    Examples:
      | username      | password     |absence_Type|dates|
      | Sibusiso.Yingwane | welcome1 |             |     |
