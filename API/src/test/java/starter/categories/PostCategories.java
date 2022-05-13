package starter.categories;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;


public class PostCategories {

    String base_url = "https://be-qa.alta.id/api/";

    public String endpointPostCategories(){
        return base_url + "categories";
    }

    public void requestDataPostCategories() throws IOException {
        JSONObject requestData = new JSONObject();
        requestData.put("name","Alat Pancing Mania");
        SerenityRest.given().header("Content-Type", "application/json").body(requestData.toJSONString());
        SerenityRest.when().post(endpointPostCategories());

    }

    public void validateDataAfterCreateCategories(){
        SerenityRest.then().body("data.Name", equalTo("Alat Pancing Mania"));
    }

    public void requestNullNameCategories() throws IOException {
        JSONObject requestData = new JSONObject();
        requestData.put("name","");
        SerenityRest.given().header("Content-Type", "application/json").body(requestData.toJSONString());
        SerenityRest.when().post(endpointPostCategories());

    }
    public void validateErrorNullName(){
        SerenityRest.then().body("error", equalTo("ERROR: new row for relation \"categories\" violates check constraint \"categories_name_check\" (SQLSTATE 23514)"));
    }

    public void requestCategoriesNameWithNumber() throws IOException {
        JSONObject requestData = new JSONObject();
        requestData.put("name",44);
        SerenityRest.given().header("Content-Type", "application/json").body(requestData.toJSONString());
        SerenityRest.when().post(endpointPostCategories());

    }
    public void validateErrorNameWithNumber(){
        SerenityRest.then().body("error", equalTo("json: cannot unmarshal number into Go struct field CategoryCreate.name of type string"));
    }






}
