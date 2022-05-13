package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.LoginPage;
import starter.pages.HomePage;


public class stepdefinition {

    @Steps
    LoginPage loginpage;


    @Steps
    HomePage homePage;

    @Given("i am on login page")
    public void iAmOnLoginPage() {
        loginpage.openUrl();
        loginpage.clickIconLogin();

    }

    @When("i input {string} username")
    public void iInputUsername(String username) {
        loginpage.inputUsername(username);
    }

    @And("i input {string} password")
    public void iInputPassword(String password) {
        loginpage.inputPassword(password);
    }

    @And("click login button")
    public void clickLoginButton() {
        loginpage.clickLogin();
    }

    @Then("i get the {string}")
    public void iGetThe(String result) {
        if(result.equals("home page")){
            homePage.homePageAppear();
        } else {
            loginpage.validateLoginApp();
            loginpage.displayErrorMessage(result);
        }
    }
}
