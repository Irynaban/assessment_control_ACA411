package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import javax.swing.text.html.HTMLDocument;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class studentSettingsPasswordStepDefs {
    @cucumber.api.java.en.Given("I go to {string}  student's page")
    public void iGoToStudentSPage(String sUrl) {
        sUrl.equals("login");
        getDriver().get("http://ask-internship.portnov.com/#/login");
    }

    @When("I type {string} student's email")
    public void iTypeStudentSEmail(String sEmail) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(sEmail);
    }

    @And("I type {string} into password field for student")
    public void iTypeIntoFieldForStudent(String sPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(sPassword);
    }

    @And("I click {string} button")
    public void iClickButton(String sButton) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+sButton+"')]")).click();
    }

    @And("I wait for {int} seconds")
    public void iWaitForSec(int iSec) throws  InterruptedException{
        Thread.sleep(iSec*1000);
    }

    @When("I click on {string} menu item")
    public void iClickOnMenuItem(String sMenuItem) {
        getDriver().findElement(By.xpath("//h5[text()='"+sMenuItem+"']")).click();
    }

    @When("I click on {string}")
    public void iClickOn(String sChangePassword) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+sChangePassword+"')]")).click();
    }

    @Then("new window pop-up is displayed")
    public void newWindowPopUp() {
        getDriver().findElement(By.xpath("//h1[contains(text(),'Changing Password')]")).isDisplayed();
    }

    @Then("I click to {string} button")
    public void iClickToButton(String sButton) {
        getDriver().findElement(By.xpath("//button[@type='button']/span[contains(text(),'"+sButton+"')]")).click();
    }

    @Then("{string} menu is displayed")
    public void menuIsDisplayed(String sMenuItem) {
        getDriver().findElement(By.xpath("//h4[contains(text(),'"+ sMenuItem+"')]")).isDisplayed();
    }

    @Then("I type {string} in {string}")
    public void iTypeIn(String sPassword, String sPasswordField) {
        getDriver().findElement(By.xpath("//input[@placeholder='"+sPasswordField+"']")).sendKeys(sPassword);
    }

    @Then("I clear {string} in PasswordField")
    public void iClearInPasswordField(String sPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).clear();
    }

    @Then("{string} error is displayed in New Password")
    public void errorIsDisplayed(String sError) {
        String sActualMessage = getDriver().findElement(By.xpath("//div//*[contains(text(),'"+sError+"')]")).getText();
        System.out.println(sActualMessage);
        Assertions.assertThat(sActualMessage.contains((sError)));
    }

    @Then("{string} error is displayed in Confirm New Password")
    public void errorIsDisplayedInConfirmNewPassword(String sError) {
        String sActualMessage = getDriver().findElement(By.xpath("//div//*[contains(text(),'"+sError+"')]")).getText();
        System.out.println(sActualMessage);
        Assertions.assertThat(sActualMessage.contains((sError)));
    }

    @Then("{string} button is disabled")
    public void buttonIsDisabled(String sButton) {
        Assertions.assertThat(getDriver().findElement(By.xpath("//button[@aria-label='Close dialog']/span[contains(text(),'"+sButton+"')]")).isEnabled()).isTrue();

    }

    @Then("I clear {string}")
    public void iClear(String sPasswordField) {
        getDriver().findElement(By.xpath("//input[@placeholder='"+sPasswordField+"']")).clear();
    }

    @Then("{string} error is displayed in Password")
    public void errorIsDisplayedInPassword(String sError) {
        String sActualMessage = getDriver().findElement(By.xpath("//div//*[contains(text(),'"+sError+"')]")).getText();
        System.out.println(sActualMessage);
        Assertions.assertThat(sActualMessage.contains((sError)));
    }

    @Then("error message {string} menu is displayed")
    public void errorMessageMenuIsDisplayed(String sError) {
        getDriver().findElement(By.xpath("//div[contains(text(),'"+sError+"')]")).isDisplayed();
    }

    @Then("I type {string} in {string} and confirm it is hidden")
    public void iTypeInAndConfirmItIsHidden(String sPassword, String sPasswordField) {
        getDriver().findElement(By.xpath("//input[@placeholder='"+sPasswordField+"']")).sendKeys(sPassword);
        String sActualMessage = getDriver().findElement(By.xpath("//input[@placeholder='"+sPasswordField+"']")).getText();
        Assertions.assertThat(sActualMessage.contentEquals(sPassword));
    }
}
