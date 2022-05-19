package starter.comments;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.RestRequests.given;
import static org.hamcrest.Matchers.equalTo;

public class GetProductComments {

    String base_url = "https://be-qa.alta.id/api/";


    public String getEndpoint(){
        return base_url;
    }

    public String endpointCommentsById(){
        return base_url +"products/{idProduct}" +"/comments";
    }

    public void requestGetCommentsById() throws IOException {
        Integer idProduct = Integer.valueOf(FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idProduct.json"), StandardCharsets.UTF_8));

        given().pathParam("idProduct",idProduct)
                .when().get(endpointCommentsById());
    }

    public void validateCommentById() throws IOException {
        Integer idCommentProduct = Integer.valueOf(FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idCommentProduct.json"), StandardCharsets.UTF_8));
        SerenityRest.then().body("data[0].'ID'", equalTo(idCommentProduct));
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
