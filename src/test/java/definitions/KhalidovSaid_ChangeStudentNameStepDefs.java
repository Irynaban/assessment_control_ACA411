package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.*;

import static support.TestContext.getDriver;

public class KhalidovSaid_ChangeStudentNameStepDefs {
    private static String existingName = "";

    @Given("I click on {string}")
    public void iClickOn(String buttonName) {
        if (buttonName.equalsIgnoreCase("change your name")) {
            Settings.clickChangeName();
        }
    }

    @Then("I select {string} on the sidebar")
    public void iSelectOnTheSidebar(String option) {
        if (option.equalsIgnoreCase("settings")) {
            getDriver().findElement(By.xpath(MainPage.settingsXpath)).click();
        }

        // we need to save the current name to be able to compare it to changes later
        existingName = Settings.extractCurrentName();
    }

    @Then("Pop-up window is displayed with text: \"Changing User's Name\"")
    public void popUpWindowIsDisplayedWithText() {
        new WebDriverWait(getDriver(), 2)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(Settings.ChangeNameModal.mainXpath)));
    }

    @Then("I click on `Change`")
    public void iClickOnChange() {
        Settings.ChangeNameModal.clickChange();
    }

    @Then("I wait for \"Change Your Name\" pop-up to close;")
    public void popUpIsClosed() {
        new WebDriverWait(getDriver(), 2)
            .until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath(Settings.ChangeNameModal.mainXpath)));

        var modal = getDriver().findElements(By.xpath(Settings.ChangeNameModal.mainXpath));
        assertThat(modal.size()).isEqualTo(0);
    }

    @And("The name is not changed")
    public void theNameIsNotChanged() {
        var updatedName = Settings.extractCurrentName();
        assertThat(updatedName).isEqualTo(existingName);
    }

    private static class MainPage {
        public static String settingsXpath = "//a[.//h5[text()='Settings']]";
    }

    private static class Settings {
        public static String changeNameBtnXpath = "//button[./span[text()='Change Your Name']]";
//        public static String settingsCardXpath = "//mat-card[./h4[contains(text(), 'Settings')]]";
        public static String userNameXpath = "//mat-card[./h4[contains(text(), 'Settings')]]/div//td[contains(text(), 'USER:')]/following-sibling::td";

        public static class ChangeNameModal {
            public static String mainXpath = "//mat-dialog-container[.//h1[contains(text(), \"Changing User's Name\")]]";
            public static String changeXpath = "//button[./span[text()='Change']]";

            public static void clickChange() {
                getDriver().findElement(By.xpath(changeXpath)).click();
            }
        }

        public static void clickChangeName() {
            getDriver().findElement(By.xpath(changeNameBtnXpath)).click();
        }

        public static String extractCurrentName() {
            return getDriver().findElement(By.xpath(userNameXpath)).getText();
        }
    }
}
