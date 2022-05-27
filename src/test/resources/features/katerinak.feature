@scenario
  Feature: Changing password

    @scenario1
    Scenario: Password allows alphanumeric and special characters
      Given I KK type url "http://ask-stage.portnov.com"
      Then I KK type email as "mikeb512@teeenye.com"
      And I KK type password as "12345"
      And I KK wait for 1 seconds
      And I KK click on Sign in
      And I KK wait for 2 seconds
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
        And I KK wait for 1 seconds
        And I KK click on Sign in
        And I KK wait for 2 seconds
        Then I KK click on Settings 
        Then I KK click on button Change Your Password
        Then I KK type new password "123456"
        Then I KK confirm new password "123456"
        And I KK wait for 1 seconds
        And I KK verify that error message is displayed "This field is required"
        And I KK verify the Change button is disabled

      @scenario3
      Scenario: New password field cannot be empty
        Given I KK type url "http://ask-stage.portnov.com"
        Then I KK type email as "mikeb512@teeenye.com"
        And I KK type password as "12345"
        And I KK wait for 1 seconds
        And I KK click on Sign in
        And I KK wait for 2 seconds
        Then I KK click on Settings
        Then I KK click on button Change Your Password
        Then I KK type old password "12345"
        And I KK confirm new password "123456"
        And I KK wait for 10 seconds
        And I KK verify that error message is displayed "This field is required"
        And I KK verify the Change button is disabled

      @scenario4
      Scenario:Confirm password field cannot be empty
        Given I KK type url "http://ask-stage.portnov.com"
        Then I KK type email as "mikeb512@teeenye.com"
        And I KK type password as "12345"
        And I KK wait for 1 seconds
        And I KK click on Sign in
        And I KK wait for 2 seconds
        Then I KK click on Settings
        Then I KK click on button Change Your Password
        Then I KK type old password "12345"
        And I KK type new password "123456"
        And I KK verify that error message is displayed "This field is required"
        And I KK verify the Change button is disabled

      @scenario5
      Scenario: Verify that cancel button redirects back to settings page
        Given I KK type url "http://ask-stage.portnov.com"
        Then I KK type email as "mikeb512@teeenye.com"
        And I KK type password as "12345"
        And I KK wait for 1 seconds
        And I KK click on Sign in
        And I KK wait for 2 seconds
        Then I KK click on Settings
        Then I KK click on button Change Your Password
        Then I KK click on cancel button
        Then I KK verify that page goes back to home screen and see role as "STUDENT"

      @scenario6
      Scenario: Verify that password does not accept less than 5 characters.
        Given I KK type url "http://ask-stage.portnov.com"
        Then I KK type email as "mikeb512@teeenye.com"
        And I KK type password as "12345"
        And I KK wait for 1 seconds
        And I KK click on Sign in
        And I KK wait for 2 seconds
        Then I KK click on Settings
        Then I KK click on button Change Your Password
        Then I KK type old password "12345"
        And I KK type new password "abcd"
        And I KK confirm new password "abcd"
        And I KK verify the message is displayed "Too short. Should be at least 5 characters"
        And I KK verify the Change button is disabled

      @scenario7
      Scenario: Verify that password does not accept more than 32 characters.
        Given I KK type url "http://ask-stage.portnov.com"
        Then I KK type email as "mikeb512@teeenye.com"
        And I KK type password as "12345"
        And I KK wait for 1 seconds
        And I KK click on Sign in
        And I KK wait for 2 seconds
        Then I KK click on Settings
        Then I KK click on button Change Your Password
        Then I KK type old password "12345"
        And I KK type new password "qwertyuiopasdfghjklzxcvbn123!@#$%"
        And I KK confirm new password "qwertyuiopasdfghjklzxcvbn123!@#$%"
        And I KK verify the error message "Too long. Should be no more than 32 characters" is displayed
        And I KK verify the Change button is disabled

      @scenario8
      Scenario: Verify that white spaces are not allowed in new Password
        Given I KK type url "http://ask-stage.portnov.com"
        Then I KK type email as "mikeb512@teeenye.com"
        And I KK type password as "12345"
        And I KK wait for 1 seconds
        And I KK click on Sign in
        And I KK wait for 2 seconds
        Then I KK click on Settings
        Then I KK click on button Change Your Password
        Then I KK type old password "12345"
        And I KK type new password "abc d"
        And I KK confirm new password "abc d"
        And I KK verify that "White spaces are not allowed" is displayed
        And I KK verify the Change button is disabled

      @scenario9
      Scenario:New Password must match Confirm Password
        Given I KK type url "http://ask-stage.portnov.com"
        Then I KK type email as "mikeb512@teeenye.com"
        And I KK type password as "12345"
        And I KK wait for 1 seconds
        And I KK click on Sign in
        And I KK wait for 2 seconds
        Then I KK click on Settings
        Then I KK click on button Change Your Password
        Then I KK type old password "12345"
        And I KK type new password "abcde"
        And I KK confirm new password "abcdef"
        Then I KK confirm the message "Entered passwords should match" is displayed
        And I KK verify the Change button is disabled

        @scenario10
        Scenario:Password field must have current password
          Given I KK type url "http://ask-stage.portnov.com"
          Then I KK type email as "mikeb512@teeenye.com"
          And I KK type password as "12345"
          And I KK wait for 1 seconds
          And I KK click on Sign in
          And I KK wait for 2 seconds
          Then I KK click on Settings
          Then I KK click on button Change Your Password
          Then I KK type old password "123abc"
          And I KK type new password "abcdef"
          And I KK confirm new password "abcdef"
          Then I KK click button Change
          Then I KK confirm the error message "Authentication failed. User not found or password does not match" is displayed

        @scenario11
        Scenario: Verify that password accepts 5 characters minimum.
          Given I KK type url "http://ask-stage.portnov.com"
          Then I KK type email as "mikeb512@teeenye.com"
          And I KK type password as "12345"
          And I KK wait for 1 seconds
          And I KK click on Sign in
          And I KK wait for 2 seconds
          Then I KK click on Settings
          Then I KK click on button Change Your Password
          Then I KK type old password "12345"
          And I KK type new password "abcde"
          And I KK confirm new password "abcde"
          Then I KK click button Change

        @scenario12
        Scenario: Verify that password accepts 32 characters.
          Given I KK type url "http://ask-stage.portnov.com"
          Then I KK type email as "mikeb512@teeenye.com"
          And I KK type password as "12345"
          And I KK wait for 1 seconds
          And I KK click on Sign in
          And I KK wait for 2 seconds
          Then I KK click on Settings
          Then I KK click on button Change Your Password
          Then I KK type old password "12345"
          And I KK type new password "qwertyuiopasdfghjklzxcvbn123!@#$"
          And I KK confirm new password "qwertyuiopasdfghjklzxcvbn123!@#$"
          Then I KK click button Change















