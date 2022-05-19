package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class homePage_LinksStepDefs {
    @Then("page header {string} should be present")
    public void iWaitForElementWithXpathToBePresent(String elementText) {
        new WebDriverWait(getDriver(), 10, 200).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'" + elementText + "')]")));
    }

    @And("current URL is {string}")
    public void currentURLIs(String expectedUrl) {
        String currentUrl = getDriver().getCurrentUrl();
        assertThat(expectedUrl).isEqualTo(currentUrl);
    }
}
