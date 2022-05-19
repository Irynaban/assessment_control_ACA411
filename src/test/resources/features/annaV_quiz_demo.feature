@quiz
  Feature: Quiz
    Background:
      Given I go to "Login" page
      When I type "annaverpcs.ask@gmail.com" into email field
      And I type "12345" into password field
      When I click the button "Sign In"
      And I wait for 2 sec
      When I click "Quizzes" menu item
      And I wait for 2 sec

    @quiz1
    Scenario: Create a Quiz
      When I click the button "Create New Quiz"
      And I wait for 2 sec
      When I type "0 Anna demo quiz name" as quiz title
      And I add a question
      When I select "Textual" question type
      When I type "Question 1" into field "Q1"
      #When I select point per question as "5"
      #Then I change point per question to "7"
      And I wait for 3 sec
      And I click the button "Save"
      And I wait for 3 sec
      Then quiz "0 Anna demo quiz name" is displayed on the list of quizzes
      And I delete quiz "0 Anna demo quiz name"


