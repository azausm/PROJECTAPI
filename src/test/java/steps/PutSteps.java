package steps;

import entities.CustomResponse;
import entities.RequestBody;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.CashWiseToken;

import static org.hamcrest.core.IsEqual.equalTo;

public class PutSteps {

    RequestSpecification request;
    CustomResponse customResponse = new CustomResponse();
    RequestBody requestbody = new RequestBody();
    Response response;


    @Given("base url {string}")
    public void base_url(String url) {
        request = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .baseUri(url);

    }
    @When("I provide {string} authorization token")
    public void i_provide_authorization_token(String string) {
        request = RestAssured.given().auth().oauth2(CashWiseToken.GetToken());
    }
    @When("I provide {string} with {string}")
    public void i_provide_with(String key, String value) {
        request.put(key, value);
        request = request.body(customResponse.toString());

    }
    @When("I hit PUT endpoint {string}")
    public void i_hit_put_endpoint(String endpoint) {
        response = RestAssured.given().auth().oauth2(CashWiseToken.GetToken()).body(requestbody)
                .put(endpoint);



    }
    @Then("verify status code is {int}")
    public void verify_status_code_is(Integer expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);

    }
    @Then("verify response body conatins {string} with {string}")
    public void verify_response_body_conatins_with(String key, String expectedValue) {
        response.then().body(key, equalTo(expectedValue));



    }
    @Then("verify request body conatins {string} with {string}")
    public void verify_request_body_conatins_with(String string, String string2) {


    }

}
