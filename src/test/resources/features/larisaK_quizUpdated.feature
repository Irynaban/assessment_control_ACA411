#Automation Test set for "Quiz - Updated At"
#Author: Larisa Kirichenko
#https://jira.portnov.com/browse/ACA-140

  @quizupdated @regression
  Feature: Automation Test set for "Quiz - Updated At"
    Background:
      Given I go to "Login" page
      When I type "larisak.sam@gmail.com" into email field
      And I type "Tester8*" into password field
      When I click the button "Sign In"
      And I wait for 2 sec

    @quizupdated1
    Scenario: Quiz can be updated
      When I click "Quizzes" menu item
      And I wait for 2 sec
      And I click on "Tester Test" quiz name
      And I click on the Edit button
      And I wait for 2 sec
      And I click on the "Save" button
      Then I check the "Updated at" time