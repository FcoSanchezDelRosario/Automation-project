package org.exercises.web.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

import static org.exercises.web.pageobjects.HomePage.*;

public class SearchForm extends UIInteractionSteps {

    @Step("The user searches in the browser for the desired keyword")
    public void byWord(String key) {
        find(SEARCH_INBOX).waitUntilVisible().sendKeys(key);
        find(SEARCH_BUTTON).waitUntilClickable().click();
    }
}
