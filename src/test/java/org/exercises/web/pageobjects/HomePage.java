package org.exercises.web.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://google.com/")
public class HomePage extends PageObject {

    public static final By SEARCH_INBOX = By.cssSelector("textarea[title='Buscar']");
    public static final By LIST_BOX = By.cssSelector("ul[role='listbox']");
    public static final By SEARCH_ITEMS = By.cssSelector("ul[role='listbox'] li" );

}
