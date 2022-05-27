@smoke
  Feature: Login tests
    @smoke1
    Scenario: Login with valid credentials.
      Given MB open "http://ask-stage.portnov.com"
      Then MB type email "monmita.bora+1@gmail.com"
      Then MB type password "12345Abc"
      And MB click submit button
      Then MB verify successful login
    @smoke2
    Scenario: Copy option is disabled
      Given MB open url "http://ask-stage.portnov.com/#/login"
      Then MB types password "12345Abc"
    @smoke3
    Scenario: Cut option is disabled
      Given MB opens url "http://ask-stage.portnov.com/#/login"
      Then MB enters password "12345Abc"













































      







      





