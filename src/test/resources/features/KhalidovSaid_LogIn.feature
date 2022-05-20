# Created by Said Khalidov  at 4/20/22
@login
Feature: Login and Signup test cases
  Background:
    Given I open the staging environment main page

  @login_happy_path
  Scenario: Testing logging in with correct credentials
    Given I fill out the login form with default credentials
    Then The user is signed in and redirected to the main page

  @login_correct_email_wrong_pwd
  Scenario: Correct email, wrong password
    Given I fill out the login form with "pcs.internshipks@gmail.com" email and "Wrong12345" password
    And I click on Sign In
    Then "Authentication failed. User not found or password does not match " is displayed at the bottom

  @login_correct_email_no_pwd
  Scenario: Correct email, no password
    Given I fill out the login form with "pcs.internshipks@gmail.com" email
    And I click on Sign In
    Then Password field has "This field is required" next to it

  @login_correct_email_diff_pwd
  Scenario: Correct email, password from another account
    Given I fill out the login form with "pcs.internshipks@gmail.com" email and "DifferentPwd123" password
    And I click on Sign In
    Then "Authentication failed. User not found or password does not match " is displayed at the bottom

  @login_no_email_no_pwd
  Scenario: No email, no password
    And I click on Sign In
    Then Email and password fields have "This field is required" next to them

  @login_click_forgot
  Scenario: Click on 'I forgot my password'
    Given I click on I forgot my password
    Then I should be redirected to the "forgot password" page