@test
  Feature: Student My Grades

    @test1
 Scenario: Login in as a Student
      Given DD open url "http://ask-stage.portnov.com/#/login"
      Then DD type login "medvedeva.d.d+4@gmail.com"
      And DD type password "qwerty"
      Then DD click submit button
      Then DD wait for 3 seconds
      And DD verify current user role set to "STUDENT"

    @test2
    Scenario: The graded quiz is displayed at "My Grade" page
      Given DD open url "http://ask-stage.portnov.com/#/login"
      Then DD type login "medvedeva.d.d+4@gmail.com"
      And DD type password "qwerty"
      Then DD click submit button
      Then DD wait for 3 seconds
      Then DD click My Grade button
      And DD verify that graded quiz is displayed

      @test3
      Scenario:The page with the detailed graded quiz are displayed
        Given DD open url "http://ask-stage.portnov.com/#/login"
        Then DD type login "medvedeva.d.d+4@gmail.com"
        And DD type password "qwerty"
        Then DD click submit button
        Then DD wait for 3 seconds
        Then DD click My Grade button
        Then DD wait for 3 seconds
        And DD click Details button
        Then DD see the page with grades details

        @test4
        Scenario:The page with the detailed graded quiz is closed after clicking on the "Close" button
          Given DD open url "http://ask-stage.portnov.com/#/login"
          Then DD type login "medvedeva.d.d+4@gmail.com"
          And DD type password "qwerty"
          Then DD click submit button
          Then DD wait for 3 seconds
          Then DD click My Grade button
          Then DD wait for 3 seconds
          And DD click Details button
          Then DD see the page with grades details
          Then DD wait for 3 seconds
          And DD click Close button






    

      

