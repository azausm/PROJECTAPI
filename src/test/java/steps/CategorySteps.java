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
import org.junit.Assert;
import utilities.CashWiseToken;

public class CategorySteps {
    RequestSpecification request;
    CustomResponse customResponse = new CustomResponse();
    RequestBody requestbody = new RequestBody();
    Response response;

    @Given("user is on the base url {string}")
    public void user_is_on_the_base(String url) {
        request = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .baseUri(url);
    }

    @When("I provide the valid token authorization")
    public void i_provide_the_valid_token_authorization() {
        request = RestAssured.given().auth().oauth2(CashWiseToken.GetToken());
    }

    @When("I provide category_title with {string}")
    public void i_provide_category_title_with(String categoryTitle) {
        requestbody.setCategory_title(categoryTitle);

    }

    @When("I provide category_description with {string}")
    public void i_provide_category_description_with(String description) {
        requestbody.setCategory_description(description);
    }

    @When("I provide flag with true")
    public void i_provide_flag_with_true() {
        requestbody.setFlag(true);
    }

    @When("I hit POST endpoint {string}")
    public void i_hit_post_endpoint(String endpoint) {
        response = RestAssured.given().auth().oauth2(CashWiseToken.GetToken()).body(requestbody)
                .post(endpoint);
    }

    @Then("verify status code is {int}")
    public void verify_status_code_is(int status) {
        Assert.assertEquals(status, response.statusCode());
    }
}


