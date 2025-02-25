package org.exercises.web.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.exercises.web.pageobjects.HomePage.*;

public class SearchForm extends UIInteractionSteps {

    @Step("The user searches in the browser for the desired keyword")
    public void byWord(String key) {
        waitFor(ExpectedConditions.presenceOfElementLocated(SEARCH_INBOX));
        find(SEARCH_INBOX).waitUntilVisible().waitUntilEnabled().sendKeys(key);
        waitFor(ExpectedConditions.presenceOfElementLocated(LIST_BOX));
        findAll(SEARCH_ITEMS).stream()
                .filter(item -> item.getText().equalsIgnoreCase(key))
                .findFirst()
                .orElseThrow()
                .click();
    }


}
