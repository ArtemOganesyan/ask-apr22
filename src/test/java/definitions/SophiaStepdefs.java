package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SophiaStepdefs {
    @Given("I open {string}")
    public void iOpen(String url) {
        getDriver().get(url);
    }

    @Then("I type teacherEmail {string}")
    public void iTypeTeacherEmail(String tEmail) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(tEmail);
    }

    @Then("I type teacherPassword {string}")
    public void iTypeTeacherPassword(String tPassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(tPassword);
    }

    @Then("I click Sign In button")
    public void iClickSignInButton() {
        getDriver().findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    @Then("I wait {int} seconds")
    public void iWaitSeconds(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @Then("click Create New Quiz button")
    public void clickCreateNewQuizButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
    }

    @Then("I type title of the quiz {string}")
    public void iTypeTitleOfTheQuiz(String quizName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"name\"]")).sendKeys(quizName);
    }

    @And("click Add Questions button")
    public void clickAddQuestionsButton() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("I select question type {string} in {string}")
    public void iSelectQuestionTypeIn(String type, String questionNumber) {
        getDriver().findElement(By.xpath("(//label[@class='mat-radio-label'])[1]")).click();
    }

    @And("I type {string} into question field")
    public void iTypeIntoQuestionField(String questionField) {
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(questionField);
    }

    @Then("I click Save button")
    public void iClickSaveButton() {
        getDriver().findElement(By.xpath("(//button[@_ngcontent-c19])[4]")).click();
    }

    @Then("I verify quiz {string} is created")
    public void iVerifyQuizIsCreated(String quizName) {
        //assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains (text(), '"+quizName+"')]"))).hasSize(1);
       // assertThat(getDriver().findElements(By.xpath(xpath))).hasSize(1);
        String actualText = getDriver().findElement(By.xpath("(//mat-panel-title[contains (text(), 'SL Quiz')])[1]")).getText();
        assertThat(actualText).isEqualTo(quizName);
        System.out.println("Quiz was created");
    }

    @Then("I click Create New Assignment")
    public void iClickCreateNewAssignment() {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
    }

    @Then("I select quiz to assign {string}")
    public void iSelectQuizToAssign(String quizName) {
        getDriver().findElement(By.xpath("(//span[contains (text(), '"+quizName+"')])[1]")).click();
    }

    @Then("I click Select Quiz to Assign drop-down menu")
    public void iClickSelectQuizToAssignDropDownMenu() {
        getDriver().findElement(By.xpath("//mat-select[@placeholder='Select Quiz To Assign']")).click();
    }

    @Then("I select student name {string}")
    public void iSelectStudentName(String studentName) {
        getDriver().findElement(By.xpath("//div[@class='mat-list-text'][contains (normalize-space(.), '"+studentName+"')]")).click();
    }

    @Then("I click Give Assignment button")
    public void iClickGiveAssignmentButton() {
        getDriver().findElement(By.xpath("//button [@type='submit']")).click();
    }

    @Then("I verify quiz {string} assigned to {string}")
    public void iVerifyQuizAssignedTo(String quizName, String studentName) {
        String actualText = getDriver().findElement(By.xpath("(//span[contains(text(),'"+quizName+"')])[1]")).getText();
        assertThat(actualText).isEqualTo(quizName);
//        String actualStudent = getDriver().findElement(By.xpath("(//td[contains(text(), '"+studentName+"')])[1]")).getText();
//        assertThat(actualStudent).isEqualTo(studentName);
//        System.out.println("Assignment was created" + actualStudent +actualText);


    }
}
