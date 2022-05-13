package starter.categories;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.io.FileWriter;
import java.io.IOException;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.then;

import static org.hamcrest.Matchers.equalTo;
public class GetAllCategories {
    String base_url = "https://be-qa.alta.id/api/";


    public String getEndpoint(){
        return base_url;
    }

    public String endpointAllCategories(){
       return base_url + "categories";
    }

    public void requestGetAllCategories(){
        given().when().get(endpointAllCategories());
    }

    public void verifyStatusCode(int statusCode){
        then().statusCode(equalTo(statusCode));
    }

    public void validateAllCategories(){
        Response response = SerenityRest.lastResponse();
        String nameCategories = response.body().path("data[0].Name");
        try (FileWriter file = new FileWriter("src//test//resources//filejson//nameCategories.json")) {
            file.write(nameCategories);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
