package org.example.pages;

        import net.thucydides.core.annotations.DefaultUrl;
        import org.openqa.selenium.By;
        import net.serenitybdd.core.pages.WebElementFacade;

        import net.serenitybdd.core.annotations.findby.FindBy;

        import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://en.wikipedia.org/wiki/Main_Page")
public class WikipediaPage extends PageObject {
    @FindBy(id="pt-login")
    private WebElementFacade toLoginPageButton;

    @FindBy(id="pt-logout")
    private WebElementFacade logoutButton;

    @FindBy(id="wpName1")
    private WebElementFacade usernameField;

    @FindBy(id="wpPassword1")
    private WebElementFacade passwordField;

    @FindBy(id="wpLoginAttempt")
    private WebElementFacade loginButton;

    @FindBy(id="pt-userpage")
    public WebElementFacade accountElement;

    @FindBy(id="pt-anonuserpage")
    public WebElementFacade noAccountElement;

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

    /*public void logout(WebDriver webDriver) {
        Actions actions = new Actions(webDriver);
        WebElement mainMenu = webDriver.findElement(By.className("css-zs6l2q"));
        actions.moveToElement(mainMenu).build().perform();

        find(By.linkText("Iesire din cont")).click();
    }



    public String errorMessage(){return errorBox.findElement(By.xpath(".//p")).getText();}

    public String loginPage(){return find(By.xpath("//*[@id=\"login_tab\"]")).getText();}

    public String waitingText() {
        return find(By.cssSelector("[data-testid='select-WAITING']")).getAttribute("innerText");
    }

    public String deactivateText() {
        return find(By.cssSelector("[data-testid='select-FINISHED']")).getAttribute("innerText");
    }

    public void go_to_deactivated_page(){
        find(By.cssSelector("[data-testid='select-FINISHED']")).click();
    }

    public void go_to_waiting_page(){
        find(By.cssSelector("[data-testid='select-WAITING']")).click();
    }

    public void deactivate() {
        find(By.className("css-7gl518")).click();
        find(By.cssSelector("[aria-label='Dezactivează']")).click();
    }

    public void go_to_add_page(){
        addAdButton.click();
    }

    public void enter_name(String name){
        nameField.click();
        nameField.find(By.cssSelector("[data-testid='posting-title']")).type(name);
    }

    public void select_category(){
        categoryButton.click();
        find(By.className("css-702hrz"))
                .find(By.cssSelector("[data-cy='posting-suggested-categories-item']")).click();
    }

    public void enter_description(String description){
        descriptionField.click();
        descriptionField.find(By.cssSelector("[data-testid='posting-description-text-area']")).type(description);;
    }

    public void enter_price(String price){
        priceField.click();
        priceField.find(By.cssSelector("[data-testid='price-input']")).type(price);
    }

    public void select_type_of_seller(){
        typeOfSellerSelector.find(By.cssSelector("[data-testid='private_business_private_unactive']")).click();
    }

    public void enter_telephone(String tel){
        telephoneField.type(tel);
    }

    public void submit(){
        submitButton.click();
    }

    public void submit2(){
        submitButton2.click();
    }
*/
    //public void go_to_main_page(){
    //    mainPageButton.click();
    //}
}