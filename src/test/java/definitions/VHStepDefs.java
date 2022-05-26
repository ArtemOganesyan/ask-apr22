package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;



import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.fail;
import static support.TestContext.getDriver;

public class VHStepDefs {
    @Then("page should contain text {string}")
    public void pageShouldContainText(String confirmationMessage) {
        getDriver().findElement(By.xpath("//h4[contains(text(),'You have been Registered.')]")).getText();
    }

    @And("I click on element")
    public void iClickOnElement() {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]"));
    }

    @Then("element should be displayed")
    public void elementShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//ac-registration-confirmation-page/mat-card[@class=\"mat-card\"]"));
    }

    @Then("element should not be displayed")
    public void elementShouldNotBeDisplayed() {
        getDriver().findElement(By.xpath("//main[@class=\\\"ng-tns-c0-0\\\"]"));
    }

    @Then("error message about Empty field should be displayed")
    public void errorMessageShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//mat-error[text()='This field is required']")).getText();
    }

    @Then("homepage should be displayed")
    public void homepageShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//div[@class=\"mat-drawer-backdrop\"]"));
    }

    @And("homepage should contain role {string}")
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

    @When("I click submissions button")
    public void iClickSubmissionsButton() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Submissions')]")).click();
    }

    @Then("I see submission page")
    public void iSeeSubmissionPage() {
        getDriver().findElement(By.xpath("//mat-card[@class=\"page mat-card\"]"));
    }

    @Then("I click on Automatically Graded button")
    public void iClickOnAutomaticallyGradedButton() {
        getDriver().findElement(By.xpath("//div[contains(text(),'Automatically Graded')]")).click();
    }

    @Then("I should see Automatically Graded page result")
    public void iShouldSeeAutomaticallyGradedPageResult() {
        getDriver().findElement(By.xpath("//div[@class=\"mat-tab-body-wrapper\"]"));
    }

    @And("I click on Reviewed button")
    public void iClickOnReviewedButton() {
        getDriver().findElement(By.xpath("//div[contains(text(),'Reviewed')]")).click();
    }

    @Then("Reviewed page should be displayed")
    public void reviewedPageShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//mat-card[@class=\"page mat-card\"]"));
    }

    @Then("I click on Settings button")
    public void iClickOnSettingsButton() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Settings')]")).click();
    }

    @Then("settings page should be displayed")
    public void settingsPageShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//main/ac-settings-page[@class=\"ng-star-inserted\"]"));
    }

    @And("I click on Change Name button")
    public void iClickOnChangeNameButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Change Your Name')]")).click();
    }

    @Then("I remove existing name from the New Name field")
    public void iRemoveExistingNameFromTheNewNameField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"name\"]")).clear();
    }

    @When("I type {string} into New Name input field")
    public void iTypeIntoNewNameInputField(String newName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"name\"]")).sendKeys(newName);
    }

    @Then("error message about Invalid email should be displayed")
    public void errorMessageAboutInvalidEmailShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//mat-error[text()='Should be a valid email address']")).getText();
    }
}
