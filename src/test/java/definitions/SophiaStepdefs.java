//package definitions;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import org.openqa.selenium.By;
//
//import java.util.Objects;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static support.TestContext.getDriver;
//
//public class SophiaStepdefs {
//    @Given("I navigate to url {string}")
//    public void iNavigateToUrl(String arg0) {
//        getDriver().get("http://ask-stage.portnov.com/#/login");
//    }
//
//    @And("page with title {string} is present")
//    public void pageWithTitleIsPresent(String pageTitle) {
//        if (pageTitle.equals("Assessment Control @ Portnov")) {
//            getDriver().getTitle();
//            System.out.println("Page title : " + pageTitle);
//        } else {
//            System.out.println("title does not match");
//        }
//    }
//
//    @Then("element with xpath {string} should be present")
//    public void elementWithXpathShouldBePresent(String xpath) {
//        assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isTrue();
//    }
//
//    @Then("I type login {string}")
//    public void iTypeLogin(String login) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(login);
//    }
//
//    @And("I type password {string}")
//    public void iTypePassword(String password) {
//        getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
//    }
//}
