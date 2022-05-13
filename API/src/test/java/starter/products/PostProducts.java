package starter.products;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;

public class PostProducts {

    String base_url = "https://be-qa.alta.id/api/";

    public String endpointPostProducts(){
        return base_url + "products";
    }
    public void requestDataPostProduct() throws IOException {
        JSONObject requestData = new JSONObject();
        requestData.put("name","Mesin Jahit");
        requestData.put("price",25000);
        requestData.put("categories[0]",9);
        SerenityRest.given().header("Content-Type", "application/json").body(requestData.toJSONString());
        SerenityRest.when().post(endpointPostProducts());

    }

    public void validateProductsAfterCreateProduct(){
        SerenityRest.then().body("data.Name", equalTo("Mesin Jahit"));
    }


    public void requestProductNameWithNumber() throws IOException {
        JSONObject requestData = new JSONObject();
        requestData.put("name",3);
        requestData.put("price",25000);
        requestData.put("categories[0]",9);
        SerenityRest.given().header("Content-Type", "application/json").body(requestData.toJSONString());
        SerenityRest.when().post(endpointPostProducts());

    }

    public void validateAnotherError(){
        SerenityRest.then().body("error", equalTo("json: cannot unmarshal number into Go struct field ProductCreate.name of type string"));
    }

    public void requestsProductNameWithNull()throws IOException{
        JSONObject requestData = new JSONObject();
        requestData.put("name","");
        requestData.put("price",25000);
        requestData.put("categories[0]",9);
        SerenityRest.given().header("Content-Type", "application/json").body(requestData.toJSONString());
        SerenityRest.when().post(endpointPostProducts());

    }

    public void validateNullError(){
        SerenityRest.then().body("error", equalTo("ERROR: new row for relation \"products\" violates check constraint \"products_name_check\" (SQLSTATE 23514)"));
    }


    public void requestPriceProductWithString(){
        JSONObject requestData = new JSONObject();
        requestData.put("name","Kunci inggris");
        requestData.put("price","kunci");
        requestData.put("categories[0]",9);
        SerenityRest.given().header("Content-Type", "application/json").body(requestData.toJSONString());
        SerenityRest.when().post(endpointPostProducts());

    }
    public void validatePriceError(){
        SerenityRest.then().body("error", equalTo("json: cannot unmarshal string into Go struct field ProductCreate.price of type uint"));
    }





}
