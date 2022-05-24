package definitions;

import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static support.TestContext.getDriver;

public class KyryloStepdefs {
	@And("I verify that quiz with name {string} is present in the list")
	public void iVerifyThatQuizWithNameIsPresentInTheList(String name) {
		int res = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(), '"+name+"')]")).size();
		System.out.println(res);
		Assert.assertTrue(res > 0);
	}

	@Then("I click create new quiz button")
	public void iClickCreateNewQuizButton() {
		getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
	}

	@And("I provide string {string} as title of the quiz")
	public void iProvideStringAsTitleOfTheQuiz(String title) {
		getDriver().findElement(By.xpath("//input[@placeholder='Title Of The Quiz *']")).sendKeys(title);
	}

	@And("I click add question")
	public void iClickAddQuestion() {
		getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
	}

	@And("I select question type {string} in the question section {int}")
	public void iSelectQuestionTypeInTheQuestionSection(String type, int section) {
		getDriver().findElement(By.xpath("(//mat-expansion-panel-header)["+section+"]/following-sibling::div //div[contains(text(), '" + type + "')]")).click();
	}

	@And("I mark option number {int} as correct answer in question section {int}")
	public void iMarkOptionNumberAsCorrectAnswerInQuestionSection(int nb, int section) {
		getDriver().findElement(By.xpath("((//mat-expansion-panel-header)["+section+"]/following-sibling::div //mat-radio-button)["+ (3 + nb) +"]")).click();
	}

	@And("I save the quiz")
	public void iSaveTheQuiz() {
		getDriver().findElement(By.xpath("//span[contains(text(), 'Save')]")).click();
	}

	@And("I add {string} to the field {string} into question section {int}")
	public void iAddToTheFieldIntoQuestionSection(String text, String str, int section) {
		WebElement elem = getDriver().findElement(By.xpath("(//mat-expansion-panel-header)["+section+"]/following-sibling::div //textarea[@placeholder='"+str+"']"));
		elem.click();
		elem.sendKeys(text);
	}

	@And("I type {string} to question title into question section {int}")
	public void iTypeToQuestionTitleIntoQuestionSection(String text, int section) {
		WebElement elem = getDriver().findElement(By.xpath("(//mat-expansion-panel-header)["+section+"]/following-sibling::div //textarea[@formcontrolname='question']"));
		elem.click();
		elem.sendKeys(text);
	}

	@And("I see the list of quizzes")
	public void iSeeTheListOfQuizzes() {
		String actual = getDriver().findElement(By.xpath("//h4")).getText();
		String expected = "List of Quizzes";
		Assert.assertEquals(actual, expected);
	}
}
