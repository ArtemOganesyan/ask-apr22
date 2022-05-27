@newFile.roza
  Feature: file created.

    @smoke1
    Scenario: Login as student
      Given I R open url "http://ask-stage.portnov.com"
      Then I R type login "raberha+3@gmail.com"
      And I R type password "123456789"
      Then I R click submit button
      And I R wait for 6 seconds
      And I R verify current user role set to "STUDENT"
      Then I R click my grades button

    @smoke2
    Scenario: Login as a teacher
      Given I open url "http://ask-stage.portnov.com"
      Then I type login "raberha+1@gmail.com"
      And I type password "123456789"
      Then I click submit button
      And I wait for 3 seconds
      And I verify current user role set to "TEACHER"
