package starter.comments;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.io.FileWriter;
import java.io.IOException;

import static net.serenitybdd.rest.RestRequests.given;
import static org.hamcrest.Matchers.equalTo;

public class GetProductComments {

    String base_url = "https://be-qa.alta.id/api/";


    public String getEndpoint(){
        return base_url;
    }

    public String endpointCommentsById(){
        return base_url +"products/" + 452 +"/comments";
    }

    public void requestGetCommentsById(){
        given().when().get(endpointCommentsById());
    }

    public void validateCommentById(){
        SerenityRest.then().body("data[0].'ID'", equalTo(87));
        Response response = SerenityRest.lastResponse();
        String commentById = response.body().path("data[0].'Content'");
        try (FileWriter file = new FileWriter("src//test//resources//filejson//commentById.json")) {
            file.write(commentById);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
