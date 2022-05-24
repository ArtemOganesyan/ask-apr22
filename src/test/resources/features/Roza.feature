@newFile.roza
  Feature: file created.

    @method
    Feature: assignment
      Scenario:complete assignment

    @smoke1
    Scenario: Login as a student
      Given I open url "http://ask-stage.portnov.com"
      Then I type login "raberha+3@gmail.com"
      And I type password "123456789"
      Then I click submit button
      And I wait for 3 seconds
      And I verify current user role set to "STUDENT"

    @smoke2
    Scenario: Login as a teacher
      Given I open url "http://ask-stage.portnov.com"
      Then I type login "raberha+1@gmail.com"
      And I type password "123456789"
      Then I click submit button
      And I wait for 3 seconds
      And I verify current user role set to "TEACHER"
