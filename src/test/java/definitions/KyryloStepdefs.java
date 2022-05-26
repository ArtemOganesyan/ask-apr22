package definitions;

import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class KyryloStepdefs {
	@And("I verify that quiz with name {string} is present in the list")
	public void iVerifyThatQuizWithNameIsPresentInTheList(String name) {
		int res = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(), '" + name + "')]")).size();
		assertThat(res).isGreaterThan(0);
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
		getDriver().findElement(By.xpath("(//mat-expansion-panel-header)[" + section + "]/following-sibling::div //div[contains(text(), '" + type + "')]")).click();
	}

	@And("I mark option number {int} as correct answer in question section {int}")
	public void iMarkOptionNumberAsCorrectAnswerInQuestionSection(int nb, int section) {
		getDriver().findElement(By.xpath("((//mat-expansion-panel-header)[" + section + "]/following-sibling::div //mat-radio-button)[" + (3 + nb) + "]")).click();
	}

	@And("I save the quiz")
	public void iSaveTheQuiz() {
		getDriver().findElement(By.xpath("//span[contains(text(), 'Save')]")).click();
	}

	@And("I add {string} to the field {string} into question section {int}")
	public void iAddToTheFieldIntoQuestionSection(String text, String str, int section) {
		WebElement elem = getDriver().findElement(By.xpath("(//mat-expansion-panel-header)[" + section + "]/following-sibling::div //textarea[@placeholder='" + str + "']"));
		elem.click();
		elem.sendKeys(text);
	}

	@And("I type {string} to question title into question section {int}")
	public void iTypeToQuestionTitleIntoQuestionSection(String text, int section) {
		WebElement elem = getDriver().findElement(By.xpath("(//mat-expansion-panel-header)[" + section + "]/following-sibling::div //textarea[@formcontrolname='question']"));
		elem.click();
		elem.sendKeys(text);
	}

	@And("I see the list of quizzes")
	public void iSeeTheListOfQuizzes() {
		String actual = getDriver().findElement(By.xpath("//h4")).getText();
		String expected = "List of Quizzes";
		Assert.assertEquals(actual, expected);
	}

	@Given("I open url {string}")
	public void iOpenUrl(String url) {
		getDriver().get(url);
	}

	@Then("I type email {string}")
	public void iTypeLogin(String email) {
		getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(email);
	}

	@And("I type password {string}")
	public void iTypePassword(String password) {
		getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(password);
	}

	@Then("I click submit button")
	public void iClickSubmitButton() {
		getDriver().findElement(By.xpath("//button[@type=\"submit\"]")).click();
	}

	@And("I verify current user role set to {string}")
	public void iVerifyCurrentUserRoleSetTo(String role) {
		String r = getDriver().findElement(By.xpath("//div[@class=\"info\"]//p")).getText();
		System.out.println(r);
		if (role.equals("STUDENT")) {
			assertThat(r).isEqualTo("STUDENT");
		} else if (role.equals("TEACHER")) {
			assertThat(r).isEqualTo("TEACHER");
		} else {
			Assert.fail("User role not found");
		}
	}

	@And("I wait for {int} seconds")
	public void iWaitForSeconds(int sec) throws InterruptedException {
		Thread.sleep(sec * 1000);
	}

	@And("I click on the quiz {string}")
	public void iClickOnTheQuiz(String name) {
		getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + name + "')]")).click();
	}

	@And("I delete quiz {string}")
	public void iDeleteQuiz(String name) {
		getDriver().findElement(By.xpath("//mat-expansion-panel-header //mat-panel-title[contains(text(), '"+name+"')]/parent::span/parent::mat-expansion-panel-header/following-sibling::div //span[contains(text(), 'Delete')]")).click();
	}

	@And("I verify that quiz's {string} Create At date corresponds Update At date")
	public void iVerifyThatQuizSCreateAtDateCorrespondsUpdateAtDate(String name) {
		WebElement expanded = getDriver().findElement(By.xpath("//mat-expansion-panel-header //mat-panel-title[contains(text(), '"+name+"')]/parent::span/parent::mat-expansion-panel-header/following-sibling::div"));
		String createdAt = expanded.findElement(By.xpath("//td[contains(text(), 'Created At:')]/following-sibling::td")).getText();
		String updatedAt = expanded.findElement(By.xpath("//td[contains(text(), 'Updated At:')]/following-sibling::td")).getText();
		assertThat(createdAt).isEqualTo(updatedAt);
	}

	@And("I verify that quiz with name {string} is not present in the list")
	public void iVerifyThatQuizWithNameIsNotPresentInTheList(String name) {
		int res = getDriver().findElements(By.xpath("//mat-panel-title[contains(text(), '" + name + "')]")).size();
		assertThat(res).isLessThan(1);
	}

	@And("I confirm delete procedure")
	public void iConfirmDeleteProcedure() {
		getDriver().findElement(By.xpath("//ac-modal-confirmation //span[contains(text(), 'Delete')]")).click();
	}
}
