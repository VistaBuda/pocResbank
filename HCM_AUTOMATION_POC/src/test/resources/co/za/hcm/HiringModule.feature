Feature: HCM

  @FunctionalTests
  Scenario Outline: Adding absence
    Given A user navigates to HomePage
    And user log in<username> <password>
    And user click on hiring
#    And user click on add
#    And user fills how section
#    And user fills how basic info section
#    And user fills hiring team section
#    And user fills requisition structure section
#    And user fills details section
#    And user fills work requirement section

    Examples:
      | username      | password     |absence_Type|dates|
      | TEST.SEC10 | welcome1 |             |     |