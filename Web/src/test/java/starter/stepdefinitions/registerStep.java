package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.pages.LoginPage;
import starter.pages.RegisterPage;


public class registerStep {

    RegisterPage registerPage;
    LoginPage loginPage;

    @Given("i access the web")
    public void iAccessTheWeb() {
        registerPage.openUrl();
    }

    @When("i click icon account and register")
    public void iClickIconAccountAndRegister() {
        registerPage.clickIconAccount();
        registerPage.openAppregister();
    }

    @And("i input {string} my name")
    public void iInputMyName(String name) {
       registerPage.inputNama(name);
    }

    @And("i input {string} my email")
    public void iInputMyEmail(String email) {
        registerPage.inputEmail(email);
    }

    @And("i input {string} my password")
    public void iInputMyPassword(String password) {
        registerPage.inputPassword(password);

    }

    @And("i click register button")
    public void iClickRegisterButton() {
        registerPage.clickButtonRegister();
    }

    @Then("i get my {string}")
    public void iGetMy(String result) {
        if(result.equals("new user")){
            loginPage.validateLoginApp();
        } else {
            registerPage.validateRegisFormApp();
            registerPage.displayErrorMessage(result);
        }
    }



}
