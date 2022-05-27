@smokeVH
  Feature: Smoke steps for registration-email, setting(teacher)-full name, submissions-reviewed

    @smokeVH1
    Scenario: Verify that Alphanumeric and special characters are accepted in Email input field
      Given VH open url "http://ask-stage.portnov.com/#/registration"
      When VH type first name "L"
      And VH type last name "June"
      And VH type email "testingT1'a@domain.com"
      And VH type group code "APR18"
      Then VH type password "12345A"
      And VH type confirm password "12345A"
      Then VH click register button
      And VH wait for 1 seconds
      Then VH should see confirmation of successful registering


      #clicking on submit without enabling email input field
    @smokeVH2
    Scenario: Verify that Email field when registering can't be empty
      Given VH open url "http://ask-stage.portnov.com/#/registration"
      When VH type first name "L"
      And VH type last name "June"
      And VH type group code "APR18"
      Then VH type password "12345A"
      And VH type confirm password "12345A"
      Then VH click register button
      And VH wait for 1 seconds
      Then VH error message about Empty field should be displayed
      And VH verify that user couldn't register if error message "This field is required" is displayed

    @smokeVH3
    Scenario: Verify that Email input field accepts local port with 64 characters on the left of an @ domain on the right with 63 characters followed by (.)  with 63 characters in last part of domain
      Given VH open url "http://ask-stage.portnov.com/#/registration"
      When VH type first name "L"
      And VH type last name "June"
      And VH type email "ERT123BGgdksun_tkkf56yfheidlcnhhfejb.wf-dhwdwbdwgdwgdwgvdyvwERgT@bebejbgwekgnwennwefkefnkwnfwnfnwfmwmflfnwfbwufwbfwjfcnskcns.com"
      And VH type group code "APR18"
      Then VH type password "12345A"
      And VH type confirm password "12345A"
      Then VH click register button
      And VH wait for 1 seconds
      Then VH should see confirmation of successful registering


      #Negative testing, bug found
    @smokeVH4
    Scenario:Verify that Email with more than 128 characters is not accepted in the input field
      Given VH open url "http://ask-stage.portnov.com/#/registration"
      When VH type first name "L"
      And VH type last name "June"
      And VH type email "ERT123BGgdksun_tkk#56yfheidlcnhhfejb.wf-dhwdwbdwgdwgdwgdyvwERgTn23BGgdksunmifk#56yfheimdlcnhhfejbfwfvdihwdwbdwgdwgdwgv@domain.com"
      And VH type group code "APR18"
      Then VH type password "12345A"
      And VH type confirm password "12345A"
      When VH click register button
      Then VH error message "Too long. Should be no more than 128 characters" should be displayed

    @smokeVH5
      #doesnt work at all
    Scenario: Verify that email input field doesn't accept white spaces
      Given VH open url "http://ask-stage.portnov.com/#/registration"
      When VH type first name "L"
      And VH type last name "June"
      And VH type email "   "
      And VH type group code "APR18"
      Then VH type password "12345A"
      And VH type confirm password "12345A"
      When VH click register button
      Then VH error message that "Should be a valid email address" should be displayed


    @smokeVH6
    Scenario: Verify that email address with multiple dots should be rejected (two ".." after domain name)
      Given VH open url "http://ask-stage.portnov.com/#/registration"
      When VH type first name "L"
      And VH type last name "June"
      And VH type email "testingT1@domain..com"
      And VH type group code "APR18"
      Then VH type password "12345A"
      And VH type confirm password "12345A"
      When VH click register button
      Then VH should see error message about Invalid email
      And VH wait for 2 seconds
      Then VH error message that "Should be a valid email address" should be displayed
      
    @smokeVH7
    Scenario: Verify, that email address without "." after domain name is rejected
      Given VH open url "http://ask-stage.portnov.com/#/registration"
      When VH type first name "L"
      And VH type last name "June"
      And VH type email "testingT1@domaincom"
      And VH type group code "APR18"
      Then VH type password "12345A"
      And VH type confirm password "12345A"
      Then VH should see error message about Invalid email
      When VH click register button
      And VH wait for 2 seconds
      Then VH error message that "Should be a valid email address" should be displayed


    @smokeVH8
      Scenario: Verify, that email address without "@" is rejected when register
        Given VH open url "http://ask-stage.portnov.com/#/registration"
        When VH type first name "L"
        And VH type last name "June"
        And VH type email "testingT1domain.com"
        And VH type group code "APR18"
        Then VH type password "12345A"
        And VH type confirm password "12345A"
        Then VH should see error message about Invalid email
        When VH click register button
      Then VH error message that "Should be a valid email address" should be displayed



      @smokeVH9
      Scenario: Verify the email field with the Plus "+" sign is considered a valid character
        Given VH open url "http://ask-stage.portnov.com/#/registration"
        When VH type first name "L"
        And VH type last name "June"
        And VH type email "testingT1+1@domain.com"
        And VH type group code "APR18"
        Then VH type password "12345A"
        And VH type confirm password "12345A"
        When VH click register button
        Then VH should see confirmation of successful registering
        And VH wait for 3 seconds

      @smokeVH10
      Scenario: Verify that email address with missing top-level domain (.com/.net/.org/etc) is rejected
        Given VH open url "http://ask-stage.portnov.com/#/registration"
        When VH type first name "L"
        And VH type last name "June"
        And VH type email "testing1@domain"
        And VH type group code "APR18"
        Then VH type password "12345A"
        And VH type confirm password "12345A"
        When VH click register button
        And VH should see error message about Invalid email
        Then VH error message that "Should be a valid email address" should be displayed

        #Teacher, settings-full name
      @smokeVH11
      Scenario:Verify that teacher can change its Full Name with Alphanumeric and Special Characters
        Given VH open url "http://ask-stage.portnov.com"
        When VH type email "holovatiuk.victoria+3@gmail.com"
        And VH type password "test123"
        And VH click Sign In button
        Then VH homepage should be displayed
        And VH homepage should contain role "TEACHER"
        When VH click on Settings button
        Then VH settings page should be displayed
        And VH click on Change Name button
        Then VH remove existing name from the New Name field
        When VH type "Bc!2#) *'`-." into New Name input field
        And VH click Change button
        And VH wait for 2 seconds
        Then VH should see new name as "Bc!2#) *'`-."

      @smokeVH12
        #when I perform manually then button is disabled
      Scenario:Verify that when changing the Full Name on the teachers account, Full Name can't be empty
        Given VH open url "http://ask-stage.portnov.com"
        When VH type email "holovatiuk.victoria+3@gmail.com"
        And VH type password "test123"
        And VH click Sign In button
        Then VH homepage should be displayed
        And VH wait for 2 seconds
        And VH homepage should contain role "TEACHER"
        When VH click on Settings button
        Then VH settings page should be displayed
        And VH click on Change Name button
        And VH wait for 2 seconds
        Then VH remove existing name from the New Name field
        And VH click around change name panel
        And VH wait for 3 seconds
        Then VH verify that Change name button should be disabled
        And VH error message that "This field is required" about Full Name should be displayed


      @smokeVH13
      Scenario: Verify that when changing Full Name, New Name input field accepts 256 characters including 1 space between two words
        Given VH open url "http://ask-stage.portnov.com"
        When VH type email "holovatiuk.victoria+3@gmail.com"
        And VH type password "test123"
        And VH click Sign In button
        Then VH homepage should be displayed
        And VH homepage should contain role "TEACHER"
        When VH click on Settings button
        Then VH settings page should be displayed
        And VH click on Change Name button
        Then VH remove existing name from the New Name field
        When VH type "12Abc17463524bdgvDFGcfbjbjnkankf*)!@njdmdbwfhwbfhbwhbfhwbfhwbfhwbfhwxagxavvxhdavdhqvqqjdlqjdlqdvisiysvgnwdgwgwgjHKAKNXBvshMSBFKENEKNGLDK43527614 h$@BFJEFVBFWHFWJHFWHKHFHWKFHKWHFKWhcfhwsvfwjfjwbfjbwkhgfriwyrifjjfbbbbftowtotuo3wuto3whtwl1234jfbjwbfwbfkwfbk6f" into New Name input field
        And VH click Change button
      Then VH should see new name as "12Abc17463524bdgvDFGchfbjbjnkankf*)!@njdmdbwfhwbfhbwhbfhwbfhwbfhwbfhwxagxavvxhdavdhqvqqjdlqjdlqdvisiysvgnwdgwgwgjHKAKNXBvshMSBFKENEKNGLDK43527614 h$@BFJEFVBFWHFWJHFWHKHFHWKFHKWHFKWhcfhwsvfwjfjwbfjbwkhgfriwyrifjjfbbbbftowtotuo3wuto3whtwl1234jfbjwbfwbfkwfbk6f"
     #bug found. It should accept 256 characters according to requrements

    @smokeVH14
    Scenario: Verify that when changing Full Name, New Name input field should not accept 257 characters including 1 space between two words (max+1)
      Given VH open url "http://ask-stage.portnov.com"
      When VH type email "holovatiuk.victoria+3@gmail.com"
      And VH type password "test123"
      And VH click Sign In button
      Then VH homepage should be displayed
      And VH homepage should contain role "TEACHER"
      When VH click on Settings button
      Then VH settings page should be displayed
      And VH click on Change Name button
      Then VH remove existing name from the New Name field
      When VH type "12Abc17463524bdgvDFGchfbjbjnkankf*)!@njdmdbwfhwbfhbwhbfhwbfhwbfhwbfhwxagxavvxhdavdhqvqqjdlqjdlqdvisiysvgnwdgwgwgjHKAKNXBvshMSBFKENEKNGLDK43527614 h$@BFJEFVBFWHFWJHFWHKHFHWKFHKWHFKWhcfhwsvfwjfjwbfjbwkhgfriwyrifjjfbbbbftowtotuo3wuto3whtwl1234jfbjwbfwbfkwfbk6f" into New Name input field
      And VH click Change button
      Then VH should see error message as "Too long. Should be no more than 256 characters"


    @smokeVH15
    Scenario: Verify that 2 characters plus 1 white space between two words is accepted by the New Name input field when changing the Full Name
      Given VH open url "http://ask-stage.portnov.com"
      When VH type email "holovatiuk.victoria+3@gmail.com"
      And VH type password "test123"
      And VH click Sign In button
      Then VH homepage should be displayed
      And VH homepage should contain role "TEACHER"
      When VH click on Settings button
      Then VH settings page should be displayed
      And VH click on Change Name button
      Then VH remove existing name from the New Name field
      When VH type "B B" into New Name input field
      And VH click Change button
      Then VH should see new name as "B B"

    @smokeVH16
    Scenario: Verify that Full Name input field doesn't accept only 1 character plus 1 white space (req: 2 char + 1 space between)
      Given VH open url "http://ask-stage.portnov.com"
      When VH type email "holovatiuk.victoria+3@gmail.com"
      And VH type password "test123"
      And VH click Sign In button
      Then VH homepage should be displayed
      And VH homepage should contain role "TEACHER"
      When VH click on Settings button
      Then VH settings page should be displayed
      And VH click on Change Name button
      Then VH remove existing name from the New Name field
      When VH type "B " into New Name input field
      And VH click Change button
      And VH error message that name is too short should be displayed
      #last step should be fail because message is not correct not corresponding to the case
    @smokeVH17
    Scenario: Verify that Full Name input field should not accept only 1 character
      Given VH open url "http://ask-stage.portnov.com"
      When VH type email "holovatiuk.victoria+3@gmail.com"
      And VH type password "test123"
      And VH click Sign In button
      Then VH homepage should be displayed
      And VH homepage should contain role "TEACHER"
      When VH click on Settings button
      Then VH settings page should be displayed
      And VH click on Change Name button
      Then VH remove existing name from the New Name field
      When VH type "B" into New Name input field
      Then VH click Change button
      And VH error message that name is too short should be displayed
      #last step should be fail because message is not corresponding to the case


    @smokeVH18
    Scenario: Verify that trailing and leading spaces when changing Full Name, in the New Name input field are not allowed
      Given VH open url "http://ask-stage.portnov.com"
      When VH type email "holovatiuk.victoria+3@gmail.com"
      And VH type password "test123"
      And VH click register button
      Then VH homepage should be displayed
      And VH homepage should contain role "TEACHER"
      When VH click on Settings button
      Then VH settings page should be displayed
      And VH click on Change Name button
      Then VH remove existing name from the New Name field
      When VH type "  Jul Vyl  " into New Name input field
      And VH should see error message that "White spaces are not allowed"
      Then VH verify that Change name button should be disabled

    @smokeVH19
     Scenario: Verify that white spaces are not allowed while changing Full Name to the New Full Name
      Given VH open url "http://ask-stage.portnov.com"
      When VH type email "holovatiuk.victoria+3@gmail.com"
      And VH type password "test123"
      And VH click Sign In button
      Then VH homepage should be displayed
      And VH homepage should contain role "TEACHER"
      When VH click on Settings button
      Then VH settings page should be displayed
      And VH click on Change Name button
      Then VH remove existing name from the New Name field
      When VH type "      " into New Name input field
      And VH should see error message that "White spaces are not allowed"
      Then VH verify that Change name button should be disabled



    @smokeVH20
    Scenario: Verify, that automatically graded quiz is redirected to "Reviewed" column after reviewing and clicking "Save" button
      Given VH open url "http://ask-stage.portnov.com"
      When VH type email "holovatiuk.victoria+3@gmail.com"
      And VH type password "test123"
      And VH click Sign In button
      Then VH homepage should be displayed
      And VH wait for 1 seconds
      And VH homepage should contain role "TEACHER"
      When VH click submissions button
      Then VH see submission page
      Then VH click on Automatically Graded button
      And VH wait for 1 seconds
      Then VH should see Automatically Graded page result
      And VH wait for 1 seconds
      And VH click on Review button to grade quiz
      Then VH see opened quiz page
      And VH click on Save button to grade
      #now I need to verify that quiz was moved from automatically graded to reviewed
      Then VH should see that quiz in the Reviewed tab


    @smokeVH21
    Scenario:Verify that teacher can review already graded quiz (quiz which is located under "Reviewed" column)
      Given VH open url "http://ask-stage.portnov.com"
      When VH type email "holovatiuk.victoria+3@gmail.com"
      And VH type password "test123"
      And VH click Sign In button
      Then VH homepage should be displayed
      And VH homepage should contain role "TEACHER"
      When VH click submissions button
      Then VH see submission page
      Then VH click on Automatically Graded button
      Then VH should see Automatically Graded page result
      And VH click on Reviewed button
      Then VH Reviewed page should be displayed
      Then VH click on review button to review graded quiz
      Then VH see opened quiz page





