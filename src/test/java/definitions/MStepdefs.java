package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MStepdefs {
    @Given("I open url")
    public void iOpenUrl() {
        String currentUrl = getDriver().getCurrentUrl();
        getDriver().get(currentUrl);
    }


    @Then("I type email {string}")
    public void iTypeEmailString(String arg0) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(arg0);
    }



    @Then("I click submit button")
    public void iClickSubmitButto() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @And("I verify message is set to {string}")
    public void iVerifyMessageIsSetTo(String arg0) {
        String a = getDriver().findElement(By.xpath("//div[@class='cdk-visually-hidden']")).getText();
        System.out.println(a);
        if (a.equals("M Bora teacher")) {
            assertThat(a).isEqualTo("Successful login");
        } else {
            assertThat(a).isEqualTo("Authentication failed. User not found or password does not match");
        }
    }


//    @Given("I open url {string}")
//    public void iOpenUrlString() {
//        String url = getDriver().getCurrentUrl();
//        getDriver().get(url);
//    }


    @Then("I type password {string}")
    public void iTypePasswordString(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("highlight on password field")
    public void highlightOnPasswordField() {
    }


    @And("assert that copy option is disabled")
    public void assertThatCopyOptionIsDisabled() {
        String Copy = getDriver().findElement(By.xpath("//input[@type='password']")).getAttribute("copy");
        if (Copy.equals("Disabled Copy Option")) {
            assertThat(Copy).isEqualTo("Pass");
        }else {
            assertThat(Copy).isEqualTo("Fail");
        }

    }


    @Given("MB open url {string}")
    public void imOpenUrl(String url) {
        getDriver().get(url);
    }


    @Given("MB open url {string}")
    public void mbOpenUrl(String url) {
        getDriver().get(url);
    }

    @Then("MB type password {string}")
    public void mbTypePassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @And("MB highlight on password field")
    public void mbHighlightOnPasswordField() {

    }

    @And("cut option is disabled")
    public void cutOptionIsDisabled() {
        String Cut = getDriver().findElement(By.xpath("//input[@type='password']")).getAttribute("Cut");
        if (Cut.equals("Disabled Copy Option")) {
            assertThat(Cut).isEqualTo("Pass");
        }else {
            assertThat(Cut).isEqualTo("Fail");
        }

    }

    @Given("M open url {string}")
    public void mOpenUrl(String url) {
        getDriver().get(url);
    }

    @Then("M type email {string}")
    public void mTypeEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("M type password {string}")
    public void mTypePassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }


    @And("MB verify current user role set to {string}")
    public void mVerifyCurrentUserRoleSetTo(String role) {
        String r = getDriver().findElement(By.xpath("//div[@class=\"info\"]//p")).getText();
        System.out.println(r);
        if (role.equals("TEACHER")) {
            assertThat(r).isEqualTo("TEACHER");
        }
        else {
            assertThat(r).isEqualTo("STUDENT");
        }
        }



    }

