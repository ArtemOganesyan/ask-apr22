package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class DariaStepDefs {
    @Given("DD open url {string}")
    public void ddOpenUrl(String url) {
        getDriver().get(url);
    }


    @Then("DD type login {string}")
    public void ddTypeLogin(String email) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(email);
    }

    @And("DD type password {string}")
    public void ddTypePassword(String password) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(password);
    }

    @Then("DD click submit button")
    public void ddClickSubmitButton() {
        getDriver().findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    @Then("DD wait for {int} seconds")
    public void ddWaitForSeconds(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);

    }

    @And("DD verify current user role set to {string}")
    public void ddVerifyCurrentUserRoleSetTo(String role) {
        String r = getDriver().findElement(By.xpath("//div[@class=\"info\"]//p")).getText();
        System.out.println(r);
        if (role.equals("TEACHER")) {
            assertThat(r).isEqualTo("TEACHER");
        } else if (role.equals("STUDENT")) {
            assertThat(r).isEqualTo("STUDENT");
        } else {
            Assert.fail("User role not found");
        }
    }

    @Then("DD click My Grade button")
    public void ddClickMyGradeButton() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'My Grades')]")).click();
    }
}