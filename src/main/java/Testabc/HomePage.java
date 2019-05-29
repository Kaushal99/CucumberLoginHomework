package Testabc;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class HomePage extends Utils
{
    LoadProp loadProp = new LoadProp();
    private By _register = By.xpath("//a[@class='ico-register']");
//    private By _computer = By.linkText("Computer");
//    private By _electrnics = By.linkText("Electronics");
//    private By _apparels = By.linkText("Apparels");
//    private By _digitalDownloads = By.linkText("Digital download");
//    private By _books = By.linkText("Books");
//    private By _jewelery = By.linkText("Jewelry");
//    private By _giftCard = By.linkText("Gift Cards");

    private By _login =By.xpath("//a[@class='ico-login']");

    public void registrationButton()
    {
        Utils.clickingElement(_register);

    }

    public void allCategoryPage(String link)
    {
        Utils.clickingElement(By.linkText(link));

    }

    public void userShouldClickOnLoginButton()
    {

        Utils.clickingElement(_login);
    }

}
