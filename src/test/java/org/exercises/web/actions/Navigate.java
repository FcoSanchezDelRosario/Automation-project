package org.exercises.web.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.exercises.web.pageobjects.HomePage;

public class Navigate extends UIInteractionSteps {

    HomePage HomePage;

    @Step("User open Home Page")
    public void HomePage() {
        HomePage.open();
    }


}
