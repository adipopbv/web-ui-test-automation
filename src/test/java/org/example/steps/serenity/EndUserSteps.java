package org.example.steps.serenity;

import org.example.pages.WikipediaPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EndUserSteps {
    WikipediaPage wikipediaPage;

    @Step
    public void openHomePage() {
        wikipediaPage.open();
    }

    private void goToLoginPage() {
        wikipediaPage.goToLoginPage();
    }

    @Step
    public void enterUsername(String username) {
        wikipediaPage.enterUsername(username);
    }

    @Step
    public void enterPassword(String password) {
        wikipediaPage.enterPassword(password);
    }

    @Step
    public void clickLogin() {
        wikipediaPage.clickLogin();
    }

    @Step
    public void clickLogout() {
        wikipediaPage.clickLogout();
    }

    @Step
    public void shouldBeLoggedIn() {
        assertThat(wikipediaPage.accountUsername(), is(not("")));
    }

    @Step
    public void shouldBeLoggedOut() {
        assertThat(wikipediaPage.accountUsername(), is(""));
    }

    @Step
    public void shouldNotBeLoggedIn() {
        assertThat(wikipediaPage.accountUsername(), is(""));
    }

    @Step
    public void login(String username, String password) {
        goToLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        shouldBeLoggedIn();
    }

    @Step
    public void failedLogin(String username, String password) {
        goToLoginPage();
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        shouldNotBeLoggedIn();
    }

    @Step
    public void logout() {
        clickLogout();
        shouldBeLoggedOut();
    }
}