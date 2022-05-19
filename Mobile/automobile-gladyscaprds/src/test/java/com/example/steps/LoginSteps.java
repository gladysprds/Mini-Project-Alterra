package com.example.steps;

import com.example.app.pages.HomePage;
import com.example.app.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

   LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    @Given("i am on login page")
    public void iAmOnLoginPage(){
        homePage.clickIconAccount();
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
    public void clickLoginButton()throws Exception  {
        loginPage.clickButtonLogin();
        Thread.sleep(5000);
    }

    @Then("i get the {string}")
    public void iGetThe(String result) throws Exception {
        if(result.equals("home page")){
            homePage.validateHomePageAppear();
        }else if(result.equals("password null")){
            loginPage.displayErrorPasswordNull();
        }else if(result.equals("email null")){
            loginPage.displayErrorEmailNull();
        }else if(result.equals("password and email null")){
            loginPage.displayErrorBothEmailAndPassword();
        }else{
            loginPage.validateloginTextAppeared();
        }
    }
}
