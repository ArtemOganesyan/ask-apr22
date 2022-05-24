/*
 * Created by Artem Oganesyan on 20.05.2022
 */

package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LoginSteps {
    @cucumber.api.java.en.Given("I open url {string}")
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
        }
        else if (role.equals("TEACHER")) {
            assertThat(r).isEqualTo("TEACHER");
        } else {
            Assert.fail("User role not found");
        }
    }

    @And("I wait for {int} seconds")
    public void iWaitForSeconds(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }
}
