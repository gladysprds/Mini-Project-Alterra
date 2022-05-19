package com.example.steps;

import com.example.app.pages.HomePage;
import com.example.app.pages.LoginPage;
import com.example.app.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registerStep {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    RegisterPage registerPage = new RegisterPage();

    @Given("i am on home page")
    public void iAmOnHomePage()throws Exception{
        homePage.validateHomePageAppear();
        homePage.clickIconAccount();
    }

    @When("i click icon account and register")
    public void iClickIconAccountAndRegister() throws InterruptedException {
        loginPage.validateloginTextAppeared();
        registerPage.clickRegisterLink();
    }

    @And("i input {string} my name")
    public void iInputMyName(String name) throws Exception {
        registerPage.validateRegisterFormAppeared();
        registerPage.inputFullname(name);
    }

    @And("i input {string} my email")
    public void iInputMyEmail(String email)throws Exception {
        registerPage.inputEmail(email);

    }

    @And("i input {string} my password")
    public void iInputMyPassword(String password)throws Exception{
        registerPage.inputPassword(password);
    }

    @And("i click register button")
    public void iClickRegisterButton() {
        registerPage.clickButtonRegister();

    }

    @Then("i get my {string}")
    public void iGetMy(String result) throws Exception {
        if(result.equals("new user")){
           homePage.validateHomePageAppear();
        }else if(result.equals("register page")){
            registerPage.validateRegisterFormAppeared();
        }
    }
}
