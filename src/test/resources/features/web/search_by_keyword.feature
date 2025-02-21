@Web
Feature: Search by keyword

  @Searching
  Scenario: Searching
    Given the user is on the Home Page
    When the user is searching by the keyword "automatización"
    And find the wikipedia link result
    Then the user should see in which year the first automatic process was created

