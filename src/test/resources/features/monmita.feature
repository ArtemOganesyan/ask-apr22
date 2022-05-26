@smoke
  Feature: Login tests

    @smoke1
    Scenario: Login with valid credentials
      Given I open url "http://ask-stage.portnov.com"
      Then I type email "monmita.bora+1@gmail.com"
      And I type password "12345Abc"
      Then I click submit button
      And I wait for 3 seconds
      And I verify current user role set to "TEACHER"
    @smoke2
    Scenario: Login with invalid credentials
      Given I open url "http://ask-stage.portnov.com/#/login"
      Then I type email "monmita.bora+1@gmail.com"
      And I type password "abc135!"
      Then I click submit button











      







      





