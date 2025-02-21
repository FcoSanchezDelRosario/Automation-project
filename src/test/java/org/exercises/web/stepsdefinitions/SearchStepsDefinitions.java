package org.exercises.web.stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.exercises.web.actions.Navigate;
import org.exercises.web.actions.SearchForm;
import org.exercises.web.actions.SearchResult;
import org.exercises.web.actions.TextSearch;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchStepsDefinitions {

    @Steps
    Navigate navigateTo;

    @Steps
    SearchForm searchForm;

    @Steps
    SearchResult searchResult;

    @Steps
    TextSearch textSearch;

    @Given("^(?:.*) is on the Home Page")
    public void searchingInHomePage() {
        navigateTo.HomePage();
    }

    @When("^(?:.*) is searching by the keyword \"(.*)\"")
    public void searchingByKeyword(String key) {
        searchForm.byWord(key);
    }

    @And("find the wikipedia link result")
    public void findTheWikipediaLinkResult() {
        searchResult.findLinkDesired("Automatización - Wikipedia, la enciclopedia libre");
    }

    @Then("^(?:.*) should see in which year the first automatic process was created")
    public void shouldSeeTheYearOfTheFirstAutomaticCreationProcess() {
        assertThat(textSearch.getYearOfFirstAutomaticProcess()).containsIgnoringCase("1785");
    }
}
