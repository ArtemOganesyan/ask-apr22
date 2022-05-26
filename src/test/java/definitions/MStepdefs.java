package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MStepdefs {
    @Given("I open url")
    public void iOpenUrl() {
        String currentUrl = getDriver().getCurrentUrl();
        getDriver().get(currentUrl);
    }


    @Then("I type email\\string}")
    public void iTypeEmailString() {
        iTypeEmailString();
        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys();
    }

    @And("I type password")
    public void iTypePassword() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys();

    }


    @Then("I click submit butto")
    public void iClickSubmitButto() {
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }

    @And("I verify message is set to {string}")
    public void iVerifyMessageIsSetTo(String arg0) {
        String a = getDriver().findElement(By.xpath("//div[@class='cdk-visually-hidden']")).getText();
        System.out.println(a);
        if (a.equals("M Bora teacher")) {
            assertThat(a).isEqualTo("Successful login");
        } else {
            assertThat(a).isEqualTo("Authentication failed. User not found or password does not match");
        }
    }

    @Given("I open url \\{string}")
    public void iOpenUrlString() {
        String url = getDriver().getCurrentUrl();
        getDriver().get(url);
    }


    }




