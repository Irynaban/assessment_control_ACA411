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
  @change_students_name_type_nothing_save_850
  Scenario: Click, try to save, typing nothing
    Given I click on "Change Your Name"
    Then Pop-up window is displayed with text: "Changing User's Name"
    Then I click on `Change`
    Then I wait for "Change Your Name" pop-up to close;
    And The name is not changed

  #2	ACA-851 (https://jira.portnov.com/browse/ACA-851)
  @change_students_name_correct_name_851
  Scenario: Change name to correct one
    Given I click on "Change Your Name"
    Then Pop-up window is displayed with text: "Changing User's Name"
    Then I type a new name in the name field as "DifferentName"
    Then I click on `Change`
    Then I wait for "Change Your Name" pop-up to close;
    And The name has been changed to "DifferentName"

  #3	ACA-852 (https://jira.portnov.com/browse/ACA-852)
  @change_students_name_incorrect_name_852
  Scenario: Change name to an incorrect name
    Given I click on "Change Your Name"
    Then Pop-up window is displayed with text: "Changing User's Name"
    Then I type a new name in the name field as "DifferentName%%%%%"
    # this is needed to update the form's state, as the error message is not displayed if the name field is in focus
    And I click elsewhere on the `Change Your Name` modal
    Then 'Should contain only latin characters, space or numbers' is displayed
    And  'Change' button is disabled

  #4	ACA-853 (https://jira.portnov.com/browse/ACA-853)
  @change_students_name_correct_name_then_cancel_853
  Scenario: Change name to correct one, click cancel
    Given I click on "Change Your Name"
    Then Pop-up window is displayed with text: "Changing User's Name"
    Then I type a new name in the name field as "ACA853"
    And I click on Cancel
    Then I wait for "Change Your Name" pop-up to close;
    And The name is not changed

  #5	ACA-854 (https://jira.portnov.com/browse/ACA-854)
  @change_students_name_correct_name_click_outside_854
  Scenario: Click, do nothing, click outside the popup window
    Given I click on "Change Your Name"
    Then Pop-up window is displayed with text: "Changing User's Name"
    Then I click outside the popup window
    And The name is not changed

#  These are deprecated: 1.0.11 update changes the requirements
#  #6	ACA-855
#  Scenario: Click, change name to 1 letter
#  #7	ACA-856
#  Scenario: Click, change name to less than 5 characters
#  #8	ACA-857
#  Scenario: Click, change name to 32 characters
#  #9	ACA-858
#  Scenario: Click, change name to 33 chars
#  #10	ACA-859
#  Scenario: Click, change to 100 chars

#  #11	ACA-860
  Scenario: Click, delete everything, try to save
    Given I click on "Change Your Name"
    And Pop-up window is displayed with text: "Changing User's Name"
    And I clear the name field
    And I click elsewhere on the `Change Your Name` modal
    Then `This field is required` is displayed
    And  'Change' button is disabled