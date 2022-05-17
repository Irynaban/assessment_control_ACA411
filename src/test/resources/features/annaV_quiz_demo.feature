@quiz
  Feature: Quiz

    @quiz1
    Scenario: Create a Quiz
      Given I go to "Login" page
      When I type "annaverpcs.ask@gmail.com" into email field
      And I type "12345" into password field
      When I click the button "Sign In"
      And I wait for 2 sec
      When I click "Quizzes" menu item
      And I wait for 10 sec
      When I click "Home" menu item
      And I wait for 3 sec
      When I click "Submissions" menu item
      And I wait for 10 sec
