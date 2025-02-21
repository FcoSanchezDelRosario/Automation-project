
Feature: Pets Management

  @AddPets @ApiPets
  Scenario Outline: Adding a new pet
    Given the following pets information:
      | id   | category_id   | category_name   | name   | status   |
      | <id> | <category_id> | <category_name> | <name> | <status> |
    When the user adds the new pets to the store
    Then the user find by id the new pet added
    Examples:
      | id | category_id | category_name    | name | status    |
      | 1  | 1           | Golden Retriever | Otto | available |
      | 2  | 4           | Bulldog          | Ron  | sold      |
      | 3  | 7           | Beagle           | Max  | sold      |
      | 4  | 7           | Bulldog          | Max  | sold      |


  @FindPetSoldStatus @ApiPets
  Scenario: Find pet by status sold
    When the user searches all the pets by "status" "sold"
    Then the user shows the names of the sold pets

  @ApiPets @CountingPets
  Scenario: Counting pets with the same name
    Given the user has collected all the information on the pets sold
    Then user counts how many pets have the same name