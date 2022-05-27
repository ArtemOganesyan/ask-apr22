@smoketesting
  Feature: smoke testing
    
    Background: log in with teacher credential
      Given I open "http://ask-stage.portnov.com/#/login"
      Then I type teacherEmail "sophialenz134+2@gmail.com"
      Then I type teacherPassword "test123"
      Then I click Sign In button
      Then I wait 3 seconds

    @smoketesting1
    Scenario: Teacher - create quiz
      Given I open "http://ask-stage.portnov.com/#/quizzes"
      Then I wait 3 seconds
      Then click Create New Quiz button
      Then I wait 3 seconds
      Then I type title of the quiz "SL Quiz"
      And click Add Questions button
      Then I wait 3 seconds
      Then I select question type "Textual" in "Q1"
      And I type "Test" into question field
      Then I click Save button
      Then I wait 3 seconds
      Then I verify quiz "SL Quiz" is created
      
    @smoketesting2
    Scenario: Teacher assigns quiz
      Given I open "http://ask-stage.portnov.com/#/assignments"
      Then I wait 3 seconds
      Then I click Create New Assignment
      Then I click Select Quiz to Assign drop-down menu
      Then I select quiz to assign "SL Quiz"
      Then I select student name "Sophia Student"
      Then I click Give Assignment button
      Then I verify quiz "SL Quiz" assigned to "Sophia Student"




      




