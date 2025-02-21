package org.exercises.api.pet;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import org.exercises.api.WebServiceEndPoints;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

public class FindPet {

    private List<Map<String, Object>> soldPets = new ArrayList<>();

    @Step("Find the pet added")
    public Response byId(int petId) {
        return given()
                .when()
                .get(WebServiceEndPoints.FIND_PET.getUrl(),
                        String.valueOf(petId));
    }

    @Step("Find the sold pets")
    public List<Map<String, Object>> byStatusSold(String param1, String param2) {
        Response response;
        try {
            response = given()
                    .baseUri("https://petstore.swagger.io/v2")
                    .param(param1, param2)
                    .when()
                    .get("/pet/findByStatus");
            if (response.statusCode() == 200) {
                JsonPath jsonPath = response.jsonPath();
                soldPets = jsonPath.getList("");
            } else {
                throw new RuntimeException("Error : " + response.statusCode());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
        return soldPets;
    }

}
