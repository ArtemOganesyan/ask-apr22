@smoke
  Feature: Smoke tests

    @smoke1
      Scenario: "Group code" input field is accepted Alphanumeric and Special characters
      Given AA open url as "http://ask-stage.portnov.com/#/registration"
      Then AA type first name "Alona"
      Then AA type last name "Avtunich"
      Then AA type email "avtunicha+123@gmail.com"
      Then AA type group code "AB-3!"
      Then AA type password "test1"
      Then AA type confirm password "test1"
      Then AA click button Submit
      And verify that user has been registered

    @smoke2
      Scenario: "Group code" input field is accepted min number of characters (min 1 character)
        Given AA open url as "http://ask-stage.portnov.com/#/registration"
        Then AA type first name "Alona"
        Then AA type last name "Avtunich"
        Then AA type email "avtunicha+123@gmail.com"
        Then AA type group code "A"
        Then AA type password "test1"
        Then AA type confirm password "test1"
        Then AA click button Submit
        And verify that user has been registered

    @smoke3
      Scenario: "Group code" input field is accepted max number of characters (max 10 characters)
        Given AA open url as "http://ask-stage.portnov.com/#/registration"
        Then AA type first name "Alona"
        Then AA type last name "Avtunich"
        Then AA type email "avtunicha+123@gmail.com"
        Then AA type group code "ABC-12345!"
        Then AA type password "test1"
        Then AA type confirm password "test1"
        Then AA click button Submit
        And verify that user has been registered

    @smoke4
      Scenario: "Group code" input field are not accepted max +1 characters (According to requirement max 10 characters)
        Given AA open url as "http://ask-stage.portnov.com/#/registration"
        Then AA type first name "Alona"
        Then AA type last name "Avtunich"
        Then AA type email "avtunicha+123@gmail.com"
        Then AA type group code "ABC-123456!"
        Then AA type password "test1"
        Then AA type confirm password "test1"
        Then AA click button Submit
        And AA should see validation message

    @smoke5
      Scenario: "Group code" input field can't be empty
        Given AA open url as "http://ask-stage.portnov.com/#/registration"
        Then AA type first name "Alona"
        Then AA type last name "Avtunich"
        Then AA type email "avtunicha+123@gmail.com"
        Then AA leave group code input field empty
        Then AA type password "test1"
        Then AA type confirm password "test1"
        Then AA click button Submit
        And AA validation message is appear "This field is required"

    @smoke6
    Scenario: "Group code" input field are not accepted white spaces
      Given AA open url as "http://ask-stage.portnov.com/#/registration"
      Then AA type first name "Alona"
      Then AA type last name "Avtunich"
      Then AA type email "avtunicha+123@gmail.com"
      Then AA type just white spaces in group code field "     "
      Then AA type password "test1"
      Then AA type confirm password "test1"
      Then AA click button Submit
      And AA should see error message "Whitespaces are not allowed"


    @smoke7
    Scenario: "Group code" input field are not accepted white spaces between characters
      Given AA open url as "http://ask-stage.portnov.com/#/registration"
      Then AA type first name "Alona"
      Then AA type last name "Avtunich"
      Then AA type email "avtunicha+123@gmail.com"
      Then AA type group code "ABC 12"
      Then AA type password "test1"
      Then AA type confirm password "test1"
      Then AA click button Submit
      And AA should see error message "Whitespaces are not allowed"

#    @smoke8
#    Scenario: "Single-Choice Quiz with no textual question" that quiz automatically got "Passed" status
#      Given AA open url "http://ask-stage.portnov.com"
#      Then AA type email "avtunicha+1@gmail.com"
#      And AA type password "NM12345"
#      Then AA click button Submit
#      And AA wait for 4 sec
#      Then main page should be displayed
#      Then AA click on Quizzes in the left panel
##     And quiz page should be displayed
##     Then AA click on Create new quiz button
##     Then AA type title name of quiz "Alona-11"
##     Then AA click on add question button















