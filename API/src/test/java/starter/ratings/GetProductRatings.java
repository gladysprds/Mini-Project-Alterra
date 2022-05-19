package starter.ratings;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.RestRequests.given;
import static org.hamcrest.Matchers.equalTo;

public class GetProductRatings {

    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpoint(){
        return base_url;
    }

    public String endpointProductRatings(){
        return base_url +"products/{idProduct}" +"/ratings";
    }

    public void requestProductRatings() throws IOException {
        Integer idProduct = Integer.valueOf(FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idProduct.json"), StandardCharsets.UTF_8));

        given().pathParam("idProduct",idProduct).
                when().get(endpointProductRatings());
    }

    public void validateProductRatings() throws IOException {

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
