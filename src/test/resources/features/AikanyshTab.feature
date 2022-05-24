@step test
  Feature: Login steps
    @step1
    Scenario: Login as a student
      Given I open url "http://ask-stage.portnov.com"
      Then I type login "tabai0204+1@gmail.com"
      And I type password "12345Abc"
      Then I click submit button
      And I wait for 3 seconds
      And I verify current user role set to "STUDENT"
