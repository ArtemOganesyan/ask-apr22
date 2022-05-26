@test
  Feature: Student My Grades

    @test1
    Scenario: The graded quiz is displayed at "My Grade" page 
      Given DD open url "http://ask-stage.portnov.com/#/login"
      Then DD type login "medvedeva.d.d+4@gmail.com"
      And DD type password "qwerty"
      Then DD click submit button
      Then DD wait for 3 seconds
      And DD verify current user role set to "STUDENT"
      Then DD click My Grade button


    

      

