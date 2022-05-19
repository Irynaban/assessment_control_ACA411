package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Dmytro_V_ACA_725_750_Stepdefs {
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

    @Then("I type {string} into Email field")
    public void iTypeIntoEmailField(String sEmail) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(sEmail);
    }

    @Then("I type {string} into Password field")
    public void iTypeIntoPasswordField(String sPassword) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(sPassword);
    }

    @Then("I click {string} button")
    public void iClickButton(String sButton) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+sButton+"')]")).click();
    }

    @Then("I wait {int} seconds")
    public void iWaitSeconds(int iSec) throws InterruptedException {
    Thread.sleep(iSec*1000);
    }

    @And("I should see page title as {string}")
    public void iShouldSeePageTitleAs(String sTitle) {
        assertThat(getDriver().getTitle()).contains(sTitle);
    }

    @Then("I click {string} menu item")
    public void iClickMenuItem(String sMenuItem) {
        getDriver().findElement(By.xpath("//*[@class='mat-primary mat-list-item ng-star-inserted']//h5[contains(text(),'Quizzes')]")).click();
    }

    @Then("{string} should be displayed")
    public void shouldBeDisplayed(String sList) {
        assertThat(getDriver().findElement(By.xpath("//h4[contains(text(),sList)]")).isDisplayed()).isTrue();
    }

    @Then("I type {string} into Title of Quiz field")
    public void iTypeIntoTitleOfQuizField(String iQuizName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(iQuizName);
    }

    @Then("I click Add Question button")
    public void iClickAddQuestionButton() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("I select {string} question type")
    public void iSelectQuestionType(String sQuestionType) {
        getDriver().findElement(By.xpath("//*[contains(text(), '"+ sQuestionType + "')]")).click();
    }

    @Then("I type {string} into {string} field")
    public void iTypeIntoQuestionField(String sQuestionText, String sQuestionField) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='"+sQuestionField+"']")).sendKeys(sQuestionText);

    }

    @Then("I type {string} into Option {int} field")
    public void iTypeIntoOptionField(String sOptionValue, int sNumberOption) {
        getDriver().findElement(By.xpath("//*[@placeholder='Option "+sNumberOption+"*']")).sendKeys(sOptionValue);
    }

    @Then("I select {string} from answers")
    public void iSelectFromAnswers(String sAnswer) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Option 1*')]/../../../../../..//*[@class='mat-radio-inner-circle']")).click();
    }

    @Then("I should see {string} error message")
    public void iShouldSeeErrorMessage(String sError) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'This field is required')]")).isDisplayed()).isTrue();
    }

    @Then("I mark {string}Other{string} checkbox")
    public void iMarkOtherCheckbox(String arg0, String arg1) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Include \"Other\" text area option for this question?')]")).click();
    }

    @Then("I mark {string}Show-Stopper{string} checkbox")
    public void iMarkShowStopperCheckbox(String arg0, String arg1) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Show-Stopper')]")).click();
    }

    @Then("{string} error message should be displayed")
    public void errorMessageShouldBeDisplayed(String arg0) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'*Choose correct answer')]")).isDisplayed()).isTrue();
    }

    @Then("I select {string} from List of Quizzes")
    public void iSelectFromListOfQuizzes(String arg0) {
        getDriver().findElement(By.xpath("//*[contains(text(),'_Internship Quiz')]")).click();
    }

    @Then("I click on {string} button")
    public void iClickOnButton(String arg0) {
        getDriver().findElement(By.xpath("//*[contains(text(),'_Internship Quiz')]/../../..//*[contains(text(),'Preview')]")).click();
    }

    @Then("I click on {string} menu item")
    public void iClickOnMenuItem(String arg0) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Submissions')]")).click();
    }

    @Then("I click on {string} button of submitted quiz")
    public void iClickOnButtonOfSubmittedQuiz(String arg0) {
        getDriver().findElement(By.xpath("//*[contains(text(),'_Internship Quiz')]/..//*[contains(text(),'Grade')]")).click();
    }

    @Then("window with submitted quiz info should appear")
    public void windowWithSubmittedQuizInfoShouldAppear() {
        assertThat(getDriver().findElement(By.xpath("//td[contains(text(),'Submitted At:')]/../../../../../..//*[@class='header mat-card']")).isDisplayed()).isTrue();
    }

    @Then("I click on {string} button and grade submitted Quiz")
    public void iClickOnButtonAndGradeSubmittedQuiz(String arg0) {
        getDriver().findElement(By.xpath("//span[contains(text(),'+')]")).click();
    }

    @And("I click {string} button to save graded quiz")
    public void iClickButtonToSaveGradedQuiz(String arg0) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }

    @Then("I click on {string} button to grade textual question")
    public void iClickOnButtonToGradeTextualQuestion(String arg0) {
        getDriver().findElement(By.xpath("//button[not(@disabled)]/span[contains(text(),'+')]")).click();
    }

    @Then("I write {string} into Teacher Comment field")
    public void iWriteIntoTeacherCommentField(String sComment) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Teacher Comment']")).sendKeys(sComment);
    }

    @Then("I write {string} into Teacher Summary field")
    public void iWriteIntoTeacherSummaryField(String sSummary) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Teacher Summary']")).sendKeys(sSummary);
    }

    @And("{string} status should be displayed")
    public void statusShouldBeDisplayed(String sAssessmentStatus) {
        assertThat(getDriver().findElement(By.xpath("//div[contains(text(),'"+sAssessmentStatus+"')]")).isDisplayed()).isTrue();
    }

    @Then("I click on {string} menu item for Student")
    public void iClickOnMenuItemForStudent(String arg0) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'My Grades')]")).click();
    }

    @And("submitted quiz is in pending status")
    public void submittedQuizIsInPendingStatus() {
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(),'PENDING')]/../..//*[contains(text(),'_Internship Quiz')]")).isDisplayed()).isTrue();
    }

}



