package Testabc;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends Utils
{
    //LoadProp loadProp = new LoadProp();
    private By _email = By.xpath("//input[@class='email']");
    private By _password = By.xpath("//input[@class='password']");
    private By _loginButton = By.xpath("//input[@value='Log in']");
    private By _assertErrorMessage = By.cssSelector("[class='message-error validation-summary-errors']");
    private By _assertEmailError = By.cssSelector("[class='field-validation-error']");
    private By _errorMessageSecond = By.cssSelector("[class='message-error validation-summary-errors']>ul>li");

    public void userOnLoginPage()
    {

        Utils.assertCurrrentURL("http://demo.nopcommerce.com/login?returnUrl=%2F");
    }
    public void userShouldNotAbleToLogin(String email,String password)
    {
        Utils.enterTextInField(_email,(email));
        Utils.enterTextInField(_password,(password));
    }


    public void userShouldClickOnLoginButton()
    {
        Utils.clickingElement(_loginButton);
    }


    public String getTextFromErrorMessage(){
        String errorMessage = driver.findElement(_errorMessageSecond).getText();
        return errorMessage;
    }

    public void assertErrorMessages(){
        Boolean isPresent = driver.findElements(_errorMessageSecond).size()>0;
        if (isPresent) {
            if (getTextFromErrorMessage().equals("No customer account found")) {
                Utils.assertTextMessage("Login was unsuccessful. Please correct the errors and try again.\nNo customer account found", _assertErrorMessage);

            } else if (getTextFromErrorMessage().equals("The credentials provided are incorrect")) {
                Utils.assertTextMessage("Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect", _assertErrorMessage);
            }
        }
        else {
            Utils.assertTextMessage("Please enter your email",_assertEmailError);
        }

    }
}
