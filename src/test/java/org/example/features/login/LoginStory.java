package org.example.features.login;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import org.example.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/features/login/data.csv")
public class LoginStory {

    @Managed(uniqueSession = true, driver="chrome")
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    String username, password;

    @Issue("#LOGIN-date-valide")
    @Test
    public void login_with_valid_credentials() {
        user.openHomePage();
        user.login(username, password);
    }
}