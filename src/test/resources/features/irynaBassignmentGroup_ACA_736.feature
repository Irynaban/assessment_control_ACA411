# Test Set "Assignment - Group" for ACA-736
  #Auhtor: Iryna Bannikova
  
  @assignmentGroup
  #ACA-136
  Feature: Test Set "Assignment - Group"
    
    Background:
      Given I go to "Login" page
      Then enter valid "irmab5121test@gmail.com" and "123456" for teacher account
      And I wait for 2 sec
      And I click button "Sign In"
      Then I click on "Assignments" in the side bar
      And I wait for 5 sec
      Then I click "Create New Assignment"
      And I wait for 2 sec

    @assignmentGroup1
    Scenario: Teacher can assign quiz for all students using group code
      Then I click "Group Filter" on group filter
      Then I pick "ACA" group
      Then I click on the field "Select Quiz To Assign"
      Then I select "_Textual" quiz
      Then on the bottom click on "Select All"
      Then I click button "Give Assignment"
      And I wait for 2 sec

    @assignmentGroup2
    Scenario: Teacher can assign quiz for all groups
      Then I click "Group Filter" on group filter
      Then I pick "All" group
      Then I click on the field "Select Quiz To Assign"
      Then I select "_Textual" quiz
      Then on the bottom click on "Select All"
      Then I press on the button "Give Assignment"
      And I wait for 2 sec

    @assignmentGroup3
    Scenario:Teacher can assign students from different groups
      Then I click on the field "Select Quiz To Assign"
      Then I select "_Textual" quiz
      #Then I pick "name" student
      #Then I press on the button "Give Assignment"
      And I wait for 2 sec

    @assignmentGroup4
    Scenario: Teacher assign students and than click on button "Clear"
      Then I click on the field "Select Quiz To Assign"
      Then I select "_Textual" quiz
      Then I click button "Select All"
      Then I click button "Clear"
      Then I press on the button "Give Assignment"
      Then error message "Select at least one Student" is displayed
      And I wait for 3 sec

    @assignmentGroup5
    Scenario: Teacher assign students and than click on button "Cancel"
      Then I click on the field "Select Quiz To Assign"
      Then I select "_Textual" quiz
      Then I click button "Select All"
      Then I scroll ip and click on "Close"
      And I redirect to page "List of Assignments"
      And I wait for 3 sec
