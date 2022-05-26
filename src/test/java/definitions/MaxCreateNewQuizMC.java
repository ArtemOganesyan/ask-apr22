package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

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


}
