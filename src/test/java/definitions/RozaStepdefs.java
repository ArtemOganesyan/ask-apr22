package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RozaStepdefs {
    @Given("I R open url {string}")
    public void iROpenUrl(String url) { getDriver().get(url);

    }

    @Then("I R type email {string}")
    public void iRTypeLogin(String email) { getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(email);

    }

    @And("I R type password {string}")
    public void iRTypePassword(String password) {  getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(password);

    }

    @Then("I R click submit button")
    public void iRClickSubmitButton() { getDriver().findElement(By.xpath("//button[@type=\"submit\"]")).click();

}

    @And("I R wait for {int} seconds")
    public void iRWaitForSeconds(int sec) throws InterruptedException {
        Thread.sleep(sec * 2000);

    }

    @And("I R verify current user role set to {string}")
    public void iRVerifyCurrentUserRoleSetTo(String role) { String r = getDriver().findElement(By.xpath("//div[@class=\"info\"]//p")).getText();
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

    @Then("I R click my grades button")
    public void iRClickMyGradesButton() { getDriver().findElement(By.xpath("//button[@type=\"mygrade\"]")).click();

    }
}
