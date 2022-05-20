// # Created by Said Khalidov at 4/20/22
package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.assertj.core.api.Assertions.*;


import static support.TestContext.getDriver;


public class KhalidovSaid_LoginStepDefs {
    @Given("I open the staging environment main page")
    public void iOpenTheStagingEnvironmentMainPage() {
        getDriver().get(Env.testEnvironmentURL);
    }

    @Given("I fill out the login form with default credentials")
    public void iFillOutTheLoginFormWithDefaultCredentials() {
        Login.fillOutLoginForm();
    }

    @And("I click on Sign In")
    public void iClickOnSignIn() {
        Login.signIn();
    }

    @Then("The user is signed in and redirected to the main page")
    public void theUserIsSignedInAndRedirectedToTheMainPage() {
        new WebDriverWait(getDriver(), 2)
            .until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[contains(text(), 'Environment: INTERNSHIP')]")));
    }

    @Given("I fill out the login form with {string} email and {string} password")
    public void iFillOutTheLoginFormWithEmailAndPassword(String email, String password) {
        Login.fillOutLoginForm(email, password);
    }

    @Then("{string} is displayed at the bottom")
    public void isDisplayedAtTheBottom(String message) {
        new WebDriverWait(getDriver(), 2)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//simple-snack-bar[text()='" + message + "']")));
    }

    @Given("I fill out the login form with {string} email")
    public void iFillOutTheLoginFormWithEmail(String email) {
        Login.fillEmail(email);
    }

    @Then("Password field has \"This field is required\" next to it")
    public void passwordFieldHasNextToIt() {
        new WebDriverWait(getDriver(), 2)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//mat-error")));
    }

    @Then("Email and password fields have \"This field is required\" next to them")
    public void emailAndPasswordFieldsHaveNextToThem() {
        var elements = new WebDriverWait(getDriver(), 2)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//mat-error")));
        assertThat(elements.size()).isEqualTo(2);
    }

    @Then("I should be redirected to the \"forgot password\" page")
    public void iShouldBeRedirectedToThePage() {
        new WebDriverWait(getDriver(), 2)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(Login.ResetPassword.headerXpath)));
        assertThat(getDriver().getCurrentUrl()).isEqualTo(Login.ResetPassword.url);
    }

    @Given("I click on I forgot my password")
    public void iClickOnIForgotMyPassword() {
        Login.clickForgotPwd();
    }

    @And("I login with default credentials")
    public void iLoginWithDefaultCredentials() {
        Login.fillOutLoginForm();
        Login.signIn();
    }

    public static class Env {
        public static String testEnvironmentURL = "http://ask-internship.portnov.com/#/login";
        public static String defaultStudentEmail = "pcs.internshipks@gmail.com";
        public static String defaultStudentPassword = "Pwd12345";
    }

    private static class Login {
        public static class ResetPassword {
            public static String headerXpath = "//h4[text()= 'Reset Password Request']";
            public static String url = "http://ask-internship.portnov.com/#/forgot-password";
        }
        public static String emailXpath = "//input[@formcontrolname='email']";
        public static String passwordXpath = "//input[@formcontrolname='password']";
        public static String signInBtnXpath = "//button[./span[text()='Sign In']]";
        public static String forgotPwdXpath = "//a[text()='I forgot my password']";

        public static void clickForgotPwd() {
            getDriver().findElement(By.xpath(forgotPwdXpath)).click();
        }

        public static void fillEmail(String email) {
            getDriver().findElement(By.xpath(emailXpath)).sendKeys(email);
        }

        public static void fillPassword(String password) {
            getDriver().findElement(By.xpath(passwordXpath)).sendKeys(password);
        }

        public static void fillOutLoginForm(String email, String password) {
            fillEmail(email);
            fillPassword(password);
        }

        public static void fillOutLoginForm() {
            fillOutLoginForm(Env.defaultStudentEmail, Env.defaultStudentPassword);
        }

        public static void signIn() {
            getDriver().findElement(By.xpath(signInBtnXpath)).click();
        }
    }
}
