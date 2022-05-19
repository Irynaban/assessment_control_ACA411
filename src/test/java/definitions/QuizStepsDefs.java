package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.Assertion;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static support.TestContext.getDriver;

public class QuizStepsDefs {
    @cucumber.api.java.en.Given("I go to {string} page")
    public void iGoToPage(String sUrl) {
        sUrl.equals("login");
            getDriver().get("http://ask-internship.portnov.com/#/login");
        }

    @cucumber.api.java.en.When("I type {string}")
    public void iType(String sEmail) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(sEmail);
    }

    @And("I type {string} into {string} field")
    public void iTypeIntoField(String sPassword, String sPasswordField) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(sPassword);
    }

    @And("I click button {string}")
    public void iClickButton(String sButton) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+sButton+"')]")).click();
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int iSec) throws  InterruptedException{
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
        getDriver().findElement(By.xpath("//*[contains(text(),'"+sQuestionType+"')]")).click();
    }

    @When("I put in {string} into field {string}")
    public void iPutInIntoField(String sQuestionText, String sQuestionField) {
        getDriver().findElement(By.xpath("//*//textarea[@formcontrolname='"+sQuestionField+"']")).sendKeys(sQuestionText);
        String sActualMessage = getDriver().findElement(By.xpath("//*[@class='mat-expansion-panel-header-title']")).getText();
        System.out.println(sActualMessage);
        Assertions.assertThat(sActualMessage.equalsIgnoreCase(sQuestionText));
    }

    @And("I check {string} time")
    public void iCheckTime(String sCreatedAt) {
        System.out.println("-----Current time of your quiz creation-----");
        LocalTime time = LocalTime.now();
        System.out.println("Current time: " + time);
        LocalDate date = LocalDate.now();
        System.out.println("Current date: " + date);
    }
    @Then("I switch to iframe with xpath {string}")
    public void iSwitchToIframeWithXpath(String xpath) {
        getDriver().switchTo().frame(getDriver().findElement(By.xpath(xpath)));
    }

    @When("I put in second {string} into field {string}")
    public void iPutInSecondIntoField(String sOption, String sOptionField) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='"+sOptionField+"']")).sendKeys(sOption);

    }

    @Then("I click radio button to select correct answer")
    public void iClickToSelectCorrectAnswer() {
        getDriver().findElement(By.xpath("//mat-radio-button[@class='mat-radio-button mat-accent']")).click();
    }

    @When("I create {string} question")
    public void iCreateQuestion(String sQuestion) {
        getDriver().findElement(By.xpath("//*//textarea[@formcontrolname='question']")).sendKeys(sQuestion);
    }

    @Then("I put in first {string} into field {string}")
    public void iPutInFirstIntoField(String sOption, String sOptionField) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='"+sOptionField+"']")).sendKeys(sOption);
    }

    @Then("I select {string} as correct answer")
    public void iSelectAsCorrectAnswer(String sCheckBox) {
        getDriver().findElement(By.xpath("//div[@class='option-row horizontal-group ng-touched ng-pristine ng-valid ng-star-inserted']//*[@id='mat-checkbox-24-input']")).click();
    }
}