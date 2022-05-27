@step
  Feature:ASK

    @step1
    Scenario: Teacher change students name
      Given  TA open url "http://ask-stage.portnov.com"
      Then TA type email "tabai0204+1@gmail.com"
      And TA type password "12345678"
      Then TA click submit button
      Then TA wait for 2 sec
      Then TA navigate to "User's management page"
      Then TA wait for 2 sec
      And TA click on student name "Aikanysh Tabaldyeva"
      Then TA click on button "options"
      Then TA wait for 2 sec
      And TA click "Change User's Name" button
      Then TA type "Aikanysh Tab" into "New User's name field"
      Then TA click on "Change" button
      And TA verify new user name set to "Aikanysh Tab"






