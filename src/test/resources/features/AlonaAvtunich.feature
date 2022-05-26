@smoke
  Feature: Smoke tests

    @smoke1
      Scenario: "Group code" input field is accepted Alphanumeric and Special characters
      Given I open url as "http://ask-stage.portnov.com/#/registration"
      Then I type first name "Alona"
      Then I type last name "Avtunich"
      Then I type email "avtunicha+123@gmail.com"
      Then I type group code "AB-3!"
      Then I  type password "test1"
      Then I type confirm password "test1"
      Then I click button Submit
      And verify that user has been registered

    @smoke2
      Scenario: "Group code" input field is accepted min number of characters (min 1 character)
        Given I open url as "http://ask-stage.portnov.com/#/registration"
        Then I type first name "Alona"
        Then I type last name "Avtunich"
        Then I type email "avtunicha+123@gmail.com"
        Then I type group code "A"
        Then I  type password "test1"
        Then I type confirm password "test1"
        Then I click button Submit
        And verify that user has been registered

    @smoke3
      Scenario: "Group code" input field is accepted max number of characters (max 10 characters)
        Given I open url as "http://ask-stage.portnov.com/#/registration"
        Then I type first name "Alona"
        Then I type last name "Avtunich"
        Then I type email "avtunicha+123@gmail.com"
        Then I type group code "ABC-12345!"
        Then I  type password "test1"
        Then I type confirm password "test1"
        Then I click button Submit
        And verify that user has been registered

    @smoke4
      Scenario: "Group code" input field are not accepted max +1 characters (According to requirement max 10 characters)
        Given I open url as "http://ask-stage.portnov.com/#/registration"
        Then I type first name "Alona"
        Then I type last name "Avtunich"
        Then I type email "avtunicha+123@gmail.com"
        Then I type group code "ABC-123456!"
        And I should see validation message

    @smoke5
      Scenario: "Group code" input field can't be empty
        Given I open url as "http://ask-stage.portnov.com/#/registration"
        Then I type first name "Alona"
        Then I type last name "Avtunich"
        Then I type email "avtunicha+123@gmail.com"
        Then I leave group code input field empty
        Then I  type password "test1"
        Then I type confirm password "test1"
        Then I click button Submit
        And I validation massage is appear

    @smoke6
    Scenario: "Group code" input field are not accepted white spaces
      Given I open url as "http://ask-stage.portnov.com/#/registration"
      Then I type first name "Alona"
      Then I type last name "Avtunich"
      Then I type email "avtunicha+123@gmail.com"
      Then I type just white spaces in group code field "     "
      When I click on element field I should see error message

    @smoke7
    Scenario: "Group code" input field are not accepted white spaces between characters
      Given I open url as "http://ask-stage.portnov.com/#/registration"
      Then I type first name "Alona"
      Then I type last name "Avtunich"
      Then I type email "avtunicha+123@gmail.com"
      Then I type group code "ABC 12"
      When I click on element field I should see error message

    @smoke8
    Scenario: "Single-Choice Quiz with no textual question" that quiz automatically got "Passed" status
      Given I open url "http://ask-stage.portnov.com"
      Then I type login "avtunicha+1@gmail.com"
      And I type password "NM12345"
      Then I click submit button
      And I wait for 3 seconds
      And I verify current user role set to "TEACHER"
      Then I click on quiz in the left menu panel
      Then page should displayed
      Then I click Create new Quiz button
#      Then I should see page









