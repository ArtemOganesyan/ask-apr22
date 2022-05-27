package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class katerinakSteps {
//    @Given("I type url {string}")
//    public void iTypeUrl(String url) {
//        getDriver().get(url);
//    }

//    @Then("I type email as {string}")
//    public void iTypeEmailAs(String email) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(email);
//    }
//
//    @And("I type password as {string}")
//    public void iTypePasswordAs(String password) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(password);
//    }

    @Given("I KK type url {string}")
    public void iKKTypeUrl(String url) {
        getDriver().get(url);
    }

    @Then("I KK type email as {string}")
    public void iKKTypeEmailAs(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(email);
    }

    @And("I KK type password as {string}")
    public void iKKTypePasswordAs(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(password);
    }

    @Then("I KK click on Settings")
    public void iKKClickOnSettings() {
        getDriver().findElement(By.xpath("//h5[contains(text(),\"Settings\")]"));
    }

    @Then("I KK click on button Change Your Password")
    public void iKKClickOnButtonChangeYourPassword() {
        getDriver().findElement(By.xpath("//span[contains(text(),\"Change Your Password\")]"));
    }

    @Then("I KK type old password {string}")
    public void iKKTypeOldPassword(String oldPassword) {
        getDriver().findElement(By.xpath("//input[@id=\"mat-input-2\"]")).sendKeys(oldPassword);
    }

    @And("I KK type new password {string}")
    public void iKKTypeNewPassword(String newPassword) {
        getDriver().findElement(By.xpath("//input[@id=\"mat-input-3\"]")).sendKeys(newPassword);
    }

    @And("I KK confirm new password {string}")
    public void iKKConfirmNewPassword(String newPassword) {
        getDriver().findElement(By.xpath("//input[@id=\"mat-input-4\"]")).sendKeys(newPassword);
    }

    @Then("I KK click button Change")
    public void iKKClickButtonChange() {
        getDriver().findElement(By.xpath("//span[contains(text(), \"Change\")]")).click();
    }

    @And("I KK verify that error message is displayed {string}")
    public void iKKVerifyThatErrorMessageIsDisplayed(String errorMessage) {
        String message = getDriver().findElement(By.xpath("//mat-error[@id=\"mat-error-9\"]")).getText();
        if (errorMessage.equals("This field is required")) {
            assertThat(message).isEqualTo("This field is required");
        } else {
            Assert.fail("Password Changed");
        }
    }
}
