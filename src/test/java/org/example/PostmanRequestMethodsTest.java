package org.example;


import org.example.utils.Parameter;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanRequestMethodsTest {

    private final Parameter parameters = new Parameter("email", "phone");
    private final int STATUS_SUCCESS = 200;
    public final String URL = "https://postman-echo.com";

    @Test
    public void getMethodTest() {
        given()
                .log()
                .body()
                .baseUri(URL)
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .body("args.foo1", equalTo("bar1")).
                 and()
                .body("args.foo2", equalTo("bar2"))
                .and()
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
                .statusCode(STATUS_SUCCESS);

    }

    @Test
    public void postMethodTest() {
        given()
                .log()
                .body()
                .baseUri(URL)
                .contentType("application/json")
                .body(parameters.toJson())
                .when()
                .post("/post")
                .then()
                .body("json.parameter1", equalTo(parameters.getParameter1()))
                .and()
                .body("json.parameter2", equalTo(parameters.getParameter2()))
                .and()
                .body("url", equalTo("https://postman-echo.com/post"))
                .statusCode(STATUS_SUCCESS);
    }

    @Test
    public void putMethodTest() {
        given()
                .log()
                .body()
                .baseUri(URL)
                .contentType("application/json")
                .body(parameters.toJson())
                .when()
                .put("/put")
                .then()
                .body("json.parameter1", equalTo(parameters.getParameter1()))
                .and()
                .body("json.parameter2", equalTo(parameters.getParameter2()))
                .and()
                .body("url", equalTo("https://postman-echo.com/put"))
                .statusCode(STATUS_SUCCESS);
    }

    @Test
    public void patchMethodTest() {
        given()
                .log()
                .body()
                .baseUri(URL)
                .contentType("application/json")
                .body(parameters.toJson())
                .when()
                .patch("/patch")
                .then()
                .body("json.parameter1", equalTo(parameters.getParameter1()))
                .and()
                .body("json.parameter2", equalTo(parameters.getParameter2()))
                .and()
                .body("url", equalTo("https://postman-echo.com/patch"))
                .statusCode(STATUS_SUCCESS);

    }

    @Test
    public void deleteMethodTest() {
        given()
                .log()
                .body()
                .baseUri(URL)
                .contentType("application/json")
                .body(parameters.toJson())
                .when()
                .delete("/delete")
                .then()
                .body("json.parameter1", equalTo(parameters.getParameter1()))
                .and()
                .body("json.parameter2", equalTo(parameters.getParameter2()))
                .and()
                .body("url", equalTo("https://postman-echo.com/delete"))
                .statusCode(STATUS_SUCCESS);
    }
}
