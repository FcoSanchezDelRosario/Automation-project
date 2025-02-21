package org.exercises.api.stepsdefinitions;

import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import org.exercises.api.templates.CreateNewUser;
import org.exercises.api.templates.FieldValues;
import org.exercises.api.user.CreateUser;
import org.exercises.api.user.FindUser;
import org.exercises.api.user.UserDetails;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;


public class CreateUserStepsDefinitions {

    private String user;
    private UserDetails userInfo;
    private Response response;

    @Steps
    CreateUser createUser;

    @Steps
    FindUser findUser;


    @Given("the following user information:")
    public void theFollowingUserInformation(@NotNull List<Map<String, String>> userDetails) {
        user = CreateNewUser.template("templates/new_user.json")
                .withDefaultValuesFrom(
                        FieldValues.in("templates/new_user.properties"))
                .withFieldsFrom(userDetails.get(0));
        userInfo = new Gson().fromJson(user, UserDetails.class);
    }

    @When("the user creates his or her user in Store")
    public void theUserCreatesHisOrHerUserInStore() {
        createUser.withDetails(user);
    }

    @Then("the a new user is created")
    public void theANewUserIsCreated() {
        response = findUser.byUserName(userInfo.getUsername());
        response.then().statusCode(200);
    }

    @And("the new user created should include the following details:")
    public void theNewUserCreatedShouldIncludeTheFollowingDetails(@NotNull List<String> detail) {
        String username = response.jsonPath().getString("username");
        String firstName = response.jsonPath().getString("firstName");
        String lastName = response.jsonPath().getString("lastName");

        assertThat(username).isEqualToIgnoringCase(detail.get(0));
        assertThat(firstName).isEqualToIgnoringCase(detail.get(1));
        assertThat(lastName).isEqualToIgnoringCase(detail.get(2));
    }
}
