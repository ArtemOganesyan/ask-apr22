package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.Objects;

import static support.TestContext.getDriver;

public class SophiaStepdefs {
    @Given("I navigate to url {string}")
    public void iNavigateToUrl(String arg0) {
        getDriver().get("http://ask-stage.portnov.com/#/login");
    }

    @And("page with title {string} is present")
    public void pageWithTitleIsPresent(String pageTitle) {
        if (pageTitle.equals("Assessment Control @ Portnov")) {
            getDriver().getTitle();
            System.out.println("Page title : " + pageTitle);
        } else {
            System.out.println("title does not match");
        }
    }
}
