package org.exercises.web.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.JavascriptExecutor;

public class ScrollDown extends UIInteractionSteps {

    @Step("User scroll down")
    public void byPixels() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,350)", "");
    }
}
