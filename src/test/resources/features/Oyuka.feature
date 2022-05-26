@Smoke
Feature: Oyuka's tests

  @smoke1
  Scenario: Go to "My grades" as a student
    Given I open url "http://ask-stage.portnov.com"
    Then I type login "ayna114@gmail.com"
    And I type password "Abcd1234"
    Then I click submit button
    And I wait for 3 seconds
    Then I click "My Grades" button