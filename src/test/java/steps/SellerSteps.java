package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import utilities.APIRunner;

import java.util.HashMap;
import java.util.Map;

public class SellerSteps {
    private static final Logger logger = LogManager.getLogger(SellerSteps.class);

    Faker faker = new Faker();

    int sellerId;
    boolean isPresent;

    @Given("user hits get single seller api with {string}")
    public void user_hits_get_single_seller_api_with(String string) {
        APIRunner.runGET(string, 5797);

        sellerId = APIRunner.getCustomResponse().getSeller_id();

        logger.info("Given step is executed: I have hit GET a single seller API" );

    }
    @Then("verify seller email is not empty")
    public void verify_seller_email_is_not_empty() {
        Assert.assertFalse(APIRunner.getCustomResponse().getEmail().isEmpty());

        logger.info("Then step is executed: I verify email is not empty");
    }



    @Given("user hits get all sellers api with {string}")
    public void user_hits_get_all_sellers_api_with(String string) {
        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 1);
        APIRunner.runGET(string,params);

        logger.info("Given step is executed: I provided valid params to hit GET all sellers ");
    }
    @Then("verify sellers id is not {int}")
    public void verify_sellers_id_is_not(Integer int1) {
        int size = APIRunner.getCustomResponse().getResponses().size();

        for (int i = 0; i < size; i ++){
            int sellerId = APIRunner.getCustomResponse().getResponses().get(i).getSeller_id();
            Assert.assertNotEquals(0, sellerId);
        }

        logger.info("Then step is executed: I verify seller id is not 0");
    }


    @Then("user hits the api with {string} to archive the seller")
    public void user_hits_the_api_with_to_archive_the_seller(String string) {
        Map <String, Object> params = new HashMap<>();
        params.put("sellersIdsForArchive", sellerId);
        params.put("archive", true);
        APIRunner.runPOST(string, params);

        logger.info("Then step is executed: I provided valid params to hit POST to archive seller");
    }
    @Then("user hits get all archived sellers api with {string}")
    public void user_hits_get_all_archived_sellers_api_with(String string) {
        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", true);
        params.put("page", 1);
        params.put("size", 1);
        APIRunner.runGET(string,params);
        int size = APIRunner.getCustomResponse().getResponses().size();
        isPresent = false;
        for (int i = 0; i<size; i++){
            int id = APIRunner.getCustomResponse().getResponses().get(i).getSeller_id();
            if (sellerId == id){
                isPresent = true;
                break;
            }
        }
        logger.info("Then step is executed: I provided valid params to hit GET all archived sellers");

    }
    @Then("user verify seller is archived")
    public void user_verify_seller_is_archived() {
        Assert.assertFalse(isPresent);
        logger.info("Then step is executed: I verify that seller is archived");


    }






}
