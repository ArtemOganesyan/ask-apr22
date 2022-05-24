@smokeTeacher
  Feature: Change User Name
    Scenario: Login as a teacher
      Given I open url "http://ask-stage.portnov.com"
      Then I type login "testerhanoi1610+2@gmail.com"
      And I type password "22222"
      Then I click submit button
      And I wait for 2 seconds
      And I verify current user role set to "TEACHER"
      Then I click Settings button
      And I wait for 2 seconds
      Then I click on Change Your Name button
      And I type New Name "David"
      And I wait for 2 seconds
      Then I click on Change button
      And I verify a New Name is changed to "David"



