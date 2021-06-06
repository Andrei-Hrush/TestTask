package TestsAPI;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import configs.Configs;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestsAPI {
    private final Configs configs = new Configs();

    @Test
    public void registration() {
        RestAssured.baseURI  = configs.getProperty("baseUrl");
        RestAssured.basePath = configs.getProperty("basePath");
        Response response = given()
                .contentType(configs.getProperty("contentType"))
                .body(configs.getProperty("bodyForSuccessRegistration"))
                .when()
                .post(configs.getProperty("registrationPath"));
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getBody().asString(),"{\"id\":4,\"token\":\"QpwL5tke4Pnpja7X4\"}");
    }

    @Test
    public void registrationWithoutPassword() {
        RestAssured.baseURI  = configs.getProperty("baseUrl");
        RestAssured.basePath = configs.getProperty("basePath");
        Response response = given()
                .contentType(configs.getProperty("contentType"))
                .body(configs.getProperty("bodyForFailedRegistration"))
                .when()
                .post(configs.getProperty("registrationPath"));
        Assert.assertEquals(response.getStatusCode(),400);
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 400 Bad Request");
    }

    @Test
    public void getListOfUsers() {
        RestAssured.baseURI  = configs.getProperty("baseUrl");
        RestAssured.basePath = configs.getProperty("basePath");
        Response response = given()
                .contentType(configs.getProperty("contentType"))
                .when()
                .get(configs.getProperty("usersPath"));
        String body = response.getBody().asString();
        JsonObject jsonObject = JsonParser.parseString(body).getAsJsonObject();
        JsonArray test = jsonObject.get(configs.getProperty("getByData")).getAsJsonArray();
        Assert.assertEquals(test.size(), 6);
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
