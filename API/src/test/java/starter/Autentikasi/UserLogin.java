package starter.Autentikasi;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;

public class UserLogin {
    String email;
    String base_url = "https://be-qa.alta.id/api/";
    public String endpointLogin(){
        return base_url +"auth/login";
    }

    public void requestPostLogin(String email, String password){
        JSONObject requestData = new JSONObject();
            requestData.put("email", email);
            requestData.put("password", password);

        SerenityRest.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer" + " tokentokentokentokentoken")
                .body(requestData.toJSONString());
        SerenityRest.when().post(endpointLogin());
    }
    public void validateResultOfLogin(String loginresult){
        if(loginresult.equals("login")){
            Response response = SerenityRest.lastResponse();
            String token = response.body().path("data");
        }
    }

    public void validateErrorMessageLogin(String hasil){
        if(hasil.equals("password null")){
            then().body("error", equalTo("password is required"));
        }else if(hasil.equals("email null")){
            then().body("error", equalTo("email is required"));
        }else if(hasil.equals("null")){
            then().body("error", equalTo("email is required"));
        }else if(hasil.equals("invalid password")){
            then().body("error", equalTo("email or password is invalid"));
        }else if(hasil.equals("invalid email")){
            then().body("error", equalTo("record not found"));
        }else if(hasil.equals("invalid password and email")){
            then().body("error", equalTo("record not found"));
        }
    }

    public void getToken(){
        Response response = SerenityRest.lastResponse();
        String token = response.body().path("data");
        try (FileWriter file = new FileWriter("src//test//resources//filejson//tokens.json")) {
            file.write(token);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

