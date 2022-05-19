package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class NataliaG_textualQuestion_textStepDefs {
    @And("I type {string} into Title field")
    public void iTypeIntoTitleField(String title) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title);
    }

    @When("I type {string} into Question field")
    public void iTypeIntoQuestionField(String question) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(question);
    }

    @And("I click the icon Add Question")
    public void iClickTheIconAddQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @And("I click the radio button {string}")
    public void iClickTheRadioButtonTextual(String questionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + questionType + "')]")).click();
    }

    @Then("I wait for element {string} to be present")
    public void iWaitForElementWithXpathToBePresent(String elementText) {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'" + elementText + "')]")));
    }

    @Then("I wait for element {string} to not be present")
    public void iWaitForElementWithXpathToNotBePresent(String elementText) {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'" + elementText + "')]"))));
    }
}
