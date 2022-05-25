@Ask
  Feature: Single choice question - text

    @Ask1
    Scenario: Allowable characters: Alphanumeric & Sp. characters
      Given I open url "http://ask-stage.portnov.com/#/login"
      Then I type teacher email "ankitha.narayana+t@gmail.com"
      Then I type password "12345abc"
      Then I wait for 3 seconds
      And I verify current user role set to "TEACHER"
      Then I click "Quizzes" option
      Then I see list of quizzes
      Then I click "Create New Quiz" option
      And I type "SQA Single choice questions" in the text field
      Then I click "Add Question" option
      And I select "Single-Choice" option
      Then I type "Which of the following is not included in failure costs?" in the question field
      Then I type "rework" in option 1
      Then I type "repair" in option 2
      And I click "Add option" option
      And I type "failure mode analysis" in option 3
      And I type "none of the mentioned" in option 4
      Then I select option 4 as correct answer
      Then I click "Save" option
      Then I verify question is added

      
      
      
      







      
      