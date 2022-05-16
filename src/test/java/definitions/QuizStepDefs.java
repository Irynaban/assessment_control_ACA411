package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

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
}
