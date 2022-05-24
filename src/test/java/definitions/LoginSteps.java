/*
 * Created by Artem Oganesyan on 20.05.2022
 */

package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LoginSteps {
    @cucumber.api.java.en.Given("I open url {string}")
    public void iOpenUrl(String url) {
        getDriver().get(url);
    }

    @Then("I type login {string}")
    public void iTypeLogin(String login) {
        getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(login);
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
        Thread.sleep(sec * 2000);
    }

//    @Then("I click {string} button")
//    public void iClickButton(String arg0) {getDriver().findElement(By.xpath("//h5[contains(@text(),'My Grades')]")).click();
//    }

    @Then("I click Settings button")
    public void iClickSettingsButton() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Settings')]")).click();

    }

    @Then("I click on Change Your Name button")
    public void iClickOnChangeYourNameButton() {

        getDriver().findElement(By.xpath("//span[contains(text(),'Change Your Name')]")).click();

    }

    @And("I type New Name {string}")
    public void iTypeNewName(String newName) {

        WebElement nameField = getDriver().findElement(By.xpath("//input[@placeholder='New name']"));

        Actions a = new Actions(getDriver());

        a.moveToElement(nameField).sendKeys(Keys.BACK_SPACE).sendKeys(newName).build().perform();

    }

    @Then("I click on Change button")
    public void iClickOnChangeButton() {
        getDriver().findElement(By.xpath("//button[@type='button'][2]")).click();
    }


    @And("I verify a New Name is changed to {string}")
    public void iVerifyANewNameIsChangedTo(String nameVer) {
        String nam = getDriver().findElement(By.xpath("//tr//td[contains(text(),'David')]")).getText();
        System.out.println(nam);
        if (nameVer.equals("David")) {
            assertThat(nameVer).isEqualTo("David");
        } else {
            Assert.fail("User name is not changed");

        }

    }
}
