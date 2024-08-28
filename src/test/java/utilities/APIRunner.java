package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.CustomResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Data;
import lombok.Getter;

import java.util.Map;

@Data
public class APIRunner {

    @Getter
    private static CustomResponse customResponse;
    public static void runGET(String path, int id ){
        String token = CashWiseToken.GetToken();
        String url = Config.getProperty("cashWiseApiUrl") + path + id;

        Response response = RestAssured.given().auth().oauth2(token).get(url);
        System.out.println("status code: " + response.statusCode());

        ObjectMapper mapper = new ObjectMapper();
        try{
            customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        } catch (JsonProcessingException e) {
            System.out.println("this is a list response ");
        }
    }

    public static void runGET(String path, Map<String, Object> params){
        String token = CashWiseToken.GetToken();
        String url = Config.getProperty("cashWiseApiUrl") + path;

        Response response = RestAssured.given().auth().oauth2(token).params(params).get(url);
        System.out.println("status code: " + response.statusCode());

        ObjectMapper mapper = new ObjectMapper();
        try{
            customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        } catch (JsonProcessingException e) {
            System.out.println("this is a single response ");
        }
    }

    public static void runPOST(String path, Map<String, Object> params) {
        String token = CashWiseToken.GetToken();
        String url = Config.getProperty("cashWiseApiUrl") + path;

        Response response = RestAssured.given().auth().oauth2(token).params(params).post(url);
        System.out.println("status code: " + response.statusCode());

        ObjectMapper mapper = new ObjectMapper();
        try{
            customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        } catch (JsonProcessingException e) {
            System.out.println("this is a single response ");
        }
    }



}
