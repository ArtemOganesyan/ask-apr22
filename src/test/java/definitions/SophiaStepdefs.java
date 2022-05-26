package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

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
        getDriver().switchTo().parentFrame().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]/..")).click();
    }

    @Then("I type title of the quiz {string}")
    public void iTypeTitleOfTheQuiz(String quizName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"name\"]")).sendKeys(quizName);
    }

    @And("click Add Questions button")
    public void clickAddQuestionsButton() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("I select Textuall Question button")
    public void iSelectTextuallQuestionButton() {
        getDriver().findElement(By.xpath("//mat-radio-button[@id='mat-radio-10']")).click();
    }
}
