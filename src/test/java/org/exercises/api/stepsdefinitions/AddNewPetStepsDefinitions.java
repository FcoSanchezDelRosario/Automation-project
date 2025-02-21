package org.exercises.api.stepsdefinitions;

import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import org.exercises.api.pet.AddPet;
import org.exercises.api.pet.FindPet;
import org.exercises.api.pet.PetDetails;
import org.exercises.api.templates.AddNewPet;
import org.exercises.api.templates.FieldValues;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class AddNewPetStepsDefinitions {

    @Steps
    AddPet addPet;

    @Steps
    FindPet findPet;

    private  String pet;
    private  PetDetails petInfo;

    @Given("the following pets information:")
    public void theFollowingPetsInformation(@NotNull List<Map<String, String>> petDetails) {
        pet =  AddNewPet.template("templates/add_pet.json")
                .withDefaultValuesFrom(
                        FieldValues.in("templates/add_pet.properties"))
                .withFieldsFrom(petDetails.get(0));
        petInfo = new Gson().fromJson(pet, PetDetails.class);
    }

    @When("the user adds the new pets to the store")
    public void theUserAddsTheNewPetsToTheStore() {
         addPet.withDetails(pet);
    }

    @Then("the user find by id the new pet added")
    public void theUserFindByIdTheNewPetAdded() {
        Response response = findPet.byId(petInfo.getId());
        response.then().statusCode(200);
    }
}
