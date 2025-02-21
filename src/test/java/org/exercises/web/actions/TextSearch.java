package org.exercises.web.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static org.exercises.web.pageobjects.WikipediaArticle.REF_27;

public class TextSearch extends UIInteractionSteps {

    @Step("The user finds the text desired")
    public String getYearOfFirstAutomaticProcess() {
        WebElementFacade elemRef27= find(REF_27);
        new Actions(getDriver()).scrollByAmount(0,elemRef27.getRect().y).perform();
    return  elemRef27.find(By.xpath("..")).getText();
    }
}
