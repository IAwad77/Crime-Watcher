Feature: Incident submission
  Scenario: Citizen files and admin resolves
    Given the report page is open
    When I submit report type \"THEFT\" at \"7th\" with description \"Phone\"
    And admin sets status to \"RESOLVED\" with note \"ok\"
    Then the API shows status \"RESOLVED\"
