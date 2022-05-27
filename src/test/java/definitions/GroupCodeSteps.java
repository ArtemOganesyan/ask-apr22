package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class GroupCodeSteps {
    @Given("AA open url as {string}")
    public void iOpenUrlAs(String url) {
        getDriver().get(url);

    }

    @Then("AA type first name {string}")
    public void iTypeFirstName(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @Then("AA type last name {string}")
    public void iTypeLastName(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @Then("AA type email {string}")
    public void iTypeEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("AA type group code {string}")
    public void iTypeGroupCode(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);

    }

    @Then("AA type password {string}")
    public void iTypePassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
    }

    @Then("AA type confirm password {string}")
    public void iTypeConfirmPassword(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);
    }


    @Then("AA click button Submit")
    public void iClickButtonSubmit() {
      getDriver().findElement(By.xpath("//button[@type='submit']")).click();
//        getDriver().findElement(By.xpath("//button[@type='submit']/span[contains(text(),'Sign In')]")).click();

    }

    @And("verify that user has been registered")
    public void verifyThatUserHasBeenRegistered() {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']")).getText();

    }

    @And("AA should see validation message")
    public void iShouldSeeValidationMessage() {
        getDriver().findElement(By.xpath("//mat-error[text()='Too long. Should be no more than 6 characters']")).getText();

    }

    @Then("AA leave group code input field empty")
    public void iLeaveGroupCodeInputFieldEmpty() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']"));
    }

    @Then("AA type just white spaces in group code field {string}")
    public void iTypeJustWhiteSpacesInGroupCodeField(String groupCode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupCode);
    }


    @Then("AA click on password field")
    public void iClickOnPasswordField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']"));
    }

    @When("AA click on element field I should see error message")
    public void iClickOnElementFieldIShouldSeeErrorMessage() {
        getDriver().findElement(By.xpath("//mat-card[@class='mat-card']")).click();
    }


    @Then("AA should see page")
    public void iShouldSeePage() {
        getDriver().findElement(By.xpath("//form[@class=\"ng-pristine ng-invalid ng-star-inserted ng-touched\"]"));
    }


    @Given("AA open url {string}")
    public void aaOpenUrl(String url) {
        getDriver().get(url);

    }

//    @And("AA should see an error message")
//    public void aaShouldSeeAnErrorMessage() {
//        getDriver().findElement(By.xpath("//div/mat-error[text()='Whitespaces are not allowed']"));
//    }


    @Then("main page should be displayed")
    public void mainPageShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//main/div[@class='staging-label']"));
    }

    @And("AA wait for {int} sec")
    public void aaWaitForSec(int sec) {
        assertThat(sec * 1000);
    }


    @Then("AA click on Quizzes in the left panel")
    public void aaClickOnQuizzesInTheSidebar() {
//        getDriver().findElement(By.xpath("//a[@href='/#/quizzes']")).click();
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    }

    @Then("AA open thr url {string}")
    public void aaOpenThrUrl(String url) {
        getDriver().get(url);

    }

    @And("quiz page should be displayed")
    public void quizPageShouldBeDisplayed() {
        getDriver().findElement(By.xpath("//main[@class=\"ng-tns-c0-0\"]"));
    }

    @Then("AA click on Create new quiz button")
    public void aaClickOnCreateNewQuizButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
    }

    @Then("AA click on add question button")
    public void aaClickOnAddQuestionButton() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("AA type title name of quiz {string}")
    public void aaTypeTitleNameOfQuiz(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @And("AA validation message is appear {string}")
    public void aaValidationMessageIsAppear(String errorMessage) {
       String a = getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]")).getText();
         if (errorMessage.equals("This field is required")) {
           assertThat(errorMessage).isEqualTo("This field is required");
        } else {
           Assert.fail("Changing group code should be rejected");
       }
    }

    @And("AA should see error message {string}")
    public void aaShouldSeeErrorMessage(String errorM) {
        getDriver().findElement(By.xpath("//mat-error[text()='Whitespaces are not allowed']")).getText();
        if (errorM.equals("Whitespaces are not allowed")) {
            assertThat(errorM).isEqualTo("Whitespaces are not allowed");
        } else {
            Assert.fail("Changing group code should be rejected");
        }
    }
}











