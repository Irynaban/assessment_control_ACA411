package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class QuizStepDefs {
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
    public void iWaitForSec(int iSec) throws InterruptedException{
        Thread.sleep(iSec*1000);

    }

    @When("I click {string} menu item")
    public void iClickMenuItem(String sMenuItem) {
        getDriver().findElement(By.xpath("//h5[text()='"+sMenuItem+"']")).click();
    }

    @When("I type {string} as quiz title")
    public void iTypeAsQuizTitle(String sQuizTitle) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(sQuizTitle);

    }

    @And("I add a question")
    public void iAddAQuestion() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @When("I select {string} question type")
    public void iSelectQuestionType(String sQuestionType) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+ sQuestionType + "')]")).click();

    }

    @When("I type {string} into field {string}")
    public void iTypeIntoField(String sQuestionText, String sField) {
      getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+ sField +"')]/../../..//textarea[@formcontrolname='question']")).sendKeys(sQuestionText);
    }

    @When("I select point per question as {string}")
    public void iSelectPointPerQuestionAs(String sQuestionPoint) {
        String sAreaValueNow = getDriver().findElement(By.xpath("//mat-slider[@class = 'mat-slider mat-accent mat-slider-horizontal']")).getAttribute("aria-valuenow");
        System.out.println(sAreaValueNow);

    }

    @Then("I change point per question to {string}")
    public void iChangePointPerQuestionTo(String sQuestionPoint) {
        String sAreaValueNow = getDriver().findElement(By.xpath("//mat-slider[@class = 'mat-slider mat-accent mat-slider-horizontal']")).getAttribute("aria-valuenow");
        System.out.println(sAreaValueNow);
        sAreaValueNow = sQuestionPoint;
        System.out.println("New value" + sAreaValueNow);
    }

    @Then("quiz {string} is displayed on the list of quizzes")
    public void quizIsDisplayedOnTheListOfQuizzes(String sQuizname) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+sQuizname+"')]")).isDisplayed()).isTrue();

    }

    @And("I delete quiz {string}")
    public void iDeleteQuiz(String sQuizName) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+ sQuizName + "')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + sQuizName + "')]/../../..//span[contains(text(),'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@mat-dialog-actions]//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }
}
