package Testabc;

import org.openqa.selenium.By;

public class RegistrationSuccessful extends Utils
{
    private By _registerSuccessful = By.xpath("//div[@class='result']");
    public void registerSuccessfullMessage()
    {
        Utils.assertMessagetext(_registerSuccessful);
    }





}
