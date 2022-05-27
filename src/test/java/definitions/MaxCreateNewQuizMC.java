package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MaxCreateNewQuizMC {
    @Then("I click on Quizzes in the sidebar")
    public void iClickOnQuizzesInTheSidebar() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Quizzes')]")).click();
    }


    @Then("I click on Create New Quiz button")
    public void iClickOnCreateNewQuizButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
    }


    @Then("I type title of the quiz {string} in the field")
    public void iTypeTitleOfTheQuizInTheField(String title) {
        //getDriver().findElement(By.xpath("//input[@id='mat-input-89']")).sendKeys(title);
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }


    @And("I click on Add question button")
    public void iClickOnAddQuestionButton() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("I select question type {string} for question {int}")
    public void iSelectQuestionTypeForQuestion(String questionType, int questionNumber) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q" + questionNumber + "')]/../../..//*[contains(text(), '" + questionType + "')]")).click();
        Thread.sleep(2000);
    }

    @And("I type text {string} for question {int}")
    public void iTypeTextForQuestion(String questionText, int questionNumber) {
        getDriver().findElement(By.xpath("//*[contains(text(), 'Q" + questionNumber + "')]/../../..//*[@placeholder  = 'Question *']")).sendKeys(questionText);
    }

    @And("I type text {string} for option {int} for question {int}")
    public void iTypeTextForOptionForQuestion(String optionText, int optionNumber, int questionNumber) throws InterruptedException {
        String xPath = "//*[contains(text(), 'Q" + questionNumber + "')]/../../..//textarea[@placeholder='Option " + optionNumber + "*']";
        getDriver().findElement(By.xpath(xPath)).sendKeys(optionText);
        Thread.sleep(2000);
    }

    @And("I select option {int} as a correct answer for question {int}")
    public void iSelectOptionAsCorrectAnswerForQuestion(int arg0, int arg1) throws InterruptedException {
        String xPath = "//ac-question-body-form/div[1]/div[2]/div[1]/div[2]/mat-checkbox[1]/label[1]/div[1]";
        getDriver().findElement(By.xpath(xPath)).click();
        Thread.sleep(2000);
    }

    @And("I click Save button")
    public void iClickSaveButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[normalize-space()='Save']")).click();
        Thread.sleep(5000);
    }

    @Then("quiz {string} appeared in list of quizzes")
    public void quizAppearedInListOfQuizzes(String quizName) throws InterruptedException {
        String listOfQuizzes = getDriver().findElement(By.xpath("//*[@class='quizzes']")).getText();
        Thread.sleep(3000);
        System.out.println(listOfQuizzes);
        assertThat(listOfQuizzes.contains(quizName)).isTrue();
    }


    @And("I click on Preview button for quiz {string}")
    public void iClickOnPreviewButtonForQuiz(String quizName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+quizName+"')]/..")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+quizName+"')]/../../..//*[contains(text(), 'Preview')]")).click();
    }


    @And("I click Close button")
    public void iClickCloseButton() {
        getDriver().findElement(By.xpath("//*[contains(text(), 'Close')]")).click();
    }


    @And("I delete quiz {string}")
    public void iDeleteQuiz(String quizName) {
        getDriver().findElement(By.xpath("//mat-expansion-panel-header //mat-panel-title[contains(text(), '"+quizName+"')]/parent::span/parent::mat-expansion-panel-header/following-sibling::div //span[contains(text(), 'Delete')]")).click();
    }


}




    



