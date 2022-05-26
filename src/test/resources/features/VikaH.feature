@smokeVH
  Feature: Smoke steps for registration-email, setting(teacher)-full name, submissions-reviewed

    @smokeVH1
    Scenario: Verify that Alphanumeric and special characters are accepted in Email input field
      Given I open url "http://ask-stage.portnov.com/#/registration"
      When I type first name "L"
      And I type last name "June"
      And I type email "testingT1'a@domain.com"
      And I type group code "APR18"
      Then I type password "12345A"
      And I type confirm password "12345A"
      Then I click submit button
      And I wait for 3 seconds
      Then page should contain text "You have been registered"

    @smokeVH2
        #clicking on submit without enabling email input field
    Scenario: Verify that Email field when registering can't be empty
      Given I open url "http://ask-stage.portnov.com/#/registration"
      When I type first name "L"
      And I type last name "June"
      And I type group code "APR18"
      Then I type password "12345A"
      And I type confirm password "12345A"
      Then I click submit button
      Then error message about Empty field should be displayed

    @smokeVH3
    Scenario: Verify that Email input field accepts local port with 64 characters on the left of an @ domain on the right with 63 characters followed by (.)  with 63 characters in last part of domain
      Given I open url "http://ask-stage.portnov.com/#/registration"
      When I type first name "L"
      And I type last name "June"
      And I type email "ERT123BGgdksun_tkkf56yfheidlcnhhfejb.wf-dhwdwbdwgdwgdwgvdyvwERgT@bebejbgwekgnwennwefkefnkwnfwnfnwfmwmflfnwfbwufwbfwjfcnskcns.com"
      And I type group code "APR18"
      Then I type password "12345A"
      And I type confirm password "12345A"
      Then I click submit button
      And I wait for 2 seconds
      Then page should contain text "You have been registered"

    @smokeVH4
      #Negative testing, bug found
    Scenario:Verify that Email with more than 128 characters is not accepted in the input field
      Given I open url "http://ask-stage.portnov.com/#/registration"
      When I type first name "L"
      And I type last name "June"
      And I type email "ERT123BGgdksun_tkk#56yfheidlcnhhfejb.wf-dhwdwbdwgdwgdwgdyvwERgTn23BGgdksunmifk#56yfheimdlcnhhfejbfwfvdihwdwbdwgdwgdwgv@domain.com"
      And I type group code "APR18"
      Then I type password "12345A"
      And I type confirm password "12345A"
      When I click submit button
      And I wait for 2 seconds
      Then element should not be displayed

    @smokeVH5
      #doesnt work at all
    Scenario: Verify that email input field doesn't accept white spaces
      Given I open url "http://ask-stage.portnov.com/#/registration"
      When I type first name "L"
      And I type last name "June"
      And I type email "   "
      And I wait for 2 seconds

    @smokeVH6
    Scenario: Verify that email address with multiple dots should be rejected (two ".." after domain name)
      Given I open url "http://ask-stage.portnov.com/#/registration"
      When I type first name "L"
      And I type last name "June"
      And I type email "testingT1@domain..com"
      And I type group code "APR18"
      Then I type password "12345A"
      And I type confirm password "12345A"
      When I click submit button
      And I wait for 2 seconds
      Then error message about Invalid email should be displayed

    @smokeVH7
    Scenario: Verify, that email address without "." after domain name is rejected
      Given I open url "http://ask-stage.portnov.com/#/registration"
      When I type first name "L"
      And I type last name "June"
      And I type email "testingT1@domaincom"
      And I type group code "APR18"
      Then I type password "12345A"
      And I type confirm password "12345A"
      When I click submit button
      And I wait for 2 seconds
      Then error message about Invalid email should be displayed

      @smokeVH8
      Scenario: Verify, that email address without "@" is rejected when register
        Given I open url "http://ask-stage.portnov.com/#/registration"
        When I type first name "L"
        And I type last name "June"
        And I type email "testingT1domain.com"
        Then error message about Invalid email should be displayed
        And I type group code "APR18"
        Then I type password "12345A"
        And I type confirm password "12345A"
        When I click submit button
        And I wait for 2 seconds


      @smokeVH9
      Scenario: Verify the email field with the Plus "+" sign is considered a valid character
        Given I open url "http://ask-stage.portnov.com/#/registration"
        When I type first name "L"
        And I type last name "June"
        And I type email "testingT1+1@domain.com"
        And I type group code "APR18"
        Then I type password "12345A"
        And I type confirm password "12345A"
        When I click submit button
        And I wait for 2 seconds
        Then page should contain text "You have been registered"

      @smokeVH10
      Scenario: Verify that email address with missing top-level domain (.com/.net/.org/etc) is rejected
        Given I open url "http://ask-stage.portnov.com/#/registration"
        When I type first name "L"
        And I type last name "June"
        And I type email "testing1@domain"
        And I type group code "APR18"
        Then I type password "12345A"
        And I type confirm password "12345A"
        When I click submit button
        And I wait for 2 seconds
        And error message about Invalid email should be displayed

        #Teacher, settings-full name
      @smokeVH11
      Scenario:Verify that teacher can change its Full Name with Alphanumeric and Special Characters
        Given I open url "http://ask-stage.portnov.com"
        When I type email "holovatiuk.victoria+3@gmail.com"
        And I type password "test123"
        And I click submit button
        Then homepage should be displayed
        And I wait for 2 seconds
        And homepage should contain role "TEACHER"
        When I click on Settings button
        And I wait for 2 seconds
        Then settings page should be displayed
        And I click on Change Name button
        Then I remove existing name from the New Name field
        And I wait for 1 seconds
        When I type "Bc!2#) *'`-." into New Name input field
        And I click Change button
        And I wait for 2 seconds
        Then name should be listed as new name

      @smokeVH12
      Scenario:Verify that when changing the Full Name on the teachers account, Full Name can't be empty
        Given I open url "http://ask-stage.portnov.com"
        When I type email "holovatiuk.victoria+3@gmail.com"
        And I type password "test123"
        And I click submit button
        Then homepage should be displayed
        And I wait for 2 seconds
        And homepage should contain role "TEACHER"
        When I click on Settings button
        And I wait for 2 seconds
        Then settings page should be displayed
        And I click on Change Name button
        Then I remove existing name from the New Name field
        And I wait for 1 seconds
        Then submission of change name button should be disabled
        And error message should be displayed


      @smokeVH13
      Scenario: Verify that when changing Full Name, New Name input field accepts 256 characters including 1 space between two words
        Given I open url "http://ask-stage.portnov.com"
        When I type email "holovatiuk.victoria+3@gmail.com"
        And I type password "test123"
        And I click submit button
        Then homepage should be displayed
        And I wait for 2 seconds
        And homepage should contain role "TEACHER"
        When I click on Settings button
        And I wait for 2 seconds
        Then settings page should be displayed
        And I click on Change Name button
        Then I remove existing name from the New Name field
        And I wait for 1 seconds
        When I type "12Abc17463524bdgvDFGcfbjbjnkankf*)!@njdmdbwfhwbfhbwhbfhwbfhwbfhwbfhwxagxavvxhdavdhqvqqjdlqjdlqdvisiysvgnwdgwgwgjHKAKNXBvshMSBFKENEKNGLDK43527614 h$@BFJEFVBFWHFWJHFWHKHFHWKFHKWHFKWhcfhwsvfwjfjwbfjbwkhgfriwyrifjjfbbbbftowtotuo3wuto3whtwl1234jfbjwbfwbfkwfbk6f" into New Name input field
        And I wait for 1 seconds
        And I click Change button
        And I wait for 2 seconds
        Then name should be listed as new name


    @smokeVH14
    Scenario: Verify that when changing Full Name, New Name input field should not accept 257 characters including 1 space between two words (max+1)
      Given I open url "http://ask-stage.portnov.com"
      When I type email "holovatiuk.victoria+3@gmail.com"
      And I type password "test123"
      And I click submit button
      Then homepage should be displayed
      And I wait for 2 seconds
      And homepage should contain role "TEACHER"
      When I click on Settings button
      And I wait for 2 seconds
      Then settings page should be displayed
      And I click on Change Name button
      Then I remove existing name from the New Name field
      And I wait for 1 seconds
      When I type "12Abc17463524bdgvDFGchfbjbjnkankf*)!@njdmdbwfhwbfhbwhbfhwbfhwbfhwbfhwxagxavvxhdavdhqvqqjdlqjdlqdvisiysvgnwdgwgwgjHKAKNXBvshMSBFKENEKNGLDK43527614 h$@BFJEFVBFWHFWJHFWHKHFHWKFHKWHFKWhcfhwsvfwjfjwbfjbwkhgfriwyrifjjfbbbbftowtotuo3wuto3whtwl1234jfbjwbfwbfkwfbk6f" into New Name input field
      And I wait for 1 seconds
      And I click Change button
      And I wait for 2 seconds
      Then name should be listed as new name


    @smokeVH15
    Scenario: Verify that 2 characters plus 1 white space between two words is accepted by the New Name input field when changing the Full Name
      Given I open url "http://ask-stage.portnov.com"
      When I type email "holovatiuk.victoria+3@gmail.com"
      And I type password "test123"
      And I click submit button
      Then homepage should be displayed
      And I wait for 2 seconds
      And homepage should contain role "TEACHER"
      When I click on Settings button
      And I wait for 2 seconds
      Then settings page should be displayed
      And I click on Change Name button
      Then I remove existing name from the New Name field
      And I wait for 1 seconds
      When I type "B B" into New Name input field
      And I click Change button
      And I wait for 2 seconds
      Then name should be listed as new name

    @smokeVH16
    Scenario: Verify that Full Name input field doesn't accept only 1 character plus 1 white space (req: 2 char + 1 space between)
      Given I open url "http://ask-stage.portnov.com"
      When I type email "holovatiuk.victoria+3@gmail.com"
      And I type password "test123"
      And I click submit button
      Then homepage should be displayed
      And I wait for 2 seconds
      And homepage should contain role "TEACHER"
      When I click on Settings button
      And I wait for 2 seconds
      Then settings page should be displayed
      And I click on Change Name button
      Then I remove existing name from the New Name field
      And I wait for 1 seconds
      When I type "B " into New Name input field
      And I wait for 1 seconds
      Then submission of change name button should be disabled
      And error message should be displayed

    @smokeVH17
    Scenario: Verify that Full Name input field should not accept only 1 character
      Given I open url "http://ask-stage.portnov.com"
      When I type email "holovatiuk.victoria+3@gmail.com"
      And I type password "test123"
      And I click submit button
      Then homepage should be displayed
      And I wait for 2 seconds
      And homepage should contain role "TEACHER"
      When I click on Settings button
      And I wait for 2 seconds
      Then settings page should be displayed
      And I click on Change Name button
      Then I remove existing name from the New Name field
      And I wait for 1 seconds
      When I type "B" into New Name input field
      And I wait for 1 seconds
      Then submission of change name button should be disabled
      And error message should be displayed


    @smokeVH18
    Scenario: Verify that trailing and leading spaces when changing Full Name, in the New Name input field are not allowed
      Given I open url "http://ask-stage.portnov.com"
      When I type email "holovatiuk.victoria+3@gmail.com"
      And I type password "test123"
      And I click submit button
      Then homepage should be displayed
      And I wait for 2 seconds
      And homepage should contain role "TEACHER"
      When I click on Settings button
      And I wait for 2 seconds
      Then settings page should be displayed
      And I click on Change Name button
      Then I remove existing name from the New Name field
      And I wait for 1 seconds
      When I type "  Jul Vyl  " into New Name input field
      And I wait for 1 seconds
      And error message about White spaces should be displayed
      Then submission of change name button should be disabled


    @smokeVH19
     Scenario: Verify that white spaces are not allowed while changing Full Name to the New Full Name
    Scenario: Verify that trailing and leading spaces when changing Full Name, in the New Name input field are not allowed
      Given I open url "http://ask-stage.portnov.com"
      When I type email "holovatiuk.victoria+3@gmail.com"
      And I type password "test123"
      And I click submit button
      Then homepage should be displayed
      And I wait for 2 seconds
      And homepage should contain role "TEACHER"
      When I click on Settings button
      And I wait for 2 seconds
      Then settings page should be displayed
      And I click on Change Name button
      Then I remove existing name from the New Name field
      And I wait for 1 seconds
      When I type "      " into New Name input field
      And I wait for 1 seconds
      And error message about White spaces should be displayed
      Then submission change name button should be disabled



    @smokeVH20
      Scenario: Verify, that automatically graded quiz is redirected to "Reviewed" column after reviewing and clicking "Save" button
        Given I open url "http://ask-stage.portnov.com"
        When I type email "holovatiuk.victoria+3@gmail.com"
        And I type password "test123"
        And I click submit button
        Then homepage should be displayed
        And I wait for 2 seconds
        And homepage should contain role "TEACHER"
        When I click submissions button
        And I wait for 1 seconds
        Then I see submission page
        Then I click on Automatically Graded button
        And I wait for 1 seconds
        Then I should see Automatically Graded page result
        And I click on Reviewed button
        And I wait for 2 seconds
        Then Reviewed page should be displayed
      Then I click on review button to review graded quiz


