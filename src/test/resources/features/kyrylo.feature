@test
Feature: ASK
  Background:
    Given KM open url "http://ask-stage.portnov.com"
    Then KM type email "teacher-ask@mailinator.com"
    And KM type password "12345Abc!"
    Then KM click submit button
    And KM wait for 3 seconds

    @test1
    Scenario: Teacher - Create quiz
      Then KM open url "http://ask-stage.portnov.com/#/quizzes"
      And KM wait for 3 seconds
      Then KM click create new quiz button
      And KM wait for 3 seconds
      And KM provide string "_Quiz11-test" as title of the quiz
      And KM click add question
      And KM select question type "Single-Choice" in the question section 1
      And KM type "Test" to question title into question section 1
      And KM wait for 3 seconds
      And KM mark option number 1 as correct answer in question section 1
      And KM add "text1" to the field "Option 1*" into question section 1
      And KM add "text2" to the field "Option 2*" into question section 1
      And KM save the quiz
      And KM wait for 5 seconds
      And KM see the list of quizzes

    @test2
    Scenario: Teacher - Verify that quiz is present in the list
      Then KM open url "http://ask-stage.portnov.com/#/quizzes"
      And KM wait for 3 seconds
      And KM verify that quiz with name "_Quiz11-test" is present in the list

    @test3
    Scenario: Teacher - Quiz - Create At date corresponds Update At date
      Then KM open url "http://ask-stage.portnov.com/#/quizzes"
      And KM wait for 3 seconds
      And KM verify that quiz with name "_Quiz11-test" is present in the list
      And KM click on the quiz "_Quiz11-test"
      And KM verify that quiz's "_Quiz11-test" Create At date corresponds Update At date

    @test4
    Scenario: Teacher - Edit Quiz - Update At doesn't correspond Create At date
      Then KM open url "http://ask-stage.portnov.com/#/quizzes"
      And KM wait for 3 seconds
      And KM verify that quiz with name "_Quiz11-test" is present in the list
      And KM click on the quiz "_Quiz11-test"
      And KM edit quiz "_Quiz11-test"
      And KM wait for 2 seconds
      And KM click add question
      And KM select question type "Single-Choice" in the question section 2
      And KM type "Test2" to question title into question section 2
      And KM wait for 3 seconds
      And KM mark option number 2 as correct answer in question section 2
      And KM add "wrong" to the field "Option 1*" into question section 2
      And KM add "correct" to the field "Option 2*" into question section 2
      And KM save the quiz
      And KM wait for 5 seconds
      And KM see the list of quizzes
      And KM click on the quiz "_Quiz11-test"
      And KM wait for 5 seconds
      And KM verify that quiz's "_Quiz11-test" Updated At different from Crated At date

    @test5
    Scenario: Teacher - Delete quiz
      Then KM open url "http://ask-stage.portnov.com/#/quizzes"
      And KM wait for 3 seconds
      And KM verify that quiz with name "_Quiz11-test" is present in the list
      And KM click on the quiz "_Quiz11-test"
      And KM delete quiz "_Quiz11-test"
      And KM wait for 3 seconds
      And KM confirm delete procedure
      And KM wait for 3 seconds
      And KM verify that quiz with name "_Quiz11-test" is not present in the list
