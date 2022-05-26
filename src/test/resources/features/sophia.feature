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
      Then I select Textuall Question button





