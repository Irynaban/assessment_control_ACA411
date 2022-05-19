#Author: Elmira Grigorovich
@SingleChoiceQuestion
  Feature: Single Choice Question - Other
    Background:
      Given I go to "Login" page
      When I type "ask_instr@aol.com" into email field
      And I type "12345" into password field
      When I click the button "Sign In"
      And I wait for 2 sec
      When I click "Home" menu item
      And I wait for 3 sec
      #When I click "Submissions" menu item
      #And I wait for 5 sec
      When I click "Quizzes" menu item
      And I wait for 3 sec

    @SingleChoiceQuestion1
    Scenario: Teacher can create Single-Choice question with Including "Other" text area option
      When I click button "Create New Quiz"
      And I wait for 2 sec
      When I type "Elmira Quiz Title" as quiz title
      And I add a quiz question
      And I wait for 3 sec
      When I click "Single-Choice" question type
      And I wait for 3 sec
      When I Type "2+2=?" into "Q1"
      And I wait for 3 sec
      And I type "4" as "Option 1*" into "Q1"
      And I type "5" as "Option 2*" into "Q1"
      And I wait for 4 sec
      Then I select "Option 1*" as a correct answer in "Q1"
      And I wait for 4 sec
      And I click include other option
      And I wait for 4 sec
      And I click button "Save"
      And I wait for 4 sec
      Then quiz "Elmira Quiz Title" is displayed on the list of the quizzes
      And I wait for 4 sec
      And I open quiz "Elmira Quiz Title"
      And I wait for 4 sec
      And the option "Other" should be displayed

    @SingleChoiceQuestion2
    Scenario: Teacher can not create quiz Single-Choice question with blank option field
      When I click button "Create New Quiz"
      And I wait for 2 sec
      When I type "Elmira Quiz Title" as quiz title
      And I add a quiz question
      And I wait for 3 sec
      When I click "Single-Choice" question type
      And I wait for 3 sec
      When I Type "2+2=?" into "Q1"
      And I wait for 3 sec
      And I type "4" as "Option 1*" into "Q1"
      And I wait for 3 sec
      Then I select "Option 1*" as a correct answer in "Q1"
      And I wait for 4 sec
      And I click include other option
      And I wait for 4 sec
      And I click button "Save"
      And I wait for 4 sec
      And I check error message "This field is required" should be displayed
      And I wait for 4 sec

    @SingleChoiceQuestion2
    Scenario: Teacher can not create quiz Single-Choice question without choosing correct answer
      When I click button "Create New Quiz"
      And I wait for 2 sec
      When I type "Elmira Quiz Title" as quiz title
      And I add a quiz question
      And I wait for 3 sec
      When I click "Single-Choice" question type
      And I wait for 3 sec
      When I Type "2+2=?" into "Q1"
      And I wait for 3 sec
      And I type "4" as "Option 1*" into "Q1"
      And I type "5" as "Option 2*" into "Q1"
      And I wait for 4 sec
      And I click include other option
      And I wait for 4 sec
      And I click button "Save"
      And I wait for 4 sec
      And I check error message "*Choose correct answer" is displayed
      And I wait for 3 sec








