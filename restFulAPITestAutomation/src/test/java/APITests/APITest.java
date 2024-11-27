package APITests;

import io.qameta.allure.Allure;
import io.qameta.allure.testng.Tag;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import APITests.Utils.User;

import java.util.ArrayList;

public class APITest {

    private static final String BASE_URI = "http://localhost:8080/api/v3";
    private static final String USER_ENDPOINT = "/user";
    private static final String STORE_ENDPOINT = "/store";
    private static final String TEST_USER = "testUser1";
    private static final String JSON_CONTENT_TYPE = ContentType.JSON.toString();
    private static final String API_KEY = "5e53f31faeec73e49ac520e0b8c25c0e";
    private static final String INVALID_API_KEY = "invalid_api_key";

    @Test(groups = {"API Users"}, priority = 1)
    @Tag("Users")
    public void createUser() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Create user");
        });
        User newUser = new User();
        given()
                .baseUri(BASE_URI)
                .contentType(JSON_CONTENT_TYPE)
                .body(newUser)
                .when()
                .post(USER_ENDPOINT)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(groups = {"API Users"}, priority = 2)
    @Tag("Users")
    public void getUser() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Get user by username");
        });
        given()
                .baseUri(BASE_URI)
                .contentType(JSON_CONTENT_TYPE)
                .when()
                .get(USER_ENDPOINT + "/" + TEST_USER)
                .then()
                .statusCode(200)
                .body("username", equalTo(TEST_USER))
                .log().all();
    }

    @Test(groups = {"API Users"})
    @Tag("Users")
    public void getUserNotFound() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Get user with username not found");
        });
        given()
                .baseUri(BASE_URI)
                .contentType(JSON_CONTENT_TYPE)
                .when()
                .get(USER_ENDPOINT + "/fakeUser")
                .then()
                .statusCode(404)
                .onFailMessage("User not found")
                .log().all();
    }

    @Test(groups = {"API Users"})
    @Tag("Users")
    public void getInvalidUsername() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Get user with invalid username");
        });
        given()
                .baseUri(BASE_URI)
                .contentType(JSON_CONTENT_TYPE)
                .when()
                .get(USER_ENDPOINT + "/%@#$%^&*")
                .then()
                .statusCode(400)
                .onFailMessage("Invalid username supplied")
                .log().all();
    }

    @Test(groups = {"API Users"}, priority = 3)
    @Tag("Users")
    public void updateUser() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Update user");
        });
        User newUser = new User();
        newUser.setFirstName("updatedFirstName");
        given()
                .baseUri(BASE_URI)
                .contentType(JSON_CONTENT_TYPE)
                .body(newUser)
                .when()
                .put(USER_ENDPOINT + "/" + TEST_USER)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(groups = {"API Users"})
    @Tag("Users")
    public void deleteUser() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Delete user");
        });
        given()
                .baseUri(BASE_URI)
                .contentType(JSON_CONTENT_TYPE)
                .when()
                .delete(USER_ENDPOINT + "/" + TEST_USER)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(groups = {"API Users"})
    @Tag("Users")
    public void deleteUserNotFound() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Delete user with username not found");
        });
        given()
                .baseUri(BASE_URI)
                .contentType(JSON_CONTENT_TYPE)
                .when()
                .delete(USER_ENDPOINT + "/fakeUser")
                .then()
                .statusCode(404)
                .log().all();
    }

    @Test(groups = {"API Users"})
    @Tag("Users")
    public void createWithList() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Create list of users with given input array");
        });
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
                .statusCode(200)
                .log().all();
    }

    @Test(groups = {"API Users"})
    @Tag("Users")
    public void login() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Logs user into the system");
        });
        String body = """
                {
                  "username": "testUser1",
                  "password": "12345"
                }""";
        given()
                .baseUri(BASE_URI)
                .contentType(JSON_CONTENT_TYPE)
                .body(body)
                .when()
                .get(USER_ENDPOINT + "/login")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(groups = {"API Users"})
    @Tag("Users")
    public void loginWithInvalidBody() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Logs user into the system with invalid body");
        });
        String body = "{}";
        given()
                .baseUri(BASE_URI)
                .contentType(JSON_CONTENT_TYPE)
                .body(body)
                .when()
                .get(USER_ENDPOINT + "/login")
                .then()
                .statusCode(400)
                .onFailMessage("Invalid username/password supplied")
                .log().all();
    }

    @Test(groups = {"API Users"})
    @Tag("Users")
    public void logout() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Logs out current logged in user session");
        });
        given()
                .baseUri(BASE_URI)
                .contentType(JSON_CONTENT_TYPE)
                .when()
                .get(USER_ENDPOINT + "/logout")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(groups = {"API Store"})
    @Tag("Store")
    public void placeOrder() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Place an order for a pet");
        });
        String body = """
                {
                   "id": 10,
                   "petId": 198772,
                   "quantity": 7,
                   "shipDate": "2024-11-24T20:46:17.335Z",
                   "status": "approved",
                   "complete": true
                 }""";
        given()
                .baseUri(BASE_URI)
                .contentType(JSON_CONTENT_TYPE)
                .body(body)
                .when()
                .post(STORE_ENDPOINT + "/order")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(groups = {"API Store"})
    @Tag("Store")
    public void getStoreInventory() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Get store inventory with API key");
        });
        given()
                .baseUri(BASE_URI)
                .header("api_key", API_KEY)
                .contentType(JSON_CONTENT_TYPE)
                .when()
                .get(STORE_ENDPOINT + "/inventory")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(groups = {"API Store"})
    @Tag("Store")
    public void getStoreInventoryWithInvalidApiKey() {
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.setName("Get store inventory with invalid API key");
        });
        given()
                .baseUri(BASE_URI)
                .header("api_key", INVALID_API_KEY)
                .contentType(JSON_CONTENT_TYPE)
                .when()
                .get(STORE_ENDPOINT + "/inventory")
                .then()
                .statusCode(401) // Assuming 401 Unauthorized is returned for invalid API key
                .log().all();
    }

}