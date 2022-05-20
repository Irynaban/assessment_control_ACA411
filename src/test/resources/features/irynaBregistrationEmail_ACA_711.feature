# Test Set "Registration - Email" for ACA-711
  #Auhtor: Iryna Bannikova

@registrationEmail
  #ACA-114
  Feature: Test Set "Registration Email"

  Background:
      Given I go to "Registration" page

    @registrationEmail1
    Scenario: User can register with alphabetical email
      Then I type "Ira" in first name field and "Ban" in last name field
      Then I enter valid alphabetical email "irmabrowntest@gmail.com"
      Then enter group code "any"
      Then I enter password "12345"
      Then I retype password in Confirm password "12345"
      Then I press "Register Me" button
      And I get pop-up message "You have been Registered."
      And I wait for 2 sec

    @registrationEmail2
    Scenario: User can register with alphanumeric email
      Then Fill out field First "Ira" and Last name "Ban"
      Then I enter valid alphanumeric email "irmab51212@gmail.com"
      Then I Enter Group code "Any"
      Then I enter "12345" in password
      Then I retype "12345" password in confirm password field
      And click "Register Me" button
      And I get pop-up window "You have been Registered."
      And I wait for 2 sec

    @registrationEmail3
    Scenario: User can register using special characters in email
      When I fill out field First "Ira" and Last name "Ban"
      Then I Enter valid email with special characters "qa.irynab.@gmail.com"
      Then I type "Any" group code
      Then I type "12345" in field password
      And retype password "12345" in confirm password
      Then I click on button "Register Me"
      Then I get "You have been Registered." window
      And I wait for 2 sec

    @registrationEmail4
    Scenario: User can't register with empty email
      When I fill out field fields first "Ira" and last name "Ban"
      Then I type "123" group code field
      Then I type in the in password field "12345"
      And retype in the the password field"12345"
      Then I click on the button "Register Me"
      And I get error message under email field "This field is required"
      And I wait for 2 sec

    @registrationEmail5
    Scenario: User can't register using whitespace in email
      When I fill out field "Ira" in the field First Name and "Ban" in Last name
      Then I enter email using whitespace "irma  21@gmail.com"
      And I click on the next field
      And I get error message "Should be a valid email address"
      And I wait for 2 sec







