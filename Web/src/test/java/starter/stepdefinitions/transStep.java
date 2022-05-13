package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.pages.LoginPage;
import starter.pages.OrderPage;
import starter.pages.RegisterPage;
import starter.pages.TransactionPage;


public class transStep {
    LoginPage loginPage;
    TransactionPage transactionPage;
    OrderPage orderPage;
    RegisterPage registerPage;



    @Given("i have to login first")
    public void iHaveToLoginFirst() {
        transactionPage.openUrl();
        loginPage.clickIconLogin();
        loginPage.inputUsername("y");
        loginPage.inputPassword("y");
        loginPage.clickLogin();


    }

    @When("i click beli on my product")
    public void iClickBeliOnMyProduct() {
        orderPage.clickButtonBeli();
    }

    @And("i click cart")
    public void iClickCart() {
        orderPage.clickIconCart();
    }

    @And("i click bayar button")
    public void iClickBayarButton() {
    transactionPage.clickButtonBayar();
    }

    @Then("i get my product that i pay")
    public void iGetMyProductThatIPay() {
        transactionPage.validateTransHeader();
    }


    @And("i click register link")
    public void iClickRegisterLink() {
        registerPage.openAppregister();
    }
    @Then("i am on register page")
    public void iAmOnRegisterPage() {
        registerPage.validateRegisFormApp();
    }

}
