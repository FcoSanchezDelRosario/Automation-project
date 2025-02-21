package org.exercises.api.user;

import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import org.exercises.api.WebServiceEndPoints;

import static io.restassured.RestAssured.given;

public class FindUser {

    @Step("Find the new user created")
    public Response byUserName(String userName) {
        return given()
                .when()
                .get(WebServiceEndPoints.FIND_USER.getUrl(),
                        String.valueOf(userName));
    }
}
