package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.*;

import static support.TestContext.getDriver;

public class KhalidovSaid_ChangeStudentNameStepDefs {
    private static String existingName = "";
    private static String initialName = "";

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
        initialName = existingName;
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
        assertThat(updatedName).isEqualTo(initialName);
    }

    @Then("I type a new name in the name field as {string}")
    public void iTypeANewNameInTheNameFieldAs(String newName) {
        Settings.ChangeNameModal.fillName(newName);
        existingName = newName;
    }

    @And("The name has been changed to {string}")
    public void theNameHasBeenChangedTo(String newName) {
        assertThat(Settings.extractCurrentName()).isEqualTo(newName);
    }

    @Then("'Should contain only latin characters, space or numbers' is displayed")
    public void shouldContainOnlyLatinCharactersIsDisplayed() {
        assertThat(Settings.ChangeNameModal.errorMessageIsDisplayed("Should contain only latin characters, space or numbers")).isTrue();
    }

    @And("'Change' button is disabled")
    public void changeButtonIsDisabled() {
        assertThat(Settings.ChangeNameModal.changeIsDisabled()).isTrue();
    }

    @And("I click elsewhere on the `Change Your Name` modal")
    public void iClickElsewhereOnTheChangeYourNameModal() {
        Settings.ChangeNameModal.clickElsewhere();
    }

    @And("I click on Cancel")
    public void iClickOnCancel() {
        Settings.ChangeNameModal.clickCancel();
    }

    @Then("I click outside the popup window")
    public void iClickOutsideThePopupWindow() {
        Settings.clickElsewhere();
    }

    @Then("I clear the name field")
    public void iClearTheNameField() {
        Settings.ChangeNameModal.clearName();
    }
    
    @Then("I try to click on `Change`")
    public void iTryToClickOnChange() {
        Settings.ChangeNameModal.clickChange();
    }

    @Then("`This field is required` is displayed")
    public void theFieldIsRequiredIsDisplayed() {
        assertThat(Settings.ChangeNameModal.errorMessageIsDisplayed("This field is required")).isTrue();
    }

    private static class MainPage {
        public static String settingsXpath = "//a[.//h5[text()='Settings']]";
    }

    private static class Settings {
        public static String changeNameBtnXpath = "//button[./span[text()='Change Your Name']]";
//        public static String settingsCardXpath = "//mat-card[./h4[contains(text(), 'Settings')]]";
        public static String userNameXpath = "//mat-card[./h4[contains(text(), 'Settings')]]/div//td[contains(text(), 'USER:')]/following-sibling::td";
        public static String emptySpaceXpath = "//div[@class=\"cdk-overlay-container\"]";


        public static class ChangeNameModal {
            public static String mainXpath = "//mat-dialog-container[.//h1[contains(text(), \"Changing User's Name\")]]";
            public static String changeXpath = "//button[./span[text()='Change']]";
            public static String cancelXpath = "//button[./span[text()='Cancel']]";
            public static String nameFieldXpath = "//input[@formcontrolname='name']";
            public static String titleXpath = "//h1[text()=\"Changing User's Name\"]";

            public static void clickChange() {
                getDriver().findElement(By.xpath(changeXpath)).click();
            }

            public static void fillName(String name) {
                var nameField = getDriver().findElement(By.xpath(nameFieldXpath));
                nameField.clear();
                nameField.sendKeys(name);
            }

            public static void clearName() {
                var nameField = getDriver().findElement(By.xpath(nameFieldXpath));
                nameField.clear();
                nameField.sendKeys(" ");
                nameField.sendKeys(Keys.BACK_SPACE);
            }

            public static boolean changeIsDisabled() {
                var changeButton = getDriver().findElement(By.xpath(changeXpath));
                return changeButton.getAttribute("disabled") != null;
            }

            public static void clickElsewhere() {
                getDriver().findElement(By.xpath(titleXpath)).click();
            }
            
            public static boolean errorMessageIsDisplayed(String message) {
                return getDriver().findElements(By.xpath("//mat-error[text()=\"" + message + "\"]")).size() > 0;
            }

            public static void clickCancel() {
                getDriver().findElement(By.xpath(cancelXpath)).click();
            }
        }

        public static void clickChangeName() {
            getDriver().findElement(By.xpath(changeNameBtnXpath)).click();
        }

        public static String extractCurrentName() {
            return getDriver().findElement(By.xpath(userNameXpath)).getText();
        }

        public static void clickElsewhere() {
            getDriver().findElement(By.xpath(emptySpaceXpath)).click();
        }
    }
}
