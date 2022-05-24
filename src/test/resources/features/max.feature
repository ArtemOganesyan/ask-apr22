@smoke
Feature: Smoke tests

  @smoke1
  Scenario: Login as a teacher
    Given I open url "http://ask-stage.portnov.com"
    Then I type login "trentonio@sewce.com"
    And I type password "12345"
    Then I click submit button
    And I wait for 3 seconds
    And I verify current user role set to "TEACHER"

  @smoke2
  Scenario: Create new quiz
    Given I open url "http://ask-stage.portnov.com"
    Then I type login "trentonio@sewce.com"
    And I type password "12345"
    Then I click submit button
    And I wait for 3 seconds
    And I verify current user role set to "TEACHER"
    Then I click on "Quizzes" in the sidebar
    And I wait for 3 seconds
    Then I click on "Create New Quiz" button

