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
  Scenario: Create new quiz with Multiple-choice
    Given I open url "http://ask-stage.portnov.com"
    Then I type login "trentonio@sewce.com"
    And I type password "12345"
    Then I click submit button
    And I wait for 3 seconds
    And I verify current user role set to "TEACHER"
    Then I click on "Quizzes" in the sidebar
    And I wait for 3 seconds
    Then I click on Create New Quiz button
    And I wait for 3 seconds
    Then I type title of the quiz "Chemistry" in the field
    And I click on Add question button
    Then I select question type "Multiple-Choice" for question 1
    And I type text "Question number 1" for question 1
    And I type text "A" for option 1 for question 1
    And I type text "B" for option 2 for question 1
    And I select option 2 as a correct answer for question 1
    And I click Save button
    Then quiz "Chemistry" appeared in list of quizzes
    And I click on Preview button for quiz "Chemistry"
    And I click Close button
    And I delete quiz "Chemistry"





