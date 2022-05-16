package org.example;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.example.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class TestLogIn {

    @Managed(uniqueSession = true, driver="chrome")
    public WebDriver webdriver;

    @Test
    public void testLogIn(){
        webdriver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
        webdriver.findElement(By.id("pt-login")).click();
        webdriver.findElement(By.id("wpName1")).sendKeys("Nume");
        webdriver.findElement(By.id("wpPassword1")).sendKeys("Parola");
        webdriver.findElement(By.id("wpLoginAttempt")).click();
    }

}
