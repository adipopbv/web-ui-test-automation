package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

@DefaultUrl("https://en.wikipedia.org/wiki/Main_Page")
public class WikipediaPage extends PageObject {
    @FindBy(id = "pt-login")
    public WebElementFacade toLoginPageButton;

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

    @FindBy(id = "ca-nstab-main")
    private WebElementFacade mainPageTab;

    @FindBy(xpath = "//a[@title='Romanian']")
    private WebElementFacade romanianLanguageButton;

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
        }
        return "";
    }

    public String noAccountUsername() {
        if (noAccountElement.isCurrentlyVisible()) {
            return noAccountElement.getText();
        }
        return "";
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
        }
        return "";
    }

    public String mainPageTabText() {
        if (mainPageTab.isCurrentlyVisible()) {
            return mainPageTab.getText();
        }
        return "";
    }

    public void clickRomanianLanguageButton() {
        romanianLanguageButton.click();
    }

    public void scrollToRomanianLanguageButton(WebDriver driver) {
        try{
        new Actions(driver).moveToElement(romanianLanguageButton).click().build().perform();
        }catch (Exception ex){
            ex.getCause().printStackTrace();
        }
    }
}