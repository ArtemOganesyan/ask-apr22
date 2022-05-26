package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class GroupCodeSteps {
    @Given("I open url as {string}")
    public void iOpenUrlAs(String url) {
        getDriver().get(url);

    }

    @Then("I type first name {string}")
    public void iTypeFirstName(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @Then("I type last name {string}")
    public void iTypeLastName(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @Then("I type email {string}")
    public void iTypeEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I type group code {string}")
    public void iTypeGroupCode(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);

    }

    @Then("I  type password {string}")
    public void iTypePassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("I type confirm password {string}")
    public void iTypeConfirmPassword(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }


    @Then("I click button Submit")
    public void iClickButtonSubmit() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();

    }

    @And("verify that user has been registered")
    public void verifyThatUserHasBeenRegistered() {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']")).getText();

    }

    @And("I should see validation message")
    public void iShouldSeeValidationMessage() {
        getDriver().findElement(By.xpath("//mat-error[text()='Too long. Should be no more than 6 characters']")).getText();
    }

    @Then("I leave group code input field empty")
    public void iLeaveGroupCodeInputFieldEmpty() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']"));
    }

    @And("I validation massage is appear")
    public void iValidationMassageIsAppear() {
        getDriver().findElement(By.xpath("//mat-error[text()='This field is required']")).getText();

    }

    @Then("I type just white spaces in group code field {string}")
    public void iTypeJustWhiteSpacesInGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }

    @And("I should see validation error message")
    public void iShouldSeeValidationErrorMessage() {
        String a = getDriver().findElement(By.xpath("//mat-error[@role='alert']")).getText();

    }

    @Then("I click on password field")
    public void iClickOnPasswordField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
    }

    @When("I click on element field I should see error message")
    public void iClickOnElementFieldIShouldSeeErrorMessage() {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']")).click();
    }

    @Then("I click on quiz in the left menu panel")
    public void iClickOnQuizInTheLeftMenuPanel() {
        getDriver().findElement(By.xpath("//h5[text()='Quizzes']")).click();
    }

    @Then("page should displayed")
    public void pageShouldDisplayed() {
        getDriver().findElement(By.xpath("//main[@class='ng-tns-c0-0']"));
    }


    @Then("I should see page")
    public void iShouldSeePage() {
        getDriver().findElement(By.xpath("//form[@class=\"ng-pristine ng-invalid ng-star-inserted ng-touched\"]"));
    }


    @Then("I click Create new Quiz button")
    public void iClickCreateNewQuizButton() {
        getDriver().findElement(By.xpath("//a[@href='#/quiz-builder']")).click();
    }
}





