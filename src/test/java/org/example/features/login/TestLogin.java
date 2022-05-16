package org.example.features.login;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import org.example.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/features/login/data.csv")
public class TestLogin {
    @Managed(uniqueSession = true, driver="chrome")
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    String username, password, badPassword;

    @Before
    public void setUp() {
        user.openHomePage();
    }

    @After
    public void tearDown() {
        user.logout();
    }

    @Issue("#invalid-login")
    @Test
    public void testInvalidLogin() {
        user.failedLogin(username, badPassword);
    }

    @Issue("#valid-login")
    @Test
    public void testValidLogin() {
        user.login(username, password);
    }

}