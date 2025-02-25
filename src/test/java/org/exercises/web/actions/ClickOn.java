package org.exercises.web.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.exercises.web.pageobjects.CookiesModal.BUTTON_ACCEPT_ALL_COOKIES;
import static org.exercises.web.pageobjects.CookiesModal.MODAL_COOKIES_INFO;


public class ClickOn  extends UIInteractionSteps {

    @Step("The user accept all cookies ")
    public void acceptAllCookies() {
        waitFor(ExpectedConditions.presenceOfElementLocated(MODAL_COOKIES_INFO));
        find(BUTTON_ACCEPT_ALL_COOKIES).waitUntilClickable().click();
    }
}
