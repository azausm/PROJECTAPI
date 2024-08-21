package steps;

import entities.CustomResponse;
import entities.RequestBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.core.util.Integers;
import org.junit.Assert;
import utilities.CashWiseToken;

public class DeleteSteps {
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
    @When("I provide {string}")
    public void i_provide(String string) {
        customResponse.setSeller_id(5747);
    }
    @When("I hit DELETE endpoint {string}")
    public void i_hit_delete_endpoint(String endpoint) {
        response = RestAssured.given().auth().oauth2(CashWiseToken.GetToken()).body(requestbody)
                .delete(endpoint);
    }
    @Then("verify status code is {int}")
    public void verify_status_code_is(int status) {
        Assert.assertEquals(status, response.statusCode());

    }

}
