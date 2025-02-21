package org.exercises.web.pageobjects;

import org.openqa.selenium.By;

public class SearchResultPage {

    public static final By RESULTS_MAIN_PAGE = By.cssSelector(".react-results--main");
    public static final By LIST_LINKS = By.cssSelector(".react-results--main li[data-layout='organic'] h2");

}
