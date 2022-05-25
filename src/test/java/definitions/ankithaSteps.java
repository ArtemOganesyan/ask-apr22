package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class ankithaSteps {
    @Then("I type teacher email {string}")
    public void iTypeTeacherEmail(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
    }

    @Then("I click {string} option")
    public void iClickOption(String option) {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    }

    @Then("I see list of quizzes")
    public void iSeeListOfQuizzes() {
        getDriver().findElement(By.xpath("//div[@class='quizzes']")).isDisplayed();
    }


    @And("I type {string} in the text field")
    public void iTypeInTheTextField(String text) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(text);
    }

    @And("I select {string} option")
    public void iSelectOption(String Qtype) {
        getDriver().findElement(By.xpath("//div[contains(text(),'Single-Choice')]")).click();
    }

    @Then("I type {string} in the question field")
    public void iTypeInTheQuestionField(String question) {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(question);
    }

    @Then("I type {string} in option {int}")
    public void iTypeInOption(String option, int op) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).sendKeys(option);
    }

    @Then("I select option {int} as correct answer")
    public void iSelectOptionAsCorrectAnswer(int co) {
        getDriver().findElement(By.xpath("//input[@name='mat-radio-group-22']")).click();
    }

    @Then("I verify question is added")
    public void iVerifyQuestionIsAdded() {
        String r= getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'SQA Single choice questions')]")).getText();
        System.out.println(r);

    }
}
