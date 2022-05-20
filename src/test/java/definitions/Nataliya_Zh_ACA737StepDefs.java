package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class Nataliya_Zh_ACA737StepDefs {
    @When("I fill out the Email field {string}")
    public void iFillOutTheEmailField(String sEmail) {
        getDriver().findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys(sEmail);
    }

    @Then("I fill out the Password field {string}")
    public void iFillOutThePasswordField(String sPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys(sPassword);
    }

    @Then("I click on {string} button")
    public void iClickOnButton(String sButton) {
        getDriver().findElement(By.xpath("//*[@id='mat-tab-content-5-0']/div/table/tbody/tr[2]/td[6]/a")).getCssValue(sButton);
    }

    @And("I click button {string}")
    public void iClickButton(String sButton) {
        getDriver().findElement(By.xpath("//button//*[text()='" + sButton + "']")).click();
    }
    @Then("I click {string} button on")
    public void iClickButtonOn(String sGradeButton) {
            getDriver().findElement(By.xpath("(//button[@class='mat-raised-button mat-primary'])[1]")).click();
    }

    @Then("I see {string} on this page are visible")
    public void iSeeOnThisPageAreVisible(String sActualPoints) {
        getDriver().findElement(By.xpath("//td[contains(text(),'Actual points / percentage:')]")).isDisplayed();
    }

    @Then("I see percentage on this page is visible")
    public void iSeePercentageOnThisPageIsVisible() {
        getDriver().findElement(By.xpath("//td[contains(text(),'0 of 3 / 0%')]")).isDisplayed();
    }

    @When("I click on {string} button under {string} to increase the points")
    public void iClickOnButtonUnderToIncreaseThePoints(String sPlus, String sTotalPoints) {
        getDriver().findElement(By.xpath("(//button[@class='mat-mini-fab mat-accent'])[2]")).click();

    }

    @Then("I click the button {string} to saving changes")
    public void iClickTheButtonToSavingChanges(String sSave) {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
    }
}