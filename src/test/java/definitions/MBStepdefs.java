package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static support.TestContext.getDriver;

public class MBStepdefs {
    @Given("MB open {string}")
    public void mbOpen(String url) {
        getDriver().get(url);
    }


//    @Then("I click submit button")
//    public void iClickSubmitButto() {
//        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
//
//    }


    @Given("I open url {string}")
    public void iOpenUrlString() {
        String url = getDriver().getCurrentUrl();
        getDriver().get(url);
    }


//    @And("highlight on password field")
//    public void highlightOnPasswordField() {
//    }


    @Then("MB type email {string}")
    public void mbTypeEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("MB type password {string}")
    public void mbTypePassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }


    @Then("MB click submit button")
    public void mbClickSubmitButton() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("MB verify successful login")
    public void mbVerifySuccessfulLogin() {
        String a = getDriver().findElement(By.xpath("//div[@class='cdk-visually-hidden']")).getText();
        System.out.println(a);
        if (a.equals("M Bora teacher")) {
            assert (a.equals("Successful login"));
        } else {
            assert (a).equals("Authentication failed. User not found or password does not match");
        }

    }

    @Given("MB open url {string}")
    public void mbOpenUrl(String url) {
        getDriver().get(url);
    }

    @Then("MB types password {string}")
    public void mbTypesPassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("MB highlight password")
    public void mbHighlightPassword() {
        String copy = getDriver().findElement(By.xpath("//input[@type='password']")).getAttribute("copy");
        if (copy.equals("Disabled Copy Option")) {
            assert (copy).equals("Fail");
        } else {
            assert (copy).equals("PASS");
        }


    }

    @Then("copy option is disabled")
    public void copyOptionIsDisabled() {
        String Copy = getDriver().findElement(By.xpath("//input[@type='password']")).getAttribute("copy");
        if (Copy.equals("Copy option disabled")) {
            assert (Copy).equals("PASS");
        } else {
            assert (Copy).equals("FAIL");
        }
    }

    @Given("MB opens url {string}")
    public void mbOpensUrl(String url) {
        getDriver().get(url);
    }


    @Then("MB enters password {string}")
    public void mbEntersPassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("verify Cut option is disabled")
    public void verifyCutOptionIsDisabled() {
        String Cut = getDriver().findElement(By.xpath("//input[@type='password']")).getAttribute("Cut");
        if (Cut.equals("Cut option disabled")) {
            Assertions.assertThat(Cut).isEqualTo("PASS");
        }else {
            Assertions.assertThat(Cut).isEqualTo("FAIL");
        }
    }
}












