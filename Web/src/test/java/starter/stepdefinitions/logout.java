package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.pages.LogOutPage;

public class logout {


    LogOutPage logOutPage;

    @When("i click icon account")
    public void iClickIconAccount() {
        logOutPage.clickIconLogOut();
    }

    @Then("i get my login page")
    public void iGetMyLoginPage() {
        logOutPage.loginFormAppeared();
    }
}
