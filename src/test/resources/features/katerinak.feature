@scenario
  Feature: Changing password

    @scenario1
    Scenario: Password allows alphanumeric and special characters
      Given I KK type url "http://ask-stage.portnov.com"
      Then I KK type email as "mikeb512@teeenye.com"
      And I KK type password as "12345"
      Then I KK click on Settings
      Then I KK click on button Change Your Password
      Then I KK type old password "12345"
      And I KK type new password "12345!@#$%^&*"
      And I KK confirm new password "12345!@#$%^&*"
      Then I KK click button Change

      @scenario2
      Scenario: Password field is required and cannot be empty
        Given I KK type url "http://ask-stage.portnov.com"
        Then I KK type email as "mikeb512@teeenye.com"
        And I KK type password as "12345"
        Then I KK click on Settings 
        Then I KK click on button Change Your Password
        Then I KK type new password "123456"
        Then I KK confirm new password "123456"
        And I KK verify that error message is displayed "This field is required"




