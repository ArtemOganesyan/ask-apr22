@smoke
  Feature: Login tests

    @smoke1
    Scenario: Login with valid credentials
      Given MB open url "http://ask-stage.portnov.com"
      And I wait for 1 seconds
      Then I type email "monmita.bora+1@gmail.com"
      And I type password "12345Abc"
      Then I click submit button
      And I wait for 3 seconds
      And I verify current user role set to "TEACHER"
    @smoke2
    Scenario: Login with invalid credentials
      Given MB open url "http://ask-stage.portnov.com/#/login"
      Then I type email "monmita.bora+1@gmail.com"
      And I type password "abc135!"
      Then I click submit button
    @smoke3
    Scenario: Copy option is disabled
      Given MB open url "http://ask-stage.portnov.com/#/login"
      Then I type password "12345Abc"
      And highlight on password field
    @smoke4
    Scenario: Cut option is disabled
      Given MB open url "http://ask-stage.portnov.com/#/login"
      Then MB type password "12345Abc"
      And MB highlight on password field
























      







      





