package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import javax.naming.Name;

import static support.TestContext.getDriver;

public class AikanyshSteps {
    @Given("TA open url {string}")
    public void taOpenUrl(String arg0) {
        getDriver().get("http://ask-stage.portnov.com");
    }

    @Then("TA type email {string}")
    public void taTypeEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @And("TA type password {string}")
    public void taTypePassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("TA click submit button")
    public void taClickSubmitButton() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Then("TA navigate to {string}")
    public void taNavigateTo(String UsersManagementPage) {
        getDriver().findElement(By.xpath("//h5[contains(text(),\"User's Management\")]")).click();

    }

    @And("TA click on student name {string}")
    public void taClickOnStudentName(String AikanyshTabaldyeva) {
        getDriver().findElement(By.xpath("//a[@href='/#/user-details/17454']")).click();
    }

    @Then("TA click on button {string}")
    public void taClickOnButton(String options) {
        getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();

    }

    @And("TA click {string} button")
    public void taClickButton(String ChangeUserName) {
        getDriver().findElement(By.xpath("//body/div[2]/div[2]/div[1]/div[1]/button[1]")).click();
    }

    @Then("TA type {string} into {string}")
    public void taTypeInto(String NewName, String NewUsersName) {
        getDriver().findElement(By.xpath("//input[@placeholder=\"New User's Name\"]")).sendKeys(NewName);
    }

    @Then("TA click on {string} button")
    public void taClickonButton(String change) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Change')]")).click();

    }

    @And("TA verify new user name set to {string}")
    public void taVerifyNewUserNameSetTo(String NewUserName) {
        Assert.assertEquals(NewUserName, "Aikanysh Tab");

    }

    @Then("TA wait for {int} sec")
    public void taWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }
}
