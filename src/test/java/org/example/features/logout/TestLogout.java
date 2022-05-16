package org.example.features.logout;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/features/login/data.csv")
public class TestLogout {
    @Managed(uniqueSession = true, driver = "chrome")
    public WebDriver webdriver;

    @Steps
    public EndUserSteps user;

    String username, password;

    @Before
    public void setUp() {
        user.openHomePage();
        user.login(username, password);
    }

    @After
    public void tearDown() {
        user.logout();
    }

    @Issue("#logout")
    @Test
    public void testLogout() {
        user.logout();
    }
}