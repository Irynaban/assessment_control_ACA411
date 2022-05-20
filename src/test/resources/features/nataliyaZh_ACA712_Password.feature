@Password/ConfirmPassword @regression
Feature: Password

  Background:
    Given I open the page "http://ask-internship.portnov.com"
    And I click a button "Register Now"
    Then I fill out fields First Name "Natali" and Last Name "Zh"
    Then I enter valid "ivgson@uioct.com" address into Email field
    Then I type Group code "ACA411"

  @Password/ConfirmPassword1
  Scenario: Alphabetical characters for password
    When I type alphabetical characters in Password field "abcde"
    Then I type alphabetical characters in Confirm Password field "abcde"
    And I click "Register Me" button
    Then I switch to next page "http://ask-internship.portnov.com/#/registration-confirmation|http://ask-internship.portnov.com/"
    And I wait for 5 sec

  @Password/ConfirmPassword2
  Scenario: Numeric characters in Password field
    When I type numeric characters in Password field "123456"
    Then I type numeric characters in Confirm Password field "123456"
    And I click "Register Me" button
    Then I switch to next page "http://ask-internship.portnov.com/#/registration-confirmation|http://ask-internship.portnov.com/"
    And I wait for 5 sec

  @Password/ConfirmPassword3
  Scenario: Alphanumeric characters for password
    When I type alphanumeric characters in Password field "123abc"
    Then I type alphanumeric characters in Confirm Password field "123abc"
    And I click "Register Me" button
    Then I switch to next page "http://ask-internship.portnov.com/#/registration-confirmation|http://ask-internship.portnov.com/"
    And I wait for 5 sec

  @Password/ConfirmPassword4
  Scenario: Special characters for password
    When I type special characters in Password field "!%*()#"
    Then I type special characters in Confirm Password field "!%*()#"
    And I click "Register Me" button
    Then I switch to next page "http://ask-internship.portnov.com/#/registration-confirmation|http://ask-internship.portnov.com/"
    And I wait for 5 sec

  @Password/ConfirmPassword5
  Scenario: Matching Password with Confirm Password fields
    When I type in Password field any characters "123456"
    Then I type in Confirm Password field different password "12345"
    And I get error message under Confirm field "Entered passwords should match"

  @Password/ConfirmPassword6
  Scenario: Empty password field
    When I type in Confirm Password field any characters "123456"
    And I click "Register Me" button
    Then I get Error message in Password "This field is required"

  @Password/ConfirmPassword7
  Scenario: Empty Confirm Password field
    When I type in Password field any characters "123456"
    And I click "Register Me" button
    Then I get Error message in Confirm Password "This field is required"

  @Password/ConfirmPassword8
  Scenario: Password field password with space
    When I type in Password field any characters "123456"
    Then I type in Confirm Password characters with whitespace "1 1 1"
    And I click "Register Me" button
    Then I get error message under Confirm Password field "Whitespaces are not allowed"

  @Password/ConfirmPassword9
  Scenario: Password field less than 5 characters
    When I type in Password field any characters "123456"
    Then I type in Confirm Password less then five characters "1234"
    And I click "Register Me" button
    Then I get error message under Confirm Password field "Too short. Should be at least 5 to 32 characters"

  @Password/ConfirmPassword10
  Scenario: Maximum 32 characters in Password field
    When I type in Password field any characters "123456"
    Then I type in Confirm Password less then five characters "111111111111111111111111111111111"
    And I click "Register Me" button
    Then I get error message under Confirm Password field "Too long. Should be at least 5 to 32 characters"

  @Password/ConfirmPassword11
  Scenario: Hidden "Password" and "Confirm Password"















