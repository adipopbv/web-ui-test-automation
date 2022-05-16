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



    @Step
    public void enterUsername(String username) {
        wikipediaPage.enterUsername(username);
    }

    @Step
    public void enterPassword(String password) {
        wikipediaPage.enterPassword(password);
    }


    @Step
    public void shouldBeLoggedIn() {
        assertThat(wikipediaPage.accountButton, is(not("FUN-Courier-Test")));
    }

    @Step
    public void shouldBeLoggedOut() {
        assertThat(wikipediaPage.loginPage(), is(equalTo("Intra in cont")));
    }

    @Step
    public void shouldNotBeLoggedIn() {
        assertThat(wikipediaPage.errorMessage(), is(equalTo("Nume de utilizator sau parola gresita")));
    }

    @Step
    public void clickLogin() {
        wikipediaPage.login();
    }

    @Step
    public void login(String username, String password) {


        enterUsername(username);
        enterPassword(password);
        clickLogin();
        shouldBeLoggedIn();
    }
    @Step
    public void failedLogin(String email, String password, String username) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        shouldNotBeLoggedIn();
    }

    @Step
    public void acceptPopup() {
        wikipediaPage.acceptPopup();
    }

    @Step
    public void acceptPopup2() {
        wikipediaPage.acceptPopup2();
    }

    @Step
    public void go_to_add_page(){
        wikipediaPage.go_to_add_page();
    }

    @Step
    public void enter_name(String name){
        wikipediaPage.enter_name(name);
    }

    @Step
    public void select_category(){
        wikipediaPage.select_category();
    }

    @Step
    public void enter_description(String description){
        wikipediaPage.enter_description(description);
    }

    @Step
    public void enter_price(String price){
        wikipediaPage.enter_price(price);
    }

    @Step
    public void select_type_of_seller(){
        wikipediaPage.select_type_of_seller();
    }

    @Step
    public void enter_telephone(String tel){
        wikipediaPage.enter_telephone(tel);
    }

    @Step
    public void submit(){
        wikipediaPage.submit();
    }

    @Step
    public void submit2(){
        wikipediaPage.submit2();
    }

    @Step
    public void go_to_main_page(){
        wikipediaPage.go_to_main_page();
    }

    @Step
    public void accept_popups(){
        acceptPopup();
        acceptPopup2();
        acceptPopup2();
    }

    @Step
    public void add_ad(String name, String description, String tel, String price){
        go_to_add_page();
        enter_name(name);
        select_category();
        enter_description(description);
        enter_price(price);
        select_type_of_seller();
        enter_telephone(tel);
        submit();
        submit2();
        go_to_main_page();
        account();
        should_be_waiting();
    }

    @Step
    public void should_be_waiting(){
        assertThat(wikipediaPage.waitingText(),is(equalTo("În așteptare (1)")));
        assertThat(wikipediaPage.deactivateText(),is(equalTo("Dezactivate")));
    }

    @Step
    public void should_be_deactivate(){
        assertThat(wikipediaPage.waitingText(),is(equalTo("În așteptare")));
        assertThat(wikipediaPage.deactivateText(),is(equalTo("Dezactivate (1)")));
    }

    @Step
    public void deactivate() {
        wikipediaPage.deactivate();
    }

    @Step
    public void go_to_deactivated_page() {
        wikipediaPage.go_to_deactivated_page();
    }

    @Step
    public void go_to_waiting_page() {
        wikipediaPage.go_to_waiting_page();
    }

    @Step
    public void deactivate_ad() throws InterruptedException {
        go_to_waiting_page();
        deactivate();
        Thread.sleep(7000);
        go_to_deactivated_page();
        should_be_deactivate();
    }

    @Step
    public void logout(WebDriver webDriver){
        shouldBeLoggedIn();
        wikipediaPage.logout(webDriver);
        shouldBeLoggedOut();
    }
}