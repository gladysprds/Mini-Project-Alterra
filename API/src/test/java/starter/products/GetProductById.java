package starter.products;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.RestRequests.given;
import static org.hamcrest.Matchers.equalTo;

public class GetProductById {

    String base_url = "https://be-qa.alta.id/api/";
    public String getEndpoint(){
        return base_url;
    }

    public String endpointWithProductID(){
        return base_url + "products/{idProduct}";
    }

    public void requestGetProductById()throws Exception{
       Integer idProduct = Integer.valueOf(FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idProduct.json"), StandardCharsets.UTF_8));

        given().pathParam("idProduct",idProduct)
                .when().get(endpointWithProductID());
    }

    public void validateDataDetailById() throws IOException {
        Integer idProduct = Integer.valueOf(FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//idProduct.json"), StandardCharsets.UTF_8));
        SerenityRest.then().body("data.ID", equalTo(idProduct));
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
