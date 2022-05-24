@smokeVH
  Feature: 
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

