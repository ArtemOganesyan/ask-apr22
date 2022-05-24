@scenario
  Feature: Changing password

    @scenario1
    Scenario: Password allows alphanumeric and special characters
      Given I type url "http://ask-stage.portnov.com"
      Then I type email as "mikeb512@teeenye.com"
      And I type password as "12345"
      Then I click on "Settings"
      Then I click on button "Change Your Password"
      Then I type old password "12345"
      And I type new password "12345!@#$%^&*"
      And I confirm new password "12345!@#$%^&*"
      Then I click button "Change"


