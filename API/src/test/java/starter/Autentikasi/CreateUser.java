package starter.Autentikasi;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import utils.General;

import java.io.FileWriter;
import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;


public class CreateUser {
    General general = new General();
    String base_url = "https://be-qa.alta.id/api/";
    String email;

    public String endpointCreateUser(){
        return base_url + "auth/register";
    }

    public void requestPostUser(String fullname, String email,String password){
        JSONObject requestData = new JSONObject();
        if (email.equals("same")){
            this.email = "y";
        } else if(email.equals("detektifastr@gmail.com")){
            this.email = general.randomEmail();
            try (FileWriter file = new FileWriter("src//test//resources//filejson//email.json")) {
                file.write(this.email);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            this.email = null;
        }

        requestData.put("fullname", fullname);
        requestData.put("email", this.email);
        requestData.put("password", password);

        SerenityRest.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer" + " tokentokentokentokentoken")
                .body(requestData.toJSONString());
        SerenityRest.when().post(endpointCreateUser());
    }



    public void verifyStatusCode(int status_code){
        then().statusCode(equalTo(status_code));
    }
    public void validateDataDetail(String message){
        if (message.equals("success")){
            SerenityRest.then().body("data.Email", equalTo(this.email));
        }
    }

    public void getDataAfterCreateForOtherRequest(){
        Response response = SerenityRest.lastResponse();
        String email = response.body().path("data.Email");
        String password = response.body().path("data.Password");
        try (FileWriter file = new FileWriter("src//test//resources//filejson//registration.json")) {
            file.write(email + "\n" + password);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void errorMessageExistUser(){
        SerenityRest.then().body("error", equalTo("ERROR: duplicate key value violates unique constraint \"users_email_key\" (SQLSTATE 23505)"));
    }

    public void errorMessageRequired(String errorRequired){
        if(errorRequired.equals("fullname required")){
           then().body("error", equalTo("fullname is required"));
        }
        else if(errorRequired.equals("email required")){
            then().body("error", equalTo("email is required"));
        }
        else if(errorRequired.equals("password required")){
            then().body("error", equalTo("password is required"));
        }else{
            then().body("error", equalTo("email is required"));
        }

    }



}
