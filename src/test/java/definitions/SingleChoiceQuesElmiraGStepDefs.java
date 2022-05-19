package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;


public class SingleChoiceQuesElmiraGStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String sURL) {
        if (sURL.equals("Login")) {
            getDriver().get("http://ask-internship.portnov.com/#/login");
        } else if (sURL.equals("Registration")) {
            getDriver().get("http://ask-internship.portnov.com/#/registration");
        } else {
            System.out.println("This site is not supported" + sURL);
        }
    }


    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String sEmail) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(sEmail);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String sPassword) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(sPassword);
    }

    @When("I click the button {string}")
    public void iClickTheButton(String sButton) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+sButton+"')]")).click();
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int iSec) throws InterruptedException {
        Thread.sleep(iSec*1000);
    }

    @When("I click {string} menu item")
    public void iClickMenuItem(String sMenuItem) {
        getDriver().findElement(By.xpath("//h5[text()='"+sMenuItem+"']")).click();
    }

    @When("I click button {string}")
    public void iClickButton(String btnName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+btnName+"')]")).click();
    }

    @When("I type {string} as quiz title")
    public void iTypeAsQuizTitle(String sTitle) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(sTitle);
    }

    @And("I add a quiz question")
    public void iAddAQuizQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @When("I click {string} question type")
    public void iClickQuestionType(String sQuestionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + sQuestionType + "')]")).click();
    }

    @When("I Type {string} into {string}")
    public void iTypeInto(String sQtext, String sQnumber) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + sQnumber + "')]/../../..//textarea[@formcontrolname='question']")).sendKeys(sQtext);
        Thread.sleep(2000);
    }

    @And("I type {string} as {string} into {string}")
    public void iTypeAsInto(String sOptionText, String sOptionNum, String sQnumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+sQnumber+"')]/../../..//textarea[@placeholder='"+sOptionNum+"']")).sendKeys(sOptionText);
    }


    @And("I click include other option")
    public void iClickIncludeOtherOption() {
        getDriver().findElement(By.xpath("//*[contains(text(), 'Other')]")).click();
    }

    @Then("I select {string} as a correct answer in {string}")
    public void iSelectAsACorrectAnswerIn(String sOptionNum, String sQnumber) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+sQnumber+"')]/../../..//textarea[@placeholder='"+sOptionNum+"']/../../../../../mat-radio-button")).click();
        Thread.sleep(1000);
    }

    @Then("quiz {string} is displayed on the list of the quizzes")
    public void quizIsDisplayedOnTheListOfTheQuizzes(String sTitle) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+sTitle+"')]")).isDisplayed()).isTrue();
    }

    @And("I open quiz {string}")
    public void iOpenQuiz(String sTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+sTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+sTitle+"')]/../../..//span[contains(text(),'Preview')]")).click();
    }

    @And("the option {string} should be displayed")
    public void theOptionShouldBeDisplayed(String sOption) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Other']"));
        assertThat(getDriver().findElement(By.xpath("//textarea[@placeholder='Other']")).isDisplayed()).isTrue();
    }

    @And("I check error message {string} should be displayed")
    public void iCheckErrorMessageShouldBeDisplayed(String sErrorMessage) {
        assertThat(getDriver().findElement(By.xpath("//mat-error[contains(text(),'"+sErrorMessage+"')]")).isDisplayed()).isTrue();
    }


    @And("I check error message {string} is displayed")
    public void iCheckErrorMessageIsDisplayed(String sErrorMessage) {
            assertThat(getDriver().findElement(By.xpath("//div[contains(text(),'"+sErrorMessage+"')]")).isDisplayed()).isTrue();
    }
}

