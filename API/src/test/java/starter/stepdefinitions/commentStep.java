package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.comments.GetProductComments;
import starter.comments.PostCommentProduct;


public class commentStep {


    @Steps
    GetProductComments getProductComments;

    @Steps
    PostCommentProduct postCommentProduct;

    @Given("I set an endpoint comments")
    public void iSetAnEndpointComments() {
        getProductComments.endpointCommentsById();
    }


    @When("I request GET product comments")
    public void iRequestGETProductComments() {
        getProductComments.requestGetCommentsById();
    }

    @And("validate data detail of product comments")
    public void validateDataDetailOfProductComments() {
        getProductComments.validateCommentById();
    }

    @When("I request POST rating comments")
    public void iRequestPOSTRatingComments() throws Exception {
        postCommentProduct.requestCommentOnProduct();
    }

    @And("validate data detail after create comment")
    public void validateDataDetailAfterCreateComment() {
        postCommentProduct.validateDataDetailComments();
    }

    @When("I request POST null comments on product")
    public void iRequestPOSTNullCommentsOnProduct() throws Exception {
        postCommentProduct.requestNullComments();
    }

    @And("validate error message")
    public void validateErrorMessage() {
        postCommentProduct.validateErrorMessageComments();

    }


}
