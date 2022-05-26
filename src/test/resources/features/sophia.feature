@smoketesting
  Feature: smoke testing
    
    @smoketesting1
    Scenario: log in with teacher credential
      Given I open "http://ask-stage.portnov.com/#/login"
      Then I type teacherEmail "sophialenz134+2@gmail.com"
      Then I type teacherPassword "test123"
      Then I click Sign In button

    @smoketesting2
    Scenario: Teacher - create quiz
      Given I open "http://ask-stage.portnov.com/#/quizzes"



