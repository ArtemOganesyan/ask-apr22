package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;



import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.fail;
import static support.TestContext.getDriver;

public class VHStepDefs {
    @And("VH click on element")
    public void iClickOnElement() {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]"));
    }


    @Then("VH error message about Empty field should be displayed")
    public void errorMessageShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//mat-error[text()='This field is required']")).getText();
    }

    @Then("VH homepage should be displayed")
    public void homepageShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//div[@class=\"mat-drawer-backdrop\"]"));
    }

    @And("VH homepage should contain role {string}")
    public void homepageShouldContainRole(String role) {
        String t = getDriver().findElement(By.xpath("//div[@class=\"info\"]//p")).getText();
        System.out.println(t);
        if (role.equals("TEACHER")){
            assertThat(t).isEqualTo("TEACHER");
        }
        else if (role.equals("STUDENT")){
            assertThat(t).isEqualTo("STUDENT");
        } else {
            Assert.fail("User role not found");
        }
    }

    @When("VH click submissions button")
    public void iClickSubmissionsButton() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Submissions')]")).click();
    }

    @Then("VH see submission page")
    public void iSeeSubmissionPage() {
        getDriver().findElement(By.xpath("//mat-card[@class=\"page mat-card\"]"));
    }

    @Then("VH click on Automatically Graded button")
    public void iClickOnAutomaticallyGradedButton() {
        getDriver().findElement(By.xpath("//div[contains(text(),'Automatically Graded')]")).click();
    }

    @Then("VH should see Automatically Graded page result")
    public void iShouldSeeAutomaticallyGradedPageResult() {
        getDriver().findElement(By.xpath("//div[@class=\"mat-tab-body-wrapper\"]"));
    }

    @And("VH click on Reviewed button")
    public void iClickOnReviewedButton() {
        getDriver().findElement(By.xpath("//div[contains(text(),'Reviewed')]")).click();
    }

    @Then("VH Reviewed page should be displayed")
    public void reviewedPageShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//mat-card[@class=\"page mat-card\"]"));
    }

    @Then("VH click on Settings button")
    public void iClickOnSettingsButton() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Settings')]")).click();
    }

    @Then("VH settings page should be displayed")
    public void settingsPageShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//main/ac-settings-page[@class=\"ng-star-inserted\"]"));
    }

    @And("VH click on Change Name button")
    public void iClickOnChangeNameButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Change Your Name')]")).click();
    }

    @Then("VH remove existing name from the New Name field")
    public void iRemoveExistingNameFromTheNewNameField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"name\"]")).clear();
    }

    @When("VH type {string} into New Name input field")
    public void iTypeIntoNewNameInputField(String newName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"name\"]")).sendKeys(newName);
    }

    @Then("VH should see error message about Invalid email")
    public void errorMessageAboutInvalidEmailShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//mat-error[text()='Should be a valid email address']"));
    }

    @Given("VH open url {string}")
    public void vhOpenUrl(String url) {
        getDriver().get(url);
    }

    @When("VH type first name {string}")
    public void vhTypeFirstName(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"firstName\"]")).sendKeys(firstName);
    }

    @And("VH type last name {string}")
    public void vhTypeLastName(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"lastName\"]")).sendKeys(lastName);
    }

    @And("VH type email {string}")
    public void vhTypeEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(email);
    }

    @And("VH type group code {string}")
    public void vhTypeGroupCode(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"group\"]")).sendKeys(groupCode);
    }

    @Then("VH type password {string}")
    public void vhTypePassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(password);
    }

    @And("VH type confirm password {string}")
    public void vhTypeConfirmPassword(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"confirmPassword\"]")).sendKeys(confirmPassword);
    }

    @Then("VH click register button")
    public void vhClickRegisterButton() {
        getDriver().findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }


    @Then("VH should see confirmation of successful registering")
    public void vhShouldSeeConfirmationOfSuccessfulRegistering() {
        getDriver().findElement(By.xpath("//mat-card[@class=\"mat-card\"]"));
    }

    @And("VH click Sign In button")
    public void vhClickSignInButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
    }

    @And("VH click Change button")
    public void vhClickChangeButton() {
        getDriver().findElement(By.xpath("//button[@type='button']/span[contains(text(),'Change')]")).click();
    }


    @And("VH error message that name is too short should be displayed")
    public void vhErrorMessageThatNameIsTooShortShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//mat-error[contains(text(), 'This field is required')]"));
    }

    @And("VH wait for {int} seconds")
    public void vhWaitForSeconds(int sec) {
        assertThat(sec * 1000);
    }

    @Then("VH should not see confirmation of successful registering")
    public void vhShouldNotSeeConfirmationOfSuccessfulRegistering() {
        getDriver().findElement(By.xpath("//mat-card[@class=\"mat-card\"]"));
    }


    @And("VH verify that user couldn't register if error message {string} is displayed")
    public void vhVerifyThatUserCouldnTRegisterIfErrorMessageIsDisplayed(String errorMessage) {
        String message = getDriver().findElement(By.xpath("//mat-error[contains(text(), 'This field is required')]")).getText();
        if(errorMessage.equals("This field is required")) {
            assertThat(message).isEqualTo("This field is required");
        } else {
            Assert.fail("User is registered");
        }
    }

    @Then("VH error message {string} should be displayed")
    public void vhErrorMessageShouldBeDisplayed(String errorMessage) {
        String message = getDriver().findElement(By.xpath("//mat-error[@class=\"mat-error ng-star-inserted\"]")).getText();
        if(errorMessage.equals("Too long. Should be no more than 128 characters")) {
            assertThat(message).isEqualTo("Too long. Should be no more than 128 characters");
        } else {
            Assert.fail("User is registered");
        }
    }

    @Then("VH error message that {string} should be displayed")
    public void vhErrorMessageThatShouldBeDisplayed(String errorNotValid) {
        String message = getDriver().findElement(By.xpath("//mat-error[@class=\"mat-error ng-star-inserted\"]")).getText();
        if (errorNotValid.equals("Should be a valid email address")) {
            assertThat(errorNotValid).isEqualTo("Should be a valid email address");
        } else {
            Assert.fail("User is registered");
        }
    }

    @Then("VH should see new name as {string}")
    public void vhShouldSeeNewNameAs(String newName) {
        String change = getDriver().findElement(By.xpath("//div[@class=\"info\"]/h3[contains(text(), \"Bc!2#) *'`-.\")]")).getText();
        if (newName.equals("Bc!2#) *'`-.")) {
            assertThat(newName).isEqualTo("Bc!2#) *'`-.");
        } else {
            Assert.fail("Full Name changed");
        }
    }

    @Then("VH verify that Change name button should be disabled")
    public void vhVerifyThatChangeNameButtonShouldBeDisabled() {
        assertThat(getDriver().findElement(By.xpath("//button[@type='button']/span[contains(text(),'Change')]")).isEnabled()).isFalse();
    }

    @And("VH click around change name panel")
    public void vhClickAroundChangeNamePanel() {
        getDriver().findElement(By.xpath("//div[@class=\"mat-dialog-actions\"]")).click();
    }

    @And("VH error message that {string} about Full Name should be displayed")
    public void vhErrorMessageThatAboutFullNameShouldBeDisplayed(String errorF) {
        String fullname = getDriver().findElement(By.xpath("//mat-error[contains(text(), 'This field is required')]")).getText();
        if (errorF.equals("This field is required")) {
            assertThat(errorF).isEqualTo("This field is required");
        } else {
            Assert.fail("Changing Full Name should be rejected");
        }
    }

    @Then("VH should see error message as {string}")
    public void vhShouldSeeErrorMessageAs(String errorToolong) {
        String message = getDriver().findElement(By.xpath("//mat-error[contains(text(), 'Too long. Should be no more than 100 characters')]")).getText();
        if (errorToolong.equals("Too long. Should be no more than 256 characters")) {
            assertThat(errorToolong).isEqualTo("Too long. Should be no more than 256 characters");
        } else {
            Assert.fail("Fail change name");
        }
    }
}