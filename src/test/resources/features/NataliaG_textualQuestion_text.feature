# Automate test set "Textual Question - Text"
# Story https://jira.portnov.com/browse/ACA-720
# Author: Natalia Garkusha

@automate @regression
Feature: Textual Question - Text
  Background:
    Given I go to "Login" page
    When I type "zlamline@icloud.com" into email field
    And I type "12345" into password field
    And I click the button "Sign In"
    Then I wait for 5 sec
    When I click "Quizzes" menu item
    Then I wait for 5 sec
    When I click the button "Create New Quiz"
    Then I wait for 1 sec
    And I type "Debugging" into Title field
    And I click the icon Add Question
    And I click the radio button "Textual"
    Then I wait for 1 sec

  @automate1
  Scenario: Includes alphanumeric and special characters
    When I type "1. What_is@debugging_?" into Question field
    And I click the button "Save"
    Then I wait for element "List of Quizzes" to be present

  @automate2
  Scenario: No text in the question field
    Then I type "" into Question field
    And I click the button "Save"
    Then I wait for element "This field is required" to be present

  @automate3
  Scenario: 1 character in the question field
    Then I type "W" into Question field
    And I click the button "Save"
    Then I wait for element "List of Quizzes" to be present

  @automate4
  Scenario: 1000 characters in the question field
    Then I type "Debugging is the process of detecting and removing of existing and potential errors (also called as 'bugs') in a software code that can cause it to behave unexpectedly or crash. To prevent incorrect operation of a software or system, debugging is used to find and resolve bugs or defects. Here's the debugging process: 1. Reproduce the problem. 2. Describe the bug. Try to get as much input from the user to get the exact reason. 3. Capture the program snapshot when the bug appears. Try to get all the variable values and states of the program at that time. 4. Analyse the snapshot based on the state and action. Based on that try to find the cause of the bug. 5. Fix the existing bug, but also check that any new bug does not occur. To prevent incorrect operation of a software or system, debugging is used to find and resolve bugs or defects. Debugging is the process of detecting and removing of existing and potential errors in a software code that can cause it to behave unexpectedly or crash." into Question field
    And I click the button "Save"
    Then I wait for element "List of Quizzes" to be present

  @automate5
  Scenario: 1001 characters in the question field
    Then I type "Debugging is the process of detecting and removing of existing and potential errors (also called as 'bugs') in a software code that can cause it to behave unexpectedly or crash. To prevent incorrect operation of an software or system, debugging is used to find and resolve bugs or defects. Here's the debugging process: 1. Reproduce the problem. 2. Describe the bug. Try to get as much input from the user to get the exact reason. 3. Capture the program snapshot when the bug appears. Try to get all the variable values and states of the program at that time. 4. Analyse the snapshot based on the state and action. Based on that try to find the cause of the bug. 5. Fix the existing bug, but also check that any new bug does not occur. To prevent incorrect operation of a software or system, debugging is used to find and resolve bugs or defects. Debugging is the process of detecting and removing of existing and potential errors in a software code that can cause it to behave unexpectedly or crash." into Question field
    And I click the button "Save"
    Then I wait for element "List of Quizzes" to not be present
    And I wait for element "Too long textual question" to be present