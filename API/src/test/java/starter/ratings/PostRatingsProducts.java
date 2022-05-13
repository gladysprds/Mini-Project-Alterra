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
        return base_url +"products/" + 452 +"/ratings";
    }
    public void requestPostRatings()throws Exception{
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//tokens.json"), StandardCharsets.UTF_8);
        JSONObject requestData = new JSONObject();
        requestData.put("count",3);
        SerenityRest.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestData.toJSONString());
                SerenityRest.when().post(endpointProductRatings());
    }

    public void validateDataDetailWithRating(){
        SerenityRest.then().body("data.ID", equalTo(452));
    }

    public void notGiveAnyRating()throws Exception{
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//tokens.json"), StandardCharsets.UTF_8);
        JSONObject requestData = new JSONObject();
        requestData.put("count",null);
        SerenityRest.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestData.toJSONString());
        SerenityRest.when().post(endpointProductRatings());
    }

    public void ratingNotChanges(){
        SerenityRest.then().body("data.Ratings", equalTo(3));
    }

    public void notGiveNumber()throws Exception{
        token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//tokens.json"), StandardCharsets.UTF_8);
        JSONObject requestData = new JSONObject();
        requestData.put("count","x");
        SerenityRest.given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestData.toJSONString());
        SerenityRest.when().post(endpointProductRatings());
    }
    }


