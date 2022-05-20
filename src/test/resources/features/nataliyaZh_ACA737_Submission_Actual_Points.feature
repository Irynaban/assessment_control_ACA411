@Actual_Points @regression
Feature: Submission - Actual points

  Background:
    Given I open the page "http://ask-internship.portnov.com"
    When I fill out the Email field "airrjw@rmune.com"
    Then I fill out the Password field "123456"
    And I click button "Sign In"
    And I wait for 2 sec

  @Actual_Points1
  Scenario: Actual Points Visible
    When  I click "Submissions" menu item
    And I wait for 5 sec
    Then I click "Grade" button on
    And I wait for 5 sec
    Then I see "Actual Points" on this page are visible
    And I wait for 5 sec
    Then I see percentage on this page is visible
    And I wait for 5 sec

  @Actual_Points2
  Scenario: Changing Actual Points
    When  I click "Submissions" menu item
    And I wait for 5 sec
    Then I click "Grade" button on
    And I wait for 5 sec
    When I click on "+" button under "Total Points" to increase the points
    And I wait for 5 sec

  @Actual_Points3
  Scenario: Save changed actual points
    When  I click "Submissions" menu item
    And I wait for 5 sec
    Then I click "Grade" button on
    And I wait for 5 sec
    When I click on "+" button under "Total Points" to increase the points
    And I wait for 5 sec
    Then I click the button "Save" to saving changes
    And I wait for 5 sec


