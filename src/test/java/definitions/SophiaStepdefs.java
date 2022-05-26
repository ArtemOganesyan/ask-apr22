package definitions;

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
}
