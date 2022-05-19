# Created by Said Khalidov  at 5/18/22
@change_students_name
Feature: User's management - Student - Change User's Name Test Cases
  Background: Opening the Settings page (#/settings) is required for every TC
    Given I open the staging environment main page
    And I login with default credentials
    And The user is signed in and redirected to the main page
    # TODO: unfortunately don't know how to replace this yet
    And I wait for 1 sec
    Then I select "Settings" on the sidebar

  #1	ACA-850 (https://jira.portnov.com/browse/ACA-850)
  @change_students_name_type_nothing_save
  Scenario: Click, try to save, typing nothing
    Given I click on "Change Your Name"
    Then Pop-up window is displayed with text: "Changing User's Name"
    Then I click on `Change`
    Then I wait for "Change Your Name" pop-up to close;
    And The name is not changed

  #2	ACA-851
  Scenario: Change name to correct one

  #3	ACA-852
  Scenario: Change name to an incorrent name
  #4	ACA-853
  Scenario: Change name to correct one, click cancel
  #5	ACA-854
  Scenario: Click, do nothing, click outside the popup window
  #6	ACA-855
  Scenario: Click, change name to 1 letter
  #7	ACA-856
  Scenario: Click, change name to less than 5 characters
  #8	ACA-857
  Scenario: Click, change name to 32 characters
  #9	ACA-858
  Scenario: Click, change name to 33 chars
  #10	ACA-859
  Scenario: Click, change to 100 chars
  #11	ACA-860
  Scenario: Click, delete everything, try to save