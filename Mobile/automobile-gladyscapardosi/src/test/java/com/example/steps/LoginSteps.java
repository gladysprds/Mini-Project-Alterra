package com.example.steps;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.com.example.app.pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("i am on login page")
    public void iAmOnLoginPage(){
        loginPage.clickIconAccount();
        loginPage.validateloginTextAppeared();
    }

    @When("i input {string} username")
    public void iInputUsername(String email) throws Exception {

        loginPage.inputEmail(email);
    }

    @And("i input {string} password")
    public void iInputPassword(String password) throws Exception {

        loginPage.inputPassword(password);
    }

    @And("click login button")
    public void clickLoginButton() {
        loginPage.clickButtonLogin();
    }

    @Then("i get the {string}")
    public void iGetThe(String result) {
        if(result.equals("home page")){
            loginPage.validateHomePageAppear();
        }else{
            loginPage.validateloginTextAppeared();
        }
    }
}