package com.example.steps;

import com.example.app.pages.HomePage;
import com.example.app.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {

    LoginPage loginPage;
    HomePage homePage;

    @Given("I have log in to application")
    public void iHaveLogInToApplication()throws Exception{
        homePage.validateHomePageAppear();
        homePage.clickIconAccount();
        loginPage.validateloginTextAppeared();
        loginPage.inputEmail("y");
        loginPage.inputPassword("y");
        homePage.validateHomePageAppear();
    }

    @When("I click logout button")
    public void iClickLogoutButton(){
        homePage.clickIconAccount();

    }

    @Then("I logged out from application")
    public void iLoggedOutFromApplication() throws Exception {
        homePage.validateHomePageAppear();
    }



}
