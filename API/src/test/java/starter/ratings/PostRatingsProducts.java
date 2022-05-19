package starter.ratings;

import net.serenitybdd.rest.SerenityRest;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.equalTo;

public class PostRatingsProducts {
    private String token;
    String base_url = "https://be-qa.alta.id/api/";

    public String getEndpoint(){
        return base_url;
    }

    public String endpointProductRatings(){
        return base_url +"products/{idProduct}" +"/ratings";
    }
    public void requestPostRatings()throws Exception{
        Integer idProduct = Integer.valueOf(FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idProduct.json"), StandardCharsets.UTF_8));
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//tokens.json"), StandardCharsets.UTF_8);
        JSONObject requestData = new JSONObject();
        requestData.put("count",3);
        SerenityRest.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .pathParam("idProduct",idProduct)
                .body(requestData.toJSONString());
                SerenityRest.when().post(endpointProductRatings());
    }

    public void validateDataDetailWithRating(){
        SerenityRest.then().body("data.Ratings", equalTo(3));
    }

    public void notGiveAnyRating()throws Exception{
        Integer idProduct = Integer.valueOf(FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idProduct.json"), StandardCharsets.UTF_8));
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//tokens.json"), StandardCharsets.UTF_8);
        JSONObject requestData = new JSONObject();
        requestData.put("count",null);
        SerenityRest.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .pathParam("idProduct",idProduct)
                .body(requestData.toJSONString());
        SerenityRest.when().post(endpointProductRatings());
    }

    public void ratingNotChanges(){
        SerenityRest.then().body("data.Ratings", equalTo(3));
    }

    public void notGiveNumber()throws Exception{
        Integer idProduct = Integer.valueOf(FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idProduct.json"), StandardCharsets.UTF_8));
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//tokens.json"), StandardCharsets.UTF_8);
        JSONObject requestData = new JSONObject();
        requestData.put("count","x");
        SerenityRest.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .pathParam("idProduct",idProduct)
                .body(requestData.toJSONString());
        SerenityRest.when().post(endpointProductRatings());
    }
    }


