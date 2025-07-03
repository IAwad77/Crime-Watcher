Feature: Gateway routing

  Scenario: User list flows through gateway
    Given the gateway test page is open
    When I click load users
    Then results contain '['
