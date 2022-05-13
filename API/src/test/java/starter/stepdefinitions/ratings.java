package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.ratings.GetProductRatings;
import starter.ratings.PostRatingsProducts;

import java.io.IOException;

public class ratings {

    @Steps
    GetProductRatings getProductRatings;

    @Steps
    PostRatingsProducts postRatingsProducts;

    @Given("I set an endpoint for ratings")
    public void iSetAnEndpointForRatings() {

        getProductRatings.endpointProductRatings();
    }

    @When("I request GET ratings of a product")
    public void iRequestGETRatingsOfAProduct() {
        getProductRatings.requestProductRatings();
    }

    @And("I get the rating of a product")
    public void iGetTheRatingOfAProduct() {
        getProductRatings.validateProductRatings();
    }

    @When("I request POST rating products")
    public void iRequestPOSTRatingProducts() throws Exception {
        postRatingsProducts.requestPostRatings();
    }

    @And("I validate the data detail with rating that just added")
    public void iValidateTheDataDetailWithRatingThatJustAdded() {
        postRatingsProducts.validateDataDetailWithRating();
    }

    @When("I request POST without give rating on products")
    public void iRequestPOSTWithoutGiveRatingOnProducts() throws Exception {
        postRatingsProducts.notGiveAnyRating();
    }

    @And("I validate the rating is not changes")
    public void iValidateTheRatingIsNotChanges() {
        postRatingsProducts.ratingNotChanges();
    }

    @When("I request POST with give any character except number")
    public void iRequestPOSTWithGiveAnyCharacterExceptNumber() throws Exception {
        postRatingsProducts.notGiveNumber();
    }
}
