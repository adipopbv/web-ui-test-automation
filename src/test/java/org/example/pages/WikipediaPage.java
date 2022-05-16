package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://en.wikipedia.org/wiki/Main_Page")
public class WikipediaPage extends PageObject {
    @FindBy(id = "pt-login")
    private WebElementFacade toLoginPageButton;

    @FindBy(id = "pt-logout")
    private WebElementFacade logoutButton;

    @FindBy(id = "wpName1")
    private WebElementFacade usernameField;

    @FindBy(id = "wpPassword1")
    private WebElementFacade passwordField;

    @FindBy(id = "wpLoginAttempt")
    private WebElementFacade loginButton;

    @FindBy(id = "pt-userpage")
    private WebElementFacade accountElement;

    @FindBy(id = "pt-anonuserpage")
    private WebElementFacade noAccountElement;

    @FindBy(id = "searchInput")
    private WebElementFacade searchField;

    @FindBy(id = "searchButton")
    private WebElementFacade searchButton;

    @FindBy(id = "firstHeading")
    private WebElementFacade searchedPageTitle;

    @FindBy(id = "pt-preferences")
    public WebElementFacade toPreferences;

    @FindBy(id = "ooui-php-32")
    public WebElementFacade masculineButton;

    @FindBy(id = "ooui-php-31")
    public WebElementFacade feminineButton;

    @FindBy(id = "prefcontrol")
    public WebElementFacade savePreferencesButton;

    public void goToLoginPage() {
        toLoginPageButton.click();
    }

    public void enterUsername(String username) {
        usernameField.type(username);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public String accountUsername() {
        if (accountElement.isCurrentlyVisible()) {
            return accountElement.getText();
        } else {
            return "";
        }
    }

    public String noAccountUsername() {
        if (noAccountElement.isCurrentlyVisible()) {
            return noAccountElement.getText();
        } else {
            return "";
        }
    }

    public void enterSearchTerm(String searchTerm) {
        searchField.type(searchTerm);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public String searchedPageTitle() {
        if (searchedPageTitle.isCurrentlyVisible()) {
            return searchedPageTitle.getText();
        } else {
            return "";
        }
    }
}