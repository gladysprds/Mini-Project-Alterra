package starter.ratings;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static net.serenitybdd.rest.RestRequests.given;
import static org.hamcrest.Matchers.equalTo;

public class GetProductRatings {

    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpoint(){
        return base_url;
    }

    public String endpointProductRatings(){
        return base_url +"products/" + 452 +"/ratings";
    }

    public void requestProductRatings(){
        given().when().get(endpointProductRatings());
    }

    public void validateProductRatings(){

        Response response = SerenityRest.lastResponse();
        Integer ratingsProduct = response.body().path("data");
        try (FileWriter file = new FileWriter("src//test//resources//filejson//ratingProduct.json")) {
            file.write("rating: "+ ratingsProduct);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
