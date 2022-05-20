package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class Nataliya_Zh_ACA712StepDefs {
    @Given("I open the page {string}")
    public void iOpenThePage(String sURL) {
        getDriver().get(sURL);
    }

    @And("I click a button {string}")
    public void iClickAButton(String sButton) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + sButton + "')]")).click();
    }

    @Then("I fill out fields First Name {string} and Last Name {string}")
    public void iFillOutFieldsFirstNameAndLastName(String sFirstName, String sLastName) {
        getDriver().findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(sFirstName);
        getDriver().findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(sLastName);
    }

    @Then("I enter valid {string} address into Email field")
    public void iEnterValidAddressIntoEmailField(String sEmail) {
        getDriver().findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(sEmail);
    }

    @Then("I type Group code {string}")
    public void iTypeGroupCode(String sGroupCode) {
        getDriver().findElement(By.xpath("//input[@placeholder='Group Code']")).sendKeys(sGroupCode);
    }

    @When("I type alphabetical characters in Password field {string}")
    public void iTypeAlphabeticalCharactersInPasswordField(String sPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sPassword);
    }

    @Then("I type alphabetical characters in Confirm Password field {string}")
    public void iTypeAlphabeticalCharactersInConfirmPasswordField(String sConfirmPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(sConfirmPassword);
    }

    @And("I click {string} button")
    public void iClickButton(String sRegisterMe) {
        getDriver().findElement(By.xpath("//span[contains(text(),'" + sRegisterMe + "')]")).click();
    }

    @Then("I switch to next page {string}")
    public void iSwitchToNextPage(String sRedirectedUrl) {
        getDriver().get(sRedirectedUrl);
    }

    @When("I type numeric characters in Password field {string}")
    public void iTypeNumericCharactersInPasswordField(String sPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sPassword);
    }

    @Then("I type numeric characters in Confirm Password field {string}")
    public void iTypeNumericCharactersInConfirmPasswordField(String sConfirmPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(sConfirmPassword);
    }

    @When("I type alphanumeric characters in Password field {string}")
    public void iTypeAlphanumericCharactersInPasswordField(String sPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sPassword);
    }
    {   @Then("I type alphanumeric characters in Confirm Password field {string}")
    public void iTypeAlphanumericCharactersInConfirmPasswordField(String sConfirmPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(sConfirmPassword);
    }
        {
    @When("I type special characters in Password field {string}")
    public void iTypeSpecialCharactersInPasswordField(String sPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sPassword);
    }

    @Then("I type special characters in Confirm Password field {string}")
    public void iTypeSpecialCharactersInConfirmPasswordField(String sConfirmPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(sConfirmPassword);
    }

    @When("I type in Password field any characters {string}")
    public void iTypeInPasswordFieldAnyCharacters(String sPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sPassword);
    }

    @Then("I type in Confirm Password field different password {string}")
    public void iTypeInConfirmPasswordFieldDifferentPassword(String sConfirmPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(sConfirmPassword);
    }

    @And("I get error message under Confirm field {string}")
    public void iGetErrorMessageUnderConfirmField(String sMatchPassword) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Entered passwords should match')]")).isDisplayed();
    }

    @When("I type in Confirm Password field any characters {string}")
    public void iTypeInConfirmPasswordFieldAnyCharacters(String sConfirmPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(sConfirmPassword);
    }

    @Then("I get Error message in Password {string}")
    public void iGetErrorMessageInPassword(String sErrorMessage) {
        getDriver().findElement(By.xpath("//*[text()='" + sErrorMessage + "']")).isDisplayed();
    }

    @Then("I get Error message in Confirm Password {string}")
    public void iGetErrorMessageInConfirmPassword(String sConfirmPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(sConfirmPassword);
    }

    @Then("I type in Confirm Password characters with whitespace {string}")
    public void iTypeInConfirmPasswordCharactersWithWhitespace(String sPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sPassword);
    }

    @Then("I get error message under Confirm Password field {string}")
    public void iGetErrorMessageUnderConfirmPasswordField(String sWhiteSpace) {
        getDriver().findElement(By.xpath("//*[text()='"+sWhiteSpace+"']")).isDisplayed();
    }

    @Then("I type in Confirm Password less then five characters {string}")
    public void iTypeInConfirmPasswordLessThenFiveCharacters(String sConfirmPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(sConfirmPassword);
    }
}













