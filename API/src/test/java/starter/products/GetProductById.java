package starter.products;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.io.FileWriter;
import java.io.IOException;

import static net.serenitybdd.rest.RestRequests.given;
import static org.hamcrest.Matchers.equalTo;

public class GetProductById {

    String base_url = "https://be-qa.alta.id/api/";
    public String getEndpoint(){
        return base_url;
    }

    public String endpointWithProductID(){
        return base_url + "products/" + 452;
    }

    public void requestGetProductById(){
        given().when().get(endpointWithProductID());
    }

    public void validateDataDetailById(){
        SerenityRest.then().body("data.ID", equalTo(452));
        Response response = SerenityRest.lastResponse();
        String productDetail = response.body().path("data.Name");
        try (FileWriter file = new FileWriter("src//test//resources//filejson//productDetail.json")) {
            file.write(productDetail);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String endpointWithProductIDMoreThanTotal(){
        return base_url + "products/" + 10000;
    }

    public void requestGetProductByIdMoreThanTotal(){
        given().when().get(endpointWithProductIDMoreThanTotal());
    }

    public void validateErrorMessageProduct(){
        SerenityRest.then().body("error", equalTo("record not found"));
    }
    public String endpointInputProductIDWithString(){
        return base_url + "products/" + "lol";
    }

    public void requestGetProductWithString(){
        given().when().get(endpointInputProductIDWithString());
    }
    public void validateAnotherError(){
        SerenityRest.then().body("error", equalTo("strconv.Atoi: parsing \"lol\": invalid syntax"));
    }


}
