package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Autentikasi.UserLogin;

public class loginStep {

    @Steps
    UserLogin userLogin;


    @Given("I set an endpoint for login")
    public void iSetAnEndpointForLogin() {
        userLogin.endpointLogin();
    }

    @When("I request POST for login with {string} and {string}")
    public void iRequestPOSTForLoginWithAnd(String email, String password) {
        userLogin.requestPostLogin(email,password);
    }



    @And("I validate the {string} detail after login")
    public void iValidateTheDetailAfterLogin(String result) {
            if (result.equals("login")){
                userLogin.validateResultOfLogin(result);
                userLogin.getToken();
            }else {
                userLogin.validateErrorMessageLogin(result);
            }
    }


}
