package org.exercises.api.pet;

import io.restassured.response.Response;
import org.exercises.api.WebServiceEndPoints;

import static io.restassured.RestAssured.given;

public class AddPet {

    public Response withDetails(String pet) {
      return  given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(pet)
                .when()
                .post(WebServiceEndPoints.ADD_PET.getUrl());
    }
}
