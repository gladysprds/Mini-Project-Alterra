package starter.comments;

import net.serenitybdd.rest.SerenityRest;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.RestRequests.given;
import static org.hamcrest.Matchers.equalTo;

public class PostCommentProduct {
    String token;
    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpoint(){
        return base_url;
    }

    public String endpointCommentsById(){
        return base_url +"products/{idProduct}"+"/comments";
    }

    public void requestCommentOnProduct()throws Exception{
        Integer idProduct = Integer.valueOf(FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idProduct.json"), StandardCharsets.UTF_8));
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//tokens.json"), StandardCharsets.UTF_8);
        JSONObject requestData = new JSONObject();
        requestData.put("content","cukaaak banged!");
        SerenityRest.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .pathParam("idProduct",idProduct)
                .body(requestData.toJSONString());
        SerenityRest.when().post(endpointCommentsById());
    }

    public void validateDataDetailComments(){
        SerenityRest.then().body("data.Content", equalTo("cukaaak banged!"));
    }

    public void requestNullComments()throws Exception{
        Integer idProduct = Integer.valueOf(FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idProduct.json"), StandardCharsets.UTF_8));
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//tokens.json"), StandardCharsets.UTF_8);
        JSONObject requestData = new JSONObject();
        requestData.put("content","");
        SerenityRest.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .pathParam("idProduct",idProduct)
                .body(requestData.toJSONString());
        SerenityRest.when().post(endpointCommentsById());
    }

    public void validateErrorMessageComments(){
        SerenityRest.then().body("error", equalTo("ERROR: new row for relation \"comments\" violates check constraint \"comments_content_check\" (SQLSTATE 23514)"));
    }





}
