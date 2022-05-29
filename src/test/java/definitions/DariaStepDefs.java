package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.xpath.operations.Bool;
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

    @And("DD verify that graded quiz is displayed")
    public void ddVerifyThatGradedQuizIsDisplayed() {
       Boolean res = getDriver().findElement(By.xpath("//span[contains(text(),'Details')]")).isDisplayed();
       assertThat(res).isTrue();

    }


    @Then("DD see the page with grades details")
    public void ddSeeThePageWithGradesDetails() {
        getDriver().findElement(By.xpath("//mat-card[@class='header mat-card']"));
    }

    @And("DD click Details button")
    public void ddClickDetailsButton() {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
    }

    @And("DD click Close button")
    public void ddClickCloseButton() {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
    }

    @And("DD click Assignments button")
    public void ddClickAssignmentsButton() {
        getDriver().findElement(By.xpath("//a[@href='/#/assignments']")).click();
    }

    @And("DD click New Assignments button")
    public void ddClickNewAssignmentsButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Assignment')]")).getText();
    }

    @Then("DD click Select Quiz To Assign drop-down list")
    public void ddClickSelectQuizToAssignDropDownList() {
        getDriver().findElement(By.xpath("//mat-select[@aria-label='Select Quiz To Assign']")).click();
    }
}






