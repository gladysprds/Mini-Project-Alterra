package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.pages.OrderPage;

public class orderStep {

    OrderPage orderPage;

    @Given("i am on home page")
    public void iAmOnHomePage() {
        orderPage.openUrl();
    }

    @When("i click beli on product")
    public void iClickBeliOnProduct() {
        orderPage.clickButtonBeli();
    }

    @And("i click my cart")
    public void iClickMyCart() {
        orderPage.clickIconCart();
    }

    @Then("i get the my product based on what i choose")
    public void iGetTheMyProductBasedOnWhatIChoose() {
        orderPage.validateProduct();
    }


    @And("i click add button")
    public void iClickAddButton() {
        orderPage.clickButtonAdd();
    }


    @Then("i get the product as much as i add")
    public void iGetTheProductAsMuchAsIAdd() {
        if (orderPage.validateQtyProduct("2")){
            System.out.println("berhasil!");
        }else {
            System.out.println("gagal!");
        }
    }

    @When("i click beli more than once")
    public void iClickBeliMoreThanOnce() {
        orderPage.clickButtonBeli();
        orderPage.clickButtonBeli();
        orderPage.clickButtonBeli();
    }

    @And("i click minus button")
    public void iClickMinusButton() {
        orderPage.clickButtonMinus();
        orderPage.clickButtonMinus();
    }

    @Then("i get the product as much as i reduce")
    public void iGetTheProductAsMuchAsIReduce() {
        if (orderPage.validateQtyProduct("1")){
            System.out.println("berhasil!");
        }else {
            System.out.println("gagal!");
        }
    }


    @Then("i get empty cart alert")
    public void iGetEmptyCartAlert() {
        orderPage.errorMessageDisplayed("Order is empty!");
    }
}
