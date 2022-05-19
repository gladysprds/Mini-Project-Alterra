package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.products.GetAllProducts;
import starter.products.GetProductById;
import starter.products.PostProducts;

import java.io.IOException;




public class productStep {


    @Steps
    GetAllProducts getAllProducts;


    @Steps
    PostProducts postProducts;

    @Steps
    GetProductById getProductById;

    @Given("I set an endpoint products")
    public void iSetAnEndpointProducts() {
        getAllProducts.getEndpoint();
    }

    @When("I request GET all products")
    public void iRequestGETAllProducts() {
        getAllProducts.endpointAllProducts();
        getAllProducts.requestGetAllProducts();
    }


    @And("validate data detail all products")
    public void validateDataDetailAllProducts() {
        getAllProducts.validateAllProducts();
    }

    @When("I request POST products")
    public void iRequestPOSTProducts() throws IOException {
        postProducts.requestDataPostProduct();
    }

    @And("I validate the products that just added is displayed")
    public void iValidateTheProductsThatJustAddedIsDisplayed() {
        postProducts.validateProductsAfterCreateProduct();
    }

    @When("I request GET products by ID")
    public void iRequestGETProductsByID() throws Exception {
        getProductById.requestGetProductById();
    }

    @Then("i validate data of a product")
    public void iValidateDataOfAProduct() throws IOException {
        getProductById.validateDataDetailById();
    }



    @Given("I set an endpoint products with ID more than total")
    public void iSetAnEndpointProductsWithIDMoreThanTotal() {
        getProductById.endpointWithProductIDMoreThanTotal();
    }


    @When("I request GET products by ID more than the total")
    public void iRequestGETProductsByIDMoreThanTheTotal() {
        getProductById.requestGetProductByIdMoreThanTotal();
    }

    @And("i validate the error messages of product")
    public void iValidateTheErrorMessagesOfProduct() {
        getProductById.validateErrorMessageProduct();
    }

    @When("I request GET products with string")
    public void iRequestGETProductsWithString() {
        getProductById.requestGetProductWithString();
    }

    @And("i validate another error message of product")
    public void iValidateAnotherErrorMessageOfProduct() {
        getProductById.validateAnotherError();
    }

    @When("I request POST products name with number")
    public void iRequestPOSTProductsNameWithNumber() throws IOException {

        postProducts.requestProductNameWithNumber();
    }

    @And("I validate the error message post product name with number")
    public void iValidateTheErrorMessagePostProductNameWithNumber() {
        postProducts.validateAnotherError();
    }

    @When("I request POST products name with Null")
    public void iRequestPOSTProductsNameWithNull() throws IOException{
        postProducts.requestsProductNameWithNull();
    }

    @And("I validate the error message post product name with Null")
    public void iValidateTheErrorMessagePostProductNameWithNull() {
        postProducts.validateNullError();
    }

    @When("I request POST products price with String")
    public void iRequestPOSTProductsPriceWithString() {
        postProducts.requestPriceProductWithString();
    }

    @And("I validate the error message product price with string")
    public void iValidateTheErrorMessageProductPriceWithString() {
        postProducts.validatePriceError();
    }
}
