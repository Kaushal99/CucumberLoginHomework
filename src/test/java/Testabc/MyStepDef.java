package Testabc;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class MyStepDef
{
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationSuccessful registrationSuccessful = new RegistrationSuccessful();
    CurrencyOptions currencyOptions = new CurrencyOptions();
    LoginPage loginPage = new LoginPage();

    @Given("^user is on register page$")
    public void user_is_on_register_page()
    {
        homePage.registrationButton();
    }

    @When("^user enters all registration details$")
    public void user_enters_all_registration_details()
    {
        registrationPage.verifyUserOnRegistrationPage();
        registrationPage.userEnterRegistrationDetails();

    }

    @Then("^user should able to register successfully$")
    public void user_should_able_to_register_successfully()
    {
        registrationSuccessful.registerSuccessfullMessage();
    }


    @Given("^user should able to click on drp down to see currency option$")
    public void userShouldAbleToClickOnDrpDownToSeeCurrencyOption()
    {
            currencyOptions.verityCurrency();
    }

    @When("^user should able to select currency US Dollar or Euro$")
    public void userShouldAbleToSelectCurrencyUSDollarOrEuro()
    {
        currencyOptions.verifyCurrencyEuro();
    }

    @Then("^user should able to see the price of product in selected currency successfully$")
    public void userShouldAbleToSeeThePriceOfProductInSelectedCurrencySuccessfully()
    {
        currencyOptions.userShouldSeeEuroSign();
    }

    @Given("^User should be on homepage$")
    public void userShouldBeOnHomepage() {

    }

    @When("^User should see \"([^\"]*)\" on homepage$")
    public void userShouldSeeOnHomepage(String categoryLinkText)
    {
       homePage.allCategoryPage(categoryLinkText);
    }

    @Then("^User should able to click on \"([^\"]*)\" successfully$")
    public void userShouldAbleToClickOnSuccessfully(String arg0)
    {


    }

    @And("^User Should see the category page displayed sucessfully$")
    public void userShouldSeeTheCategoryPageDisplayedSucessfully() {
    }


    @When("^User click on Login button$")
    public void userClickOnLoginButton()
    {
        homePage.userShouldClickOnLoginButton();
    }

    @And("^User should able to input invalid \"([^\"]*)\" and/or \"([^\"]*)\"$")
    public void userShouldAbleToInputInvalidAndOr(String email, String password)
    {
        loginPage.userShouldNotAbleToLogin(email,password);
    }

    @Then("^User should able to click LOGIN button$")
    public void userShouldAbleToClickLOGINButton()
    {
        loginPage.userShouldClickOnLoginButton();
    }

    @And("^User should able to see the \"([^\"]*)\" loggin unsucessfull$")
    public void userShouldAbleToSeeTheLogginUnsucessfull(String message)
    {
        loginPage.assertErrorMessages();
    }
}
