package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.categories.GetAllCategories;
import starter.categories.PostCategories;

import java.io.IOException;

public class categoriesStep {

    @Steps
    GetAllCategories getAllCategories;

    @Steps
    PostCategories postCategories;

    @Given("I set an endpoint")
    public void iSetAnEndpoint() {
        getAllCategories.getEndpoint();
    }

    @When("I request GET all categories")
    public void iRequestGETAllCategories() {
        getAllCategories.requestGetAllCategories();
    }

    @Then("I validate the status code is {int}")
    public void iValidateTheStatusCodeIs(int statusCode) {
        getAllCategories.verifyStatusCode(statusCode);
    }


    @And("validate data detail all categories")
    public void validateDataDetailAllCategories() {
        getAllCategories.validateAllCategories();
    }


    @When("I request POST Categories")
    public void iRequestPOSTCategories() throws IOException {
        postCategories.requestDataPostCategories();
    }

    @And("I validate the categories that just added is displayed")
    public void iValidateTheCategoriesThatJustAddedIsDisplayed() {
        postCategories.validateDataAfterCreateCategories();
    }

    @When("I request POST categories with null name")
    public void iRequestPOSTCategoriesWithNullName() throws IOException {
        postCategories.requestNullNameCategories();
    }

    @And("I validate the error message with null name is displayed")
    public void iValidateTheErrorMessageWithNullNameIsDisplayed() {
        postCategories.validateErrorNullName();
    }

    @When("I request POST categories name with number")
    public void iRequestPOSTCategoriesNameWithNumber() throws IOException {
        postCategories.requestCategoriesNameWithNumber();
    }

    @And("I validate error message with Name number")
    public void iValidateErrorMessageWithNameNumber() {
        postCategories.validateErrorNameWithNumber();
    }
}
