#Student Settings Password
  # https://jira.portnov.com/browse/ACA-153
  #Author: Olena Kravchenko
@quiz
Feature: Quiz
Background:
    Given I go to "login" page
    When I type "asse.lena@yahoo.com"
    And I type "12345" into "password" field
    And I click button "Sign In"
    And I wait for 2 sec
    When I click "Quizzes" menu item
    And I wait for 2 sec

  @quizCreatedAt1
#positive testing time and date check textual quiz ACA-178, ACA-182
  Scenario: Check Created At textual new quiz
    And I click button "Create New Quiz"
    And I wait for 2 sec
    When I type "Olena4" as quiz title
    And I add a question
    When I select "Textual" question type
    And I wait for 2 sec
    When I put in "Olena text 1" into field "question"
    And I wait for 2 sec
    Then I click button "Save"
    And I wait for 2 sec
    Then I click "Olena4" button
    And I wait for 2 sec
    And I check "Olena4" time

  @quizCreatedAt2
  #positive testing time and date check single choice quiz ACA-546, ACA-547
  Scenario: Check Created At Single Choice new quiz
    And I click button "Create New Quiz"
    And I wait for 2 sec
    When I type "Olena4" as quiz title
    And I add a question
    When I select "Single-Choice" question type
    And I wait for 2 sec
    When I create "Olena text 1" question
    And I wait for 2 sec
    Then I put in first "Option 1" into field "Option 1*"
    And I wait for 2 sec
    When I put in second "Option 2" into field "Option 2*"
    And I wait for 2 sec
    Then I click radio button to select correct answer
    And I wait for 2 sec
    And I wait for 2 sec
    Then I click button "Save"
    And I wait for 2 sec
    Then I click "Olena4" button
    And I wait for 2 sec
    And I check "Olena4" time

  @quizCreatedAt3
  #positive testing time and date check multiple choice quiz ACA-548, ACA-549
  Scenario: Check Created At Multiple Choice new quiz
    And I click button "Create New Quiz"
    And I wait for 2 sec
    When I type "Olena6" as quiz title
    And I add a question
    When I select "Multiple-Choice" question type
    And I wait for 2 sec
    When I create "Olena text 1" question
    And I wait for 2 sec
    Then I put in first "Option 1" into field "Option 1*"
    And I wait for 2 sec
    When I put in second "Option 2" into field "Option 2*"
    And I wait for 2 sec
    #Then I select "checkbox-1" as correct answer
    #Then I select "checkbox-2" as correct answer
    #And I wait for 2 sec
    #Then I click button "Save"
    #And I wait for 2 sec
    #Then I click "Olena6" button
    #And I wait for 2 sec
    #And I check "Olena6" time




