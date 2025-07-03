Feature: Crime hotspots

  Scenario: Citizen checks hotspot list
    Given the hotspot page is open
    When I request hotspots
    Then at least 0 hotspots are shown
