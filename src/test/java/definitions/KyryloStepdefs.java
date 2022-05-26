package definitions;

import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class KyryloStepdefs {
	@And("KM verify that quiz with name {string} is present in the list")
	public void kmVerifyThatQuizWithNameIsPresentInTheList(String name) {
		int res = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(), '" + name + "')]")).size();
		assertThat(res).isGreaterThan(0);
	}

	@Then("KM click create new quiz button")
	public void kmClickCreateNewQuizButton() {
		getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
	}

	@And("KM provide string {string} as title of the quiz")
	public void kmProvideStringAsTitleOfTheQuiz(String title) {
		getDriver().findElement(By.xpath("//input[@placeholder='Title Of The Quiz *']")).sendKeys(title);
	}

	@And("KM click add question")
	public void kmClickAddQuestion() {
		getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
	}

	@And("KM select question type {string} in the question section {int}")
	public void kmSelectQuestionTypeInTheQuestionSection(String type, int section) {
		getDriver().findElement(By.xpath("(//mat-expansion-panel-header)[" + section + "]/following-sibling::div //div[contains(text(), '" + type + "')]")).click();
	}

	@And("KM mark option number {int} as correct answer in question section {int}")
	public void kmMarkOptionNumberAsCorrectAnswerInQuestionSection(int nb, int section) {
		getDriver().findElement(By.xpath("((//mat-expansion-panel-header)[" + section + "]/following-sibling::div //mat-radio-button)[" + (3 + nb) + "]")).click();
	}

	@And("KM save the quiz")
	public void kmSaveTheQuiz() {
		getDriver().findElement(By.xpath("//span[contains(text(), 'Save')]")).click();
	}

	@And("KM add {string} to the field {string} into question section {int}")
	public void kmAddToTheFieldIntoQuestionSection(String text, String str, int section) {
		WebElement elem = getDriver().findElement(By.xpath("(//mat-expansion-panel-header)[" + section + "]/following-sibling::div //textarea[@placeholder='" + str + "']"));
		elem.click();
		elem.sendKeys(text);
	}

	@And("KM type {string} to question title into question section {int}")
	public void kmTypeToQuestionTitleIntoQuestionSection(String text, int section) {
		WebElement elem = getDriver().findElement(By.xpath("(//mat-expansion-panel-header)[" + section + "]/following-sibling::div //textarea[@formcontrolname='question']"));
		elem.click();
		elem.sendKeys(text);
	}

	@And("KM see the list of quizzes")
	public void kmSeeTheListOfQuizzes() {
		String actual = getDriver().findElement(By.xpath("//h4")).getText();
		String expected = "List of Quizzes";
		Assert.assertEquals(actual, expected);
	}

	@And("KM click on the quiz {string}")
	public void kmClickOnTheQuiz(String name) {
		getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + name + "')]")).click();
	}

	@And("KM delete quiz {string}")
	public void kmDeleteQuiz(String name) {
		getDriver().findElement(By.xpath("//mat-expansion-panel-header //mat-panel-title[contains(text(), '"+name+"')]/parent::span/parent::mat-expansion-panel-header/following-sibling::div //span[contains(text(), 'Delete')]")).click();
	}

	@And("KM verify that quiz's {string} Create At date corresponds Update At date")
	public void kmVerifyThatQuizSCreateAtDateCorrespondsUpdateAtDate(String name) {
		WebElement expanded = getDriver().findElement(By.xpath("//mat-expansion-panel-header //mat-panel-title[contains(text(), '"+name+"')]/parent::span/parent::mat-expansion-panel-header/following-sibling::div"));
		String createdAt = expanded.findElement(By.xpath("//td[contains(text(), 'Created At:')]/following-sibling::td")).getText();
		String updatedAt = expanded.findElement(By.xpath("//td[contains(text(), 'Updated At:')]/following-sibling::td")).getText();
		assertThat(createdAt).isEqualTo(updatedAt);
	}

	@And("KM verify that quiz with name {string} is not present in the list")
	public void kmVerifyThatQuizWithNameIsNotPresentInTheList(String name) {
		int res = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(), '" + name + "')]")).size();
		assertThat(res).isLessThan(1);
	}

	@And("KM confirm delete procedure")
	public void kmConfirmDeleteProcedure() {
		getDriver().findElement(By.xpath("//ac-modal-confirmation //span[contains(text(), 'Delete')]")).click();
	}

	@Given("KM open url {string}")
	public void kmOpenUrl(String url) {
		getDriver().get(url);
	}

	@Then("KM type email {string}")
	public void kmTypeEmail(String email) {
		getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(email);
	}

	@And("KM type password {string}")
	public void kmTypePassword(String password) {
		getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(password);
	}

	@Then("KM click submit button")
	public void kmClickSubmitButton() {
		getDriver().findElement(By.xpath("//button[@type=\"submit\"]")).click();
	}

	@And("KM wait for {int} seconds")
	public void kmWaitForSeconds(int sec) throws InterruptedException {
		Thread.sleep(sec * 1000);
	}
}
