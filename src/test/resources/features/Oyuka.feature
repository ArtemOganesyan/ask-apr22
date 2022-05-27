@Smoke
Feature: Create test set "Quiz - Passing Percentage"
  @smoke1
  Scenario: Verify that there is a choice of Passing scores is available for assignment (0% - 100%)
    Given OB open url "http://ask-stage.portnov.com"
    Then OB type login "ayna114+1@gmail.com"
    And OB type password "Abcd12345"
    Then OB click "Submit" button
    And OB verify current user role set to "TEACHER"
    And OB wait for 3 seconds
    Then OB click "Quizzes" button
    And OB click "Create New Quiz" button
    Then OB type quiz title "QA engineer"
    And OB click "Add Question" button




