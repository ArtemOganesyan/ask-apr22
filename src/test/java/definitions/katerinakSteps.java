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
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(password);
    }

    @Then("I KK click on Settings")
    public void iKKClickOnSettings() {
        getDriver().findElement(By.xpath("//h5[contains(text(),\"Settings\")]")).click();
    }

    @Then("I KK click on button Change Your Password")
    public void iKKClickOnButtonChangeYourPassword() {
        getDriver().findElement(By.xpath("//span[contains(text(),\"Change Your Password\")]")).click();
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
        getDriver().findElement(By.xpath("//button[@type='button']/span[contains(text(),'Change')]")).click();
    }

    @And("I KK verify that error message is displayed {string}")
    public void iKKVerifyThatErrorMessageIsDisplayed(String errorMessage) {
        String message = getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]")).getText();
        System.out.println(message);
        if (errorMessage.equals("This field is required")) {
            assertThat(message).isEqualTo("This field is required");
        } else {
            Assert.fail("Password Changed");
        }
    }


    @And("I KK click on Sign in")
    public void iKKClickOnSignIn() {
        getDriver().findElement(By.xpath("//span[contains(text(),\"Sign In\")]")).click();
    }

    @And("I KK wait for {int} seconds")
    public void iKKWaitForSeconds(int sec) throws InterruptedException {
        Thread.sleep(1000);
    }

    @And("I KK verify the Change button is disabled")
    public void iKKVerifyTheChangeButtonIsDisabled() {
        assertThat(getDriver().findElement(By.xpath("//span[contains(text(), \"Change\")]")).isEnabled()).isFalse();
    }

    @Then("I KK click on cancel button")
    public void iKKClickOnCancelButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'\"Cancel\")]")).click();
    }

    @Then("I KK verify that page goes back to home screen and see role as {string}")
    public void iKKVerifyThatPageGoesBackToHomeScreenAndSeeRoleAs(String role) {
        String r = getDriver().findElement(By.xpath("//td[contains(text(),\"STUDENT\")]")).getText();
        System.out.println(r);
        if (role.equals("STUDENT")) {
            assertThat(r).isEqualTo("STUDENT");
        } else {
            Assert.fail("Role not displayed");

        }
    }

    @And("I KK verify the message is displayed {string}")
    public void iKKVerifyTheMessageIsDisplayed(String errorMessage) {
        String message = getDriver().findElement(By.xpath("\"//mat-error[contains(text(),'Too short. Should be at least 5 characters')]\"")).getText();
        if (errorMessage.equals("Too short. Should be at least 5 characters")) {
            assertThat(message).isEqualTo("Too short. Should be at least 5 characters");
        } else {
            Assert.fail("Password Changed");
        }
    }

    @And("I KK verify the error message {string} is displayed")
    public void iKKVerifyTheErrorMessageIsDisplayed(String errorMessage) {
        String message = getDriver().findElement(By.xpath("\"//mat-error[contains(text(),'Too long. Should be no more than 32 characters')]\"")).getText();

        if (errorMessage.equals("Too long. Should be no more than 32 characters")) {
            assertThat(message).isEqualTo("Too long. Should be no more than 32 characters");
        } else {
            Assert.fail("Password Changed");
        }
    }

    @And("I KK verify that {string} is displayed")
    public void iKKVerifyThatIsDisplayed(String errorMessage) {
        String message = getDriver().findElement(By.xpath("\"//mat-error[contains(text(),'White spaces are not allowed')]\"")).getText();
        if (errorMessage.equals("White spaces are not allowed")) {
            assertThat(message).isEqualTo("White spaces are not allowed");
        } else {
            Assert.fail("Password Changed");
        }
    }


    @Then("I KK confirm the message {string} is displayed")
    public void iKKConfirmTheMessageIsDisplayed(String errorMessage) {
        String message = getDriver().findElement(By.xpath("\"//mat-error[contains(text(),'Entered passwords should match')]\"")).getText();
        if (errorMessage.equals("Entered passwords should match")) {
            assertThat(message).isEqualTo("Entered passwords should match");
        } else {
            Assert.fail("Password Changed");
        }
    }

    @Then("I KK confirm the error message {string} is displayed")
    public void iKKConfirmTheErrorMessageIsDisplayed(String arg0) {
    }
}

  

