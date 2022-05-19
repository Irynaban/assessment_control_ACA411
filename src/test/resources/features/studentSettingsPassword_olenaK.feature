#Student Settings Password
  # https://jira.portnov.com/browse/ACA-153
  #Author: Olena Kravchenko

@studsettpassw
Feature: Student Settings Password

  Background:
    Given I go to "login"  student's page
    When I type "lenagoid@hotmail.com" student's email
    And I type "12345" into password field for student
    And I click "Sign In" button
    And I wait for 2 seconds
    When I click on "Settings" menu item
    And I wait for 2 seconds
    When I click on "Change Your Password"
    Then new window pop-up is displayed

  @studsettpassw1
  Scenario: Positive Testing
    #positive testing ACA-156, ACA-157,
    Then I type "12345" in "Password"
    Then I type "12345" in "New Password"
    Then I type "12345" in "Confirm New Password"
    Then I click to "Change" button
    Then "Settings" menu is displayed
    Then I click on "Log Out" menu item

  @studsettpassw2
  Scenario: Boundary positive testing max 32
    #positive boundary testing: ACA-162
    Then I type "12345" in "Password"
    Then I type "11111111111111111111111111111111" in "New Password"
    Then I type "11111111111111111111111111111111" in "Confirm New Password"
    And I wait for 3 seconds
    Then I click to "Change" button
    And I wait for 3 seconds
    Then "Settings" menu is displayed
    And I wait for 2 seconds
    When I click on "Change Your Password"
    And I wait for 2 seconds
    Then new window pop-up is displayed
    Then I type "11111111111111111111111111111111" in "Password"
    Then I type "12345" in "New Password"
    Then I type "12345" in "Confirm New Password"
    And I wait for 3 seconds
    Then I click to "Change" button
    And I wait for 3 seconds
    Then "Settings" menu is displayed
    And I wait for 2 seconds
    Then I click on "Log Out" menu item

  @studsettpassw3
  Scenario: Boundary positive testing min 5
    #positive boundary testing: ACA-163
    Then I type "12345" in "Password"
    Then I type "12345" in "New Password"
    Then I type "12345" in "Confirm New Password"
    Then I click to "Change" button
    Then "Settings" menu is displayed
    Then I click on "Log Out" menu item

  @studsettpassw4
  Scenario: Positive testing sensitive, alphanumeric and special characters
    #positive case sensitive, alphanumeric and special characters: ACA-158, ACA-159, ACA-160,ACA-161
    Then I type "12345" in "Password"
    Then I type "12345Abc!" in "New Password"
    Then I type "12345Abc!" in "Confirm New Password"
    Then I click to "Change" button
    Then "Settings" menu is displayed
    And I wait for 2 seconds
    When I click on "Change Your Password"
    And I wait for 2 seconds
    Then new window pop-up is displayed
    Then I type "12345Abc!" in "Password"
    Then I type "12345" in "New Password"
    Then I type "12345" in "Confirm New Password"
    And I wait for 3 seconds
    Then I click to "Change" button
    And I wait for 3 seconds
    Then "Settings" menu is displayed
    And I wait for 2 seconds
    Then I click on "Log Out" menu item

  @studsettpassw5
  Scenario: Positive testing "Cancel" button
    #positive "Cancel" button functions ACA-173
    Then I type "12345" in "Password"
    Then I type "12345" in "New Password"
    Then I type "12345" in "Confirm New Password"
    Then I click to "Cancel" button
    And I wait for 2 seconds
    Then "Settings" menu is displayed
    Then I click on "Log Out" menu item

  @studsettpassw6
  Scenario: Negative testing boundaries max 33


        #negative boundary testing: ACA-165
    Then I type "12345" in "Password"
    Then I type "111111111111111111111111111111111" in "New Password"
    Then I type "111111111111111111111111111111111" in "Confirm New Password"
    Then "Too long. Should be at least 5 to 32 characters" error is displayed in New Password
    Then "Too long. Should be at least 5 to 32 characters" error is displayed in Confirm New Password
    Then I click to "Change" button
    Then "Change" button is disabled
    And new window pop-up is displayed
    Then I click to "Cancel" button
    Then I click on "Log Out" menu item

  @studsettpassw7
  Scenario: Negative testing boundaries min
        #negative boundary testing: ACA-164
    Then I type "12345" in "Password"
    Then I type "1234" in "New Password"
    Then I type "1234" in "Confirm New Password"
    Then "Too short. Should be at least 5 to 32 characters" error is displayed in New Password
    Then "Too short. Should be at least 5 to 32 characters" error is displayed in Confirm New Password
    Then I click to "Change" button
    Then "Change" button is disabled
    And new window pop-up is displayed
    Then I click to "Cancel" button
    Then I click on "Log Out" menu item

  @studsettpassw8
  Scenario: Negative testing white space
        #negative whitespaces in passwords testing: ACA-166
    Then I type "12345" in "Password"
    Then I type " " in "New Password"
    Then I type " " in "Confirm New Password"
    Then "Whitespaces are not allowed" error is displayed in New Password
    Then "Whitespaces are not allowed" error is displayed in Confirm New Password
    Then I click to "Change" button
    And new window pop-up is displayed
    Then I click to "Cancel" button
    Then I click on "Log Out" menu item

  @studsettpassw9
  Scenario: Negative testing not same New Password and Confirm New Password
        #negative not same passwords  testing: ACA-167
    Then I type "12345" in "Password"
    Then I type "123456" in "New Password"
    Then I type "12345" in "Confirm New Password"
    Then I click to "Change" button
    Then "Entered passwords should match" error is displayed in Confirm New Password
    And new window pop-up is displayed
    Then I click to "Cancel" button
    Then I click on "Log Out" menu item

  @studsettpassw10
  Scenario: Negative testing several times not same New Password and Confirm New Password
        #negative several times not same passwords testing: ACA-168; bug ACA-110
    Then I type "12345" in "Password"
    Then I type "123456" in "New Password"
    Then I type "123456" in "Confirm New Password"
    Then I clear "New Password"
    Then I type "12345" in "New Password"
    Then I click to "Change" button
    Then "Entered passwords should match" error is displayed in Confirm New Password
    And new window pop-up is displayed
    Then I click to "Cancel" button
    Then I click on "Log Out" menu item

  @studsettpassw11
  Scenario: Negative testing leave passwords fields blank
        #negative testing: ACA-170, ACA-171, ACA-172
    Then I type "" in "Password"
    Then I type "" in "New Password"
    Then I type "" in "Confirm New Password"
    Then "This field is required" error is displayed in Password
    Then "This field is required" error is displayed in New Password
    Then "This field is required" error is displayed in Confirm New Password
    Then I click to "Change" button
    And new window pop-up is displayed
    Then I click to "Cancel" button
    Then I click on "Log Out" menu item

  @studsettpassw12
  Scenario: Negative testing leave passwords fields blank
        #negative testing: ACA-170, ACA-171, ACA-172
    Then I type "123456" in "Password"
    Then I type "12345" in "New Password"
    Then I type "12345" in "Confirm New Password"
    Then I click to "Change" button
    Then I wait for 2 seconds
    Then error message "Authentication failed. User not found or password does not match" menu is displayed
    Then I click on "Log Out" menu item



