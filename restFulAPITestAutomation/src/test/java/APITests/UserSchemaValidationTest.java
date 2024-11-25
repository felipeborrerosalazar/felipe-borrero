package APITests;

import APITests.Utils.User;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class UserSchemaValidationTest {

    private static final String BASE_URI = "http://localhost:8080/api/v3";
    private static final String JSON_CONTENT_TYPE = ContentType.JSON.toString();
    private static final String USER_ENDPOINT = "/user";

    @Test(groups = {"API Users"})
    public void validateUserSchema() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Validate user schema");
        });
        RestAssured.baseURI = BASE_URI;
        given()
                .when()
                .get("/user/testUser1")
                .then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/user-schema.json"));
    }

    @Test(groups = {"API Users"})
    public void validateUserArraySchema() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Validate user array schema");
        });
        RestAssured.baseURI = BASE_URI;
        User newUser1 = new User();
        newUser1.setId(2);
        newUser1.setUsername("testUser2");
        User newUser2 = new User();
        newUser2.setId(3);
        newUser2.setUsername("testUser3");
        ArrayList<User> users = new ArrayList<>();
        users.add(newUser1);
        users.add(newUser2);

        given()
                .baseUri(BASE_URI)
                .contentType(JSON_CONTENT_TYPE)
                .body(users)
                .when()
                .post(USER_ENDPOINT + "/createWithList")
                .then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/user-array-schema.json"));
    }
}
