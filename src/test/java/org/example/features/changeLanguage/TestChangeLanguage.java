package org.example.features.changeLanguage;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/features/login/data.csv")
public class TestChangeLanguage {
    @Managed(uniqueSession = true, driver = "chrome")
    public WebDriver webdriver;
    public String username;

    @Steps
    public EndUserSteps user;

    @Before
    public void setUp() {
        user.openHomePage();
    }

    @Issue("#change-language")
    @Test
    public void testChangeLanguage() {
        user.changeLanguageToRomanian(webdriver);
    }
}