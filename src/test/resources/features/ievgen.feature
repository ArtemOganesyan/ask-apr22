@smokecopy
Feature: Smoke tests

  @smoke1copy
  Scenario: Login as a student
    Given I open url "http://ask-stage.portnov.com"
    Then I type login "artem.oganesyan+s@gmail.com"
    And I type password "12345Abc"
    Then I click submit button
    And I wait for 3 seconds
    And I verify current user role set to "STUDENT"

  @smoke2copy
  Scenario: Login as a teacher
    Given I open url "http://ask-stage.portnov.com"
    Then I type login "artem.oganesyan+t@gmail.com"
    And I type password "12345Abc"
    Then I click submit button
    And I wait for 3 seconds
    And I verify current user role set to "TEACHER"