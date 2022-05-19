# Automate test set "Home Page - Links"
# Story https://jira.portnov.com/browse/ACA-745
# Author: Natalia Garkusha

@homePage
Feature: Home Page - Links
  Background:
    Given I go to "Login" page

  # Student account
  @homePage1
  Scenario: Verifying My Assignments link
    When I type "student@nataliag.com" into email field
    And I type "12345" into password field
    And I click the button "Sign In"
    Then I wait for 3 sec
    When I click the button "Go To My Assignments"
    Then page header "My Assignments" should be present
    And current URL is "http://ask-internship.portnov.com/#/my-assignments"

  @homePage2
  Scenario: Verifying My Grades link
    When I type "student@nataliag.com" into email field
    And I type "12345" into password field
    And I click the button "Sign In"
    Then I wait for 3 sec
    When I click the button "Go To My Grades"
    Then page header "My Grades" should be present
    And current URL is "http://ask-internship.portnov.com/#/my-grades"

  # Teacher account
  @homePage3
  Scenario: Verifying Submissions link
    When I type "zlamline@icloud.com" into email field
    And I type "12345" into password field
    And I click the button "Sign In"
    Then I wait for 3 sec
    When I click the button "Go To Submissions"
    Then page header "Submissions" should be present
    And current URL is "http://ask-internship.portnov.com/#/submissions/0"

  @homePage4
  Scenario: Verifying Assignments link
    When I type "zlamline@icloud.com" into email field
    And I type "12345" into password field
    And I click the button "Sign In"
    Then I wait for 3 sec
    When I click the button "Go To Assignments"
    Then page header "List of Assignments" should be present
    And current URL is "http://ask-internship.portnov.com/#/assignments"

  @homePage5
  Scenario: Verifying Users Management link
    When I type "zlamline@icloud.com" into email field
    And I type "12345" into password field
    And I click the button "Sign In"
    Then I wait for 3 sec
    When I click the button "Go To Users Management"
    Then page header "Management" should be present
    And current URL is "http://ask-internship.portnov.com/#/users-management"