@test
Feature: ASK
  Background:
    Given I open url "http://ask-stage.portnov.com"
    Then I type email "teacher-ask@mailinator.com"
    And I type password "12345Abc!"
    Then I click submit button
    And I wait for 3 seconds

    @test1
    Scenario: Teacher - Create quiz
      Then I open url "http://ask-stage.portnov.com/#/quizzes"
      And I wait for 3 seconds
      Then I click create new quiz button
      And I wait for 3 seconds
      And I provide string "_Quiz11-test" as title of the quiz
      And I click add question
      And I select question type "Single-Choice" in the question section 1
      And I type "Test" to question title into question section 1
      And I wait for 3 seconds
      And I mark option number 1 as correct answer in question section 1
      And I add "text1" to the field "Option 1*" into question section 1
      And I add "text2" to the field "Option 2*" into question section 1
      And I save the quiz
      And I wait for 5 seconds
      And I see the list of quizzes

    @test2
    Scenario: Teacher - Verify that quiz is present in the list
      Then I open url "http://ask-stage.portnov.com/#/quizzes"
      And I wait for 3 seconds
      And I verify that quiz with name "_Quiz11-test" is present in the list

    @test3
      Scenario: Teacher - Quiz - Create At date corresponds Update At date
        Then I open url "http://ask-stage.portnov.com/#/quizzes"
        And I wait for 3 seconds
        And I verify that quiz with name "_Quiz11-test" is present in the list
        And I click on the quiz "_Quiz11-test"
        And I verify that quiz's "_Quiz11-test" Create At date corresponds Update At date

    @test4
      Scenario: Teacher - Delete quiz
        Then I open url "http://ask-stage.portnov.com/#/quizzes"
        And I wait for 3 seconds
        And I verify that quiz with name "_Quiz11-test" is present in the list
        And I click on the quiz "_Quiz11-test"
        And I delete quiz "_Quiz11-test"
        And I wait for 3 seconds
        And I confirm delete procedure
        And I wait for 3 seconds
        And I verify that quiz with name "_Quiz11-test" is not present in the list