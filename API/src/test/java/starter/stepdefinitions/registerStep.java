package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Autentikasi.CreateUser;

public class registerStep {

    @Steps
    CreateUser createUser;

    @Given("I set an endpoint for new user")
    public void iSetAnEndpointForNewUser() {
        createUser.endpointCreateUser();
    }

    @When("I request POST user with {string} and {string} and {string}")
    public void iRequestPOSTUserWithAndAnd( String fullname, String email, String password) {
        createUser.requestPostUser(fullname,email,password);
    }


    @Then("I validate the status code {int}")
    public void iValidateTheStatusCodeStatus_code(int status_code) {
        createUser.verifyStatusCode(status_code);
    }

    @And("I validate the {string} detail after register")
    public void iValidateTheDetailAfterRegister(String message) {
        if (message.equals("success")){
            createUser.validateDataDetail(message);
        }else if(message.equals("duplicate")){
            createUser.errorMessageExistUser();
        }else{
            createUser.errorMessageRequired(message);
        }
    }

    @And("I get the data for another request")
    public void iGetTheDataForAnotherRequest() {
        createUser.getDataAfterCreateForOtherRequest();
    }







}
