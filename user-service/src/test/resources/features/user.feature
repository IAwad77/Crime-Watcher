Feature: User signup via UI
  Scenario: Citizen registers
    Given the signup page is open
    When I register user \"Hanan\" with email \"hanan@demo.com\"
    Then I should see confirmation containing \"Hanan\"
