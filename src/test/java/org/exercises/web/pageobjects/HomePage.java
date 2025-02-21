package org.exercises.web.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://duckduckgo.com/")
public class HomePage extends PageObject {

    public static final By SEARCH_INBOX = By.id("searchbox_input");
    public static final By SEARCH_BUTTON = By.cssSelector("[aria-label='Search']");

}
