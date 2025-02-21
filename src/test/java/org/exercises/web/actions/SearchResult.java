package org.exercises.web.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.exercises.web.pageobjects.SearchResultPage.RESULTS_MAIN_PAGE;
import static org.exercises.web.pageobjects.SearchResultPage.LIST_LINKS;

public class SearchResult extends UIInteractionSteps {

    @Step("The user finds the link desired")
    public void findLinkDesired(String linkName) {
        waitFor(ExpectedConditions.presenceOfElementLocated(RESULTS_MAIN_PAGE));
        WebElementFacade linkDesired = findAll(LIST_LINKS)
                .stream()
                .filter(link -> link.getText().equalsIgnoreCase(linkName))
                .findFirst().orElseThrow();
        new Actions(getDriver()).scrollFromOrigin(
                WheelInput.ScrollOrigin.fromElement(linkDesired, 0, -50),0,300)
                .perform();
        linkDesired.click();
    }

}
