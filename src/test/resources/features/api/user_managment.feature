@ApiUser
Feature: User Management

  @NewUser
  Scenario: Create a new user
    Given the following user information:
      | id | username | firstName | lastName | email         | password | phone     | userStatus |
      | 1  | FcoSan   | Francisco | Sanchez  | fco@gmail.com | 1234Abcd | 699877898 | 1          |
    When the user creates his or her user in Store
    Then the a new user is created
    And the new user created should include the following details:
      | FcoSan    |
      | Francisco |
      | Sanchez   |



