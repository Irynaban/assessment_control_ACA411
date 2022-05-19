#Epic: https://jira.portnov.com/browse/ACA-725/750
#Author: Dmytro Vereshchak
@ACA
Feature: Single Choice Question - Options(ACA-725)/Grading - Quiz with Textual Showstopper question(ACA-750)
  Background:
    Given I go to "Login" page
    Then I type "dima.vereschak@gmail.com" into Email field
    Then I type "12345" into Password field
    Then I click "Sign In" button
    Then I wait 2 seconds
    And I should see page title as "Assessment Control @ Portnov"
    And I wait 3 seconds

  @ACA-212
    #Precondition: User must have registered account with "Teacher's" role
  Scenario: User can create a quiz with valid data
    Then I click "Quizzes" menu item
    And I wait 3 seconds
    Then "List of Quizzes" should be displayed
    Then I click "Create New Quiz" button
    And I wait 3 seconds
    Then I type "_Internship Quiz" into Title of Quiz field
    Then I click Add Question button
    Then I select "Single-Choice" question type
    Then I type "1+1 = " into "question" field
    Then I type "2" into Option 1 field
    Then I type "3" into Option 2 field
    Then I select "Correct answer" from answers
    And I click "Save" button

  @ACA-228
    #Precondition: User must have registered account with "Teacher's" role
  Scenario: Verify that max 15 options per question can be added
    Then I click "Quizzes" menu item
    And I wait 3 seconds
    Then "List of Quizzes" should be displayed
    Then I click "Create New Quiz" button
    And I wait 3 seconds
    Then I type "_Internship Quiz" into Title of Quiz field
    Then I click Add Question button
    Then I select "Single-Choice" question type
    Then I type "1+1 = " into "question" field
    Then I click "Add Option" button
    Then I click "Add Option" button
    Then I click "Add Option" button
    Then I click "Add Option" button
    Then I click "Add Option" button
    Then I click "Add Option" button
    Then I click "Add Option" button
    Then I click "Add Option" button
    Then I click "Add Option" button
    Then I click "Add Option" button
    Then I click "Add Option" button
    Then I click "Add Option" button
    Then I click "Add Option" button
    Then I click "Add Option" button
    Then I wait 2 seconds

  @ACA-445
    #Precondition: User must have registered account with "Teacher's" role
  Scenario: User can't save the question, if Option field is blank
    Then I click "Quizzes" menu item
    And I wait 3 seconds
    Then "List of Quizzes" should be displayed
    Then I click "Create New Quiz" button
    And I wait 3 seconds
    Then I type "_Internship Quiz" into Title of Quiz field
    Then I click Add Question button
    Then I select "Single-Choice" question type
    Then I type "1+1 = " into "question" field
    Then I select "Correct answer" from answers
    And I click "Save" button
    Then I should see "This field is required" error message

  @ACA-463
    #Precondition: User must have registered account with "Teacher's" role
  Scenario: User can click checkboxes and the check will be added to them
    Then I click "Quizzes" menu item
    And I wait 3 seconds
    Then "List of Quizzes" should be displayed
    Then I click "Create New Quiz" button
    And I wait 3 seconds
    Then I type "_Internship Quiz" into Title of Quiz field
    Then I click Add Question button
    Then I select "Single-Choice" question type
    Then I type "1+1 = " into "question" field
    Then I type "2" into Option 1 field
    Then I type "3" into Option 2 field
    Then I select "Correct answer" from answers
    Then I mark "Include "Other" text area option for this question?" checkbox
    Then I mark "Is "Show-Stopper" question?" checkbox
    Then I wait 3 seconds

  @ACA-464
    #Precondition: User must have registered account with "Teacher's" role
  Scenario: Question can't be saved, if the Option (answer) is not selected
    Then I click "Quizzes" menu item
    And I wait 3 seconds
    Then "List of Quizzes" should be displayed
    Then I click "Create New Quiz" button
    And I wait 3 seconds
    Then I type "_Internship Quiz" into Title of Quiz field
    Then I click Add Question button
    Then I select "Single-Choice" question type
    Then I type "1+1 = " into "question" field
    Then I type "2" into Option 1 field
    Then I type "3" into Option 2 field
    And I click "Save" button
    Then "*Choose correct answer" error message should be displayed

  @ACA-465
    #Precondition: User must have registered account with "Teacher's" role
  Scenario: "Other" text area and "Show-Stopper" options added to question
    Then I click "Quizzes" menu item
    And I wait 3 seconds
    Then "List of Quizzes" should be displayed
    Then I click "Create New Quiz" button
    And I wait 3 seconds
    Then I type "_Internship Quiz" into Title of Quiz field
    Then I click Add Question button
    Then I select "Single-Choice" question type
    Then I type "1+1 = " into "question" field
    Then I type "2" into Option 1 field
    Then I type "3" into Option 2 field
    Then I select "Correct answer" from answers
    Then I mark "Include "Other" text area option for this question?" checkbox
    Then I mark "Is "Show-Stopper" question?" checkbox
    And I click "Save" button
    Then I wait 3 seconds
    Then "List of Quizzes" should be displayed
    Then I select "_Internship Quiz" from List of Quizzes
    And I wait 4 seconds
    Then I click on "Preview" button
    And I wait 5 seconds

  @ACA-475
