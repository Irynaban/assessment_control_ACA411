package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LarisaQuizUpdatedAssignByNameStepDefs {
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
        getDriver().findElement(By.xpath("//span[contains(text(),'" + sButton + "')]")).click();
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int iSec) throws InterruptedException {
        Thread.sleep(iSec * 1000);

    }

    @When("I click {string} menu item")
    public void iClickMenuItem(String sMenuItem) {
        getDriver().findElement(By.xpath("//h5[text()='" + sMenuItem + "']")).click();
    }


    @And("I click on {string} quiz name")
    public void iClickOnQuizName(String sQuizName) {
        List <WebElement> quizNames = getDriver().findElements(By.xpath("//div[@class='quizzes']"));
        for (WebElement item : quizNames) {
            if (item.getText().contains(sQuizName)) {
                item.click();
            }
        }
    }

    @And("I click on the Edit button")
    public void iClickOnTheEditButton() {
        getDriver().findElement(By.xpath("//a[@href='#/quiz-builder/2723']")).click();
    }

    @And("I click on the {string} button")
    public void iClickOnTheButton(String sSave) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+sSave+"')]")).click();
    }

    @Then("I check the {string} time")
    public void iCheckTheTime(String sUpdatedAt) {
        List<WebElement> quizNames = getDriver().findElements(By.xpath("//ac-quizzes-list"));
        for (WebElement item : quizNames) {
            if (item.getText().equals("Tester Test")) {
                item.click();
            }
            LocalTime time = LocalTime.now();
            System.out.println("Current time: " + time);
            LocalDate date = LocalDate.now();
            System.out.println("Current date: " + date);
        }
    }

    @And("I click on the {string}")
    public void iClickOnThe(String sCreate) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+sCreate+"')]")).click();
    }

    @And("I click on Select Quiz To Assign field")
    public void iClickOnSelectQuizToAssignField() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Select Quiz To Assign')]")).click();
    }

    @And("I select {string} and {string} to assign quiz to")
    public void iSelectAndToAssignQuizTo(String sname1, String sname2) {
        List<WebElement> studentNames = getDriver().findElements(By.xpath("//mat-selection-list[@formcontrolname='selectedUsers']"));
        for (WebElement item : studentNames) {
            if (item.getText().equals(sname1)) {
                item.click();
            }
            if (item.getText().equals(sname2)) {
                item.click();
            }
        }
    }

    @And("I click on {string} quiz")
    public void iClickOnQuiz(String sQuizName) {
        List<WebElement> quizNames = getDriver().findElements(By.xpath("//div[@id='cdk-overlay-0']"));
        for (WebElement item : quizNames) {
            if (item.getText().contains(sQuizName)) {
                item.click();
            }
        }
    }

    @And("I click on Give Assignment button")
    public void iClickOnGiveAssignmentButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();
    }

    @Then("I click on the X button in top right corner")
    public void iClickOnTheXButtonInTopRightCorner() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'close')]")).click();
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String sError) {
        assertThat(getDriver().findElement(By.xpath("//mat-error[@id='mat-error-1']")).isDisplayed()).isTrue();
        String sActualMessage = getDriver().findElement(By.xpath("//mat-error[@id='mat-error-1']")).getText();
        System.out.println(sActualMessage);
        assertThat(sActualMessage.equals(sError));
    }

    @Then("I should see element {string} displayed")
    public void iShouldSeeElementDisplayed(String sElement) {
        getDriver().findElement(By.xpath("//mat-card[@class='page mat-card']")).isDisplayed();
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String sError2) {
        assertThat(getDriver().findElement(By.xpath("//mat-error[@id='mat-error-2']")).isDisplayed()).isTrue();
        String sActualMessage = getDriver().findElement(By.xpath("//mat-error[@id='mat-error-2']")).getText();
        System.out.println(sActualMessage);
        assertThat(sActualMessage.equals(sError2));
    }
}