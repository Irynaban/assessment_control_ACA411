package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

     //Test Set "Registration - Email" for ACA-711
public class irynaBtestSetsStepDefs {
    @Given("I open {string}")
    public void iGoToPage(String sURL) {
        if (sURL.equals("Login")) {
            getDriver().get("http://ask-internship.portnov.com/#/login");
        } else if (sURL.equals("Registration")) {
            getDriver().get("http://ask-internship.portnov.com/#/registration");
        } else {
            System.out.println("This site is not supported" + sURL);
        }
    }

    @Then("I type {string} in first name field and {string} in last name field")
    public void iTypeInFirstNameFieldAndInLastNameField(String sFirstName, String sLastName) {
        getDriver().findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(sFirstName);
        getDriver().findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(sLastName);
    }

    @Then("I enter valid alphabetical email {string}")
    public void iEnterValidAlphabeticalEmail(String sEmail) {
        getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(sEmail);
    }

    @Then("enter group code {string}")
    public void enterGroupCode(String sGroupCode) {
        getDriver().findElement(By.xpath("//input[@placeholder='Group Code']")).sendKeys(sGroupCode);
    }

    @Then("I enter password {string}")
    public void iEnterPassword(String sPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sPassword);
    }

    @Then("I retype password in Confirm password {string}")
    public void iRetypePasswordInConfirmPassword(String sConfirmPasssword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(sConfirmPasssword);
    }

    @Then("I press {string} button")
    public void iPressButton(String sButton) {
        getDriver().findElement(By.xpath("//span[text()='" + sButton + "']")).click();
    }

    @And("I get pop-up message {string}")
    public void iGetPopUpMessage(String sRegistered) {
        getDriver().getWindowHandle();
    }

    @Then("Fill out field First {string} and Last name {string}")
    public void fillOutFieldFirstAndLastName(String sFirstName, String sLastName) {
        getDriver().findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(sFirstName);
        getDriver().findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(sLastName);
    }

    @Then("I enter valid alphanumeric email {string}")
    public void iEnterValidAlphanumericEmail(String sEmail) {
        getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(sEmail);
    }

    @Then("I Enter Group code {string}")
    public void iEnterGroupCode(String sGroupCode) {
        getDriver().findElement(By.xpath("//input[@placeholder='Group Code']")).sendKeys(sGroupCode);
    }

    @Then("I enter {string} in password")
    public void iEnterInPassword(String sPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sPassword);

    }

    @Then("I retype {string} password in confirm password field")
    public void iRetypePasswordInConfirmPasswordField(String sConfirmPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(sConfirmPassword);
    }

    @And("click {string} button")
    public void clickButton(String sButton) {
        getDriver().findElement(By.xpath("//span[text()='" + sButton + "']")).click();
    }

    @And("I get pop-up window {string}")
    public void iGetPopUpWindow(String sRegistered) {
        getDriver().getWindowHandle();
    }

    @When("I fill out field First {string} and Last name {string}")
    public void iFillOutFieldFirstAndLastName(String sFirstName, String sLastName) {
        getDriver().findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(sFirstName);
        getDriver().findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(sLastName);
    }

    @Then("I Enter valid email with special characters {string}")
    public void iEnterValidEmailWithSpecialCharacters(String sEmail) {
        getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(sEmail);
    }

    @Then("I type {string} group code")
    public void iTypeGroupCode(String sGroupCode) {
        getDriver().findElement(By.xpath("//input[@placeholder='Group Code']")).sendKeys(sGroupCode);
    }

    @Then("I type {string} in field password")
    public void iTypeInFieldPassword(String sPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sPassword);
    }

    @And("retype password {string} in confirm password")
    public void retypePasswordInConfirmPassword(String sConfirmPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(sConfirmPassword);
    }

    @Then("I click on button {string}")
    public void iClickOnButton(String sButton) {
        getDriver().findElement(By.xpath("//span[text()='" + sButton + "']")).click();
    }

    @Then("I get {string} window")
    public void iGetWindow(String sRegistered) {
        getDriver().getWindowHandle();
    }

    @When("I fill out field fields first {string} and last name {string}")
    public void iFillOutFieldFieldsFirstAndLastName(String sFirstName, String sLastName) {
        getDriver().findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(sFirstName);
        getDriver().findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(sLastName);
    }

    @Then("I type {string} group code field")
    public void iTypeGroupCodeField(String sGroupCode) {
        getDriver().findElement(By.xpath("//input[@placeholder='Group Code']")).sendKeys(sGroupCode);
    }

    @Then("I type in the in password field {string}")
    public void iTypeInTheInPasswordField(String sPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sPassword);
    }

    @And("retype in the the password field{string}")
    public void retypeInTheThePasswordField(String sConfirmPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(sConfirmPassword);
    }

    @Then("I click on the button {string}")
    public void iClickOnTheButton(String sButton) {
        getDriver().findElement(By.xpath("//span[text()='" + sButton + "']")).click();
    }

    @And("I get error message under email field {string}")
    public void iGetErrorMessageUnderEmailField(String sErrorMessage) {
        getDriver().findElement(By.xpath("//mat-error[text()='" + sErrorMessage + "']")).isDisplayed();
    }

    @When("I fill out field {string} in the field First Name and {string} in Last name")
    public void iFillOutFieldInTheFieldFirstNameAndInLastName(String sFirstName, String sLastName) {
        getDriver().findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys(sFirstName);
        getDriver().findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys(sLastName);
    }

    @Then("I enter email using whitespace {string}")
    public void iEnterEmailUsingWhitespace(String sEmail) {
        getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(sEmail);
    }

    @And("I click on the next field")
    public void iClickOnTheNextField() {
        getDriver().findElement(By.xpath("//input[@placeholder='Group Code']")).click();
    }

    @And("I get error message {string}")
    public void iGetErrorMessage(String sErrorMessage) {
        getDriver().findElement(By.xpath("//mat-error[text()='" + sErrorMessage + "']")).isDisplayed();
    }

         //Test Set "Assignment - Group" for ACA-736
    @Then("enter valid {string} and {string} for teacher account")
    public void enterValidAndForTeacherAccount(String sEmail, String sPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(sEmail);
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(sPassword);
    }

    @And("I click button {string}")
    public void iClickButton(String sButton) {
        getDriver().findElement(By.xpath("//span[text()='" + sButton + "']")).click();
    }

    @Then("I click on {string} in the side bar")
    public void iClickOnInTheSideBar(String sAssignments) {
        getDriver().findElement(By.xpath("//h5[text()='Assignments']")).click();
    }

    @Then("I click {string}")
    public void iClick(String sCreateNewAss) {
        getDriver().findElement(By.xpath("//span[contains(text(),'New Assignment')]")).click();
    }


    @Then("I click {string} on group filter")
    public void iClickOnGroupFilter(String sGroupFilter) {
        getDriver().findElement(By.xpath("//*[@placeholder='Group Filter']")).click();
    }

    @Then("I pick {string} group")
    public void iPickGroup(String sGroup) {
        getDriver().findElement(By.xpath("//mat-option[@role='option']/span[text()='" + sGroup + "']")).click();
    }

    @When("I click on the field {string}")
    public void iClickOnTheField(String sSelectQuiz) {
        getDriver().findElement(By.xpath("//mat-select[@ formcontrolname='quizId']")).click();
    }

    @Then("I select {string} quiz")
    public void iSelectQuiz(String sQuiz) {
        getDriver().findElement(By.xpath("//span[contains(text(), '" + sQuiz + "')]")).click();
    }

    @Then("on the bottom click on {string}")
    public void onTheBottomClickOn(String sButton) {
        getDriver().findElement(By.xpath("//span[text()='" + sButton + "']")).click();
    }

    @Then("I press on the button {string}")
    public void iPressOnTheButton(String sButton) {
        getDriver().findElement(By.xpath("//span[text()='" + sButton + "']")).click();
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String sErrorMessage) {
        getDriver().findElement(By.xpath("//*[contains(text(), ' at least one Student')]"));
    }

    @Then("I scroll ip and click on {string}")
    public void iScrollIpAndClickOn(String sClose) {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'close')]")).click();
    }


    @And("I redirect to page {string}")
    public void iRedirectToPage(String sListOfAssignments) {
        getDriver().findElement(By.xpath("//h4[contains(text(),'List of Assignments')]")).isDisplayed();
    }
}











