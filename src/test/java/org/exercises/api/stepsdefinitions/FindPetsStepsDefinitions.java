package org.exercises.api.stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import org.exercises.api.pet.FindPet;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class FindPetsStepsDefinitions {

    @Steps
    FindPet findPet;

    public static List<Map<String, Object>> soldPets = new ArrayList<>();

    @When("the user searches all the pets by {string} {string}")
    public void theUserSearchesAllThePetsBy(String param1, String param2) {
        soldPets = findPet.byStatusSold(param1,param2);
    }

    @Then("the user shows the names of the sold pets")
    public void theUserShowsTheNamesOfTheSoldPets() {
        System.out.println("Pets Sold:");
        for (Map<String, Object> pet : soldPets) {
            Long id = ((Number) pet.get("id")).longValue();
            String name = (String) pet.get("name");
            System.out.printf("{id: %d, name: %s}%n", id, name);
        }
    }
}
