package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class katerinakSteps {
    @Given("I type url {string}")
    public void iTypeUrl(String url) {
        getDriver().get(url);
    }

    @Then("I type email as {string}")
    public void iTypeEmailAs(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(email);
    }

    @And("I type password as {string}")
    public void iTypePasswordAs(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(password);
    }

}
