package org.exercises.api.user;

import net.serenitybdd.annotations.Step;
import org.exercises.api.WebServiceEndPoints;

import static io.restassured.RestAssured.given;

public class CreateUser  {

    @Step("Create a New User in the store")
    public void withDetails(String user) {
        given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post(WebServiceEndPoints.CREATE_USER.getUrl())
                .then().statusCode(200);
    }
}
