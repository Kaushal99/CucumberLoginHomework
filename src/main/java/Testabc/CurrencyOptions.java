package Testabc;

import org.openqa.selenium.By;

public class CurrencyOptions extends Utils
{
    LoadProp loadProp = new LoadProp();
    private By _currencyUSDollar = By.xpath("//select[@name='customerCurrency']");
    private By _currencyEuro = By.xpath("//select[@name='customerCurrency']");
    private By _euroSign = By.xpath("//*[contains(text(),'Ђ')]");


    public void verityCurrency() {
        String browser = loadProp.getProperty("browser");
        Utils.clickingElement(_currencyUSDollar);
    }


    public void verifyCurrencyEuro()
    {
        Utils.enterTextName(_currencyEuro, "Euro");
    }


    public void userShouldSeeEuroSign()
    {

        Utils.assertMessagetext(_euroSign);

    }



}
