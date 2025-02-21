package org.exercises.api.stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetStoreNameCountStepsDefinitions {

    private List<Map<String, Object>> soldPets;

    @Given("the user has collected all the information on the pets sold")
    public void theUserHasCollectedAllTheInformationOnThePetsSold() {
        soldPets = FindPetsStepsDefinitions.soldPets;
    }

    @Then("user counts how many pets have the same name")
    public void userCountsHowManyPetsHaveTheSameName() {
        Map<String, Integer> nameCount = new HashMap<>();
        for (Map<String, Object> pet : soldPets) {
            String name = (String) pet.get("name");
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        }
        System.out.println(nameCount);
    }
}
