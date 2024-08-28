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

import static org.hamcrest.core.IsEqual.equalTo;

public class CategorySteps {
    RequestSpecification request;
    CustomResponse customResponse = new CustomResponse();
    RequestBody requestbody = new RequestBody();
    Response response;
<<<<<<< HEAD
    String id;
=======
    String id ;
>>>>>>> Daiyr

    @Given("user is on the base url {string}")
    public void user_is_on_the_base(String url) {

        request = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .baseUri(url);
    }

    @When("I provide the valid token authorization")
    public void i_provide_the_valid_token_authorization() {
        request = request.auth().oauth2(CashWiseToken.GetToken());
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
        response = request.body(requestbody).post(endpoint);
    }












//PUT


    @When("user provide the valid token authorization")
    public void user_provide_the_valid_token_authorization() {
        request = RestAssured.given().auth().oauth2(CashWiseToken.GetToken());


    }

<<<<<<< HEAD
=======








    //PUT


    @When("user provide the valid token authorization")
    public void user_provide_the_valid_token_authorization() {
        request = RestAssured.given().auth().oauth2(CashWiseToken.GetToken());


    }

>>>>>>> Daiyr
    @When("I provide seller name with {string}")
    public void i_provide_seller_name_with(String sellerName) {
        requestbody.setSeller_name(sellerName);



    }
    @When("I provide seller email with {string}")
    public void i_provide_seller_email_with(String sellerEmail) {
        requestbody.setEmail(sellerEmail);

    }



    @When("I hit PUT endpoint {string}")
    public void i_hit_put_endpoint(String endpoint) {
        response = request.body(requestbody).put(endpoint+id);


    }

    @Then("verify response status code should be {int}")
    public void verify_response_status_code_should_be(Integer expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);


    }
    @Then("verify response body should contain {string}")
    public void verify_response_body_should_contain(String expectedMessage) {
        response.then().body("good", equalTo(expectedMessage));


    }









    //Delete
    @Given("I have a valid authorization token")
    public void i_have_a_valid_authorization_token() {
        request = request.auth().oauth2(CashWiseToken.GetToken());

    }
    @When("I send a DELETE request to {string}\\/api\\/myaccount\\/sellers\\/{int}\"")
    public void i_send_a_delete_request_to_api_myaccount_sellers(String endpoint, Integer int1) {
        response = request.delete(endpoint + id);
        System.out.println(response.prettyPrint());
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer StatusCode) {
        response.then().statusCode(StatusCode);
    }
    @Then("the response body should contain {string}")
    public void the_response_body_should_contain(String expectedMessage) {
        response.then().body("delete", equalTo(expectedMessage));



    }




<<<<<<< HEAD


=======
>>>>>>> Daiyr
}