#  Precondition:
#  User must have Teacher account.
#  Quiz with Textual Showstopper question only must be created by Teacher and assigned to Student.
#  Student must complete the assigned Quiz
  Scenario: Teacher can grade submitted Quiz with Textual Showstopper question only
    Then I click on "Submissions" menu item
    Then I wait 4 seconds
    Then "Submissions" should be displayed
    And I wait 10 seconds
    Then I click on "Grade" button of submitted quiz
    And I wait 5 seconds
    Then window with submitted quiz info should appear
    Then I click on "+" button and grade submitted Quiz
    Then I click on "+" button and grade submitted Quiz
    Then I click on "+" button and grade submitted Quiz
    Then I click on "+" button and grade submitted Quiz
    Then I click on "+" button and grade submitted Quiz
    And I click "Save" button to save graded quiz

  @ACA-522
#  Precondition:
#  User must have Teacher account.
#  Quiz with Textual Showstopper question must be created by Teacher and assigned to Student.
#  Student must complete the assigned Quiz.
  Scenario: Teacher can grade submitted Quiz including Textual Showstopper question
    Then I click on "Submissions" menu item
    Then I wait 4 seconds
    Then "Submissions" should be displayed
    And I wait 5 seconds
    Then I click on "Grade" button of submitted quiz
    And I wait 3 seconds
    Then window with submitted quiz info should appear
    Then I click on "+" button to grade textual question
    Then I click on "+" button to grade textual question
    And I click "Save" button to save graded quiz

  @ACA-530
#  Precondition:
#  User must have Teacher account.
#  Quiz with Textual Showstopper question must be created by Teacher and assigned to Student.
#  Student must complete the assigned Quiz.
  Scenario: Teacher can grade submitted Quiz with Textual Showstopper question and add summary, comment
    Then I click on "Submissions" menu item
    Then I wait 4 seconds
    Then "Submissions" should be displayed
    And I wait 10 seconds
    Then I click on "Grade" button of submitted quiz
    And I wait 5 seconds
    Then window with submitted quiz info should appear
    Then I click on "+" button and grade submitted Quiz
    Then I click on "+" button and grade submitted Quiz
    Then I click on "+" button and grade submitted Quiz
    Then I click on "+" button and grade submitted Quiz
    Then I click on "+" button and grade submitted Quiz
    Then I write "Good" into Teacher Comment field
    Then I write "100%" into Teacher Summary field
    And I click "Save" button to save graded quiz

  @ACA-536
#  Precondition:
#  User must have Teacher account.
#  Quiz with Textual Showstopper question must be created by Teacher and assigned to Student.
#  Student must complete the assigned Quiz.
  Scenario: Teacher can change assessment status during the process of grading Quiz with Textual Showstopper question
    Then I click on "Submissions" menu item
    Then I wait 4 seconds
    Then "Submissions" should be displayed
    And I wait 10 seconds
    Then I click on "Grade" button of submitted quiz
    And I wait 5 seconds
    Then window with submitted quiz info should appear
    Then I wait 3 seconds
    And "ASSESSMENT FAILED" status should be displayed
    Then I click on "+" button and grade submitted Quiz
    Then I click on "+" button and grade submitted Quiz
    Then I click on "+" button and grade submitted Quiz
    Then I click on "+" button and grade submitted Quiz
    Then I click on "+" button and grade submitted Quiz
    And "ASSESSMENT PASSED" status should be displayed
    Then I wait 5 seconds

  @ACA-538
#  Precondition:
#  Background for Teacher account should be commented
#  User must have Student account.
#  Quiz with Textual Showstopper question must be created by Teacher and assigned to Student.
#  Student must complete the assigned Quiz.
  Scenario: If Quiz has textual question with Showstopper, auto-grade system grades: Pending Review
    Given I go to "Login" page
    Then I type "d.imavereschak@gmail.com" into Email field
    Then I type "12345" into Password field
    Then I click "Sign In" button
    Then I wait 2 seconds
    And I should see page title as "Assessment Control @ Portnov"
    And I wait 3 seconds
    Then I click on "Grades" menu item for Student
    And submitted quiz is in pending status









