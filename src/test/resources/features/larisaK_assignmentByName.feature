#Automation Test set for "Assignment - Students by Name"
#Author: Larisa Kirichenko
#https://jira.portnov.com/browse/ACA-141

@assignbyname @regression
Feature: Automation Test set for "Assignment - Students by Name"
  Background:
    Given I go to "Login" page
    When I type "larisak.sam@gmail.com" into email field
    And I type "Tester8*" into password field
    When I click the button "Sign In"
    And I wait for 2 sec

  @assignbyname1
  Scenario: Assign Assignment to students by selecting their name
    When I click "Assignments" menu item
    And I wait for 5 sec
    And I click on the "Create New Assignment"
    And I click on Select Quiz To Assign field
    And I wait for 3 sec
    And I click on "Tester Test" quiz
    And I select "Abra Student" and "Petr Petrov" to assign quiz to
    And I wait for 5 sec
    And I click on Give Assignment button

  @assignbyname2
  Scenario: Assignment cannot be created if student(s) is/are not selected
    When I click "Assignments" menu item
    And I wait for 5 sec
    And I click on the "Create New Assignment"
    And I click on Select Quiz To Assign field
    And I wait for 3 sec
    And I click on "Tester Test" quiz
    And I click on Give Assignment button
    Then error message "Select at least one Student" should be displayed

  @assignbyname3
  Scenario: Redirects back to Assignments page when 'X' button is clicked
    When I click "Assignments" menu item
    And I wait for 5 sec
    And I click on the "Create New Assignment"
    Then I click on the X button in top right corner
    Then I should see element "List of Assignments" displayed
    
  @assignbyname4
  Scenario: Assignment cannot be created if a quiz is not selected/Quiz selection field is marked as required
    When I click "Assignments" menu item
    And I wait for 5 sec
    And I click on the "Create New Assignment"
    And I click on Give Assignment button
    Then an error message "This field is required" should be displayed