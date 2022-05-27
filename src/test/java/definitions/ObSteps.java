package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ObSteps {
    @Given("OB open url {string}")
    public void obOpenUrl(String url) {
        getDriver().get(url);
    }

    @Then("OB type login {string}")
    public void obTypeLogin(String Login) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(Login);
    }

    @And("OB type password {string}")
    public void obTypePassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(password);
    }

    @Then("OB click {string} button")
    public void obClickButton(String button) {
        getDriver().findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    @And("OB wait for {int} seconds")
    public void obWaitForSeconds(int sec) throws InterruptedException {
        Thread.sleep(1000);
    }

    @And("OB verify current user role set to {string}")
    public void obVerifyCurrentUserRoleSetTo(String role) {
        String r = getDriver().findElement(By.xpath("//div[@class=\"info\"]//p")).getText();
        System.out.println(r);
        if (role.equals("STUDENT")) {
            assertThat(r).isEqualTo("STUDENT");
        } else if (role.equals("TEACHER")) {
            assertThat(r).isEqualTo("TEACHER");
        } else {
            Assert.fail("User role not found");
        }

    @Then("OB type quiz title {string}")
    public void obTypeQuizTitle(String quizTitle) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-2']")).sendKeys(quizTitle);
    }
}
