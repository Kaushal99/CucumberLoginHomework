package Testabc;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.apache.commons.io.FileUtils.copyFile;


public class Utils extends BasePage
{
    //switching the element to select from scroll down.
//    public void selectElementFromScrollDown(By by,String text)
//    {
//        Select dropElement = new Select(driver.findElement(by));
//        if (dropElement.isMultiple())
//        {
//            dropElement.selectByVisibleText(text);
//            return;
//        }
//
//
//get the URl to Open product
    public static void currentURL(String text)
    {driver.get(text);
    }
    //Clicking element
    public static void clickingElement(By by)
    {
        driver.findElement(by).click();
    }
    //how to enter name by selecting it
    public static void enterTextName(By by,String name)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(name);
    }
    //Clear Text form inout box/area
    public static void clearTextFormInoutBox(By by,String text)
    {
        driver.findElement(by).clear();
    }

        //send text in field
    public static void sendTextInField(By by)
    {
        driver.findElement(by).sendKeys();
    }

    //Enter text in input field
    public static void enterTextInField(By by,String text)
    {

        driver.findElement(by).sendKeys(text);
    }



    //Clear and enter text in input field
    public static void clearAndEnterTextInField(By by,String text)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }



    //Checking WebElement present in DOM
    public static void checkingWebElementPresent(By by)
    {
        if (driver.findElement(by).isDisplayed())
        {
            System.out.println("Element is Present");
        }else
        {
            System.out.println("Element is not present");
        }
    }



    //Checking WebElement displayed or not
    public static  boolean checkWebElementDisplayed(By by)
    {
        return driver.findElement(by).isDisplayed();
    }




    //Wait for fixed time given in seconds
    public static void useWaitForFixedTimeGivenInSecond(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }



    //Try to click element three times if not available in first go
    public static void clickElementThreeTimes(By by) {
        if (driver.findElement(by).isDisplayed()) {
            driver.findElement(by).click();

        } else if (driver.findElement(by).isDisplayed()) {
            driver.findElement(by).click();
        } else if (driver.findElement(by).isDisplayed()) {
            driver.findElement(by).click();
        } else {
            System.out.println("Element in not clickable");
        }
    }


    //is drop down present

    //for drop down if text is present (e.g month,text etc.)

    public static void dropDownPresent(By by,String text)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    //MOuse Hover Method to see drop  present of not

    public static void dropHoverMethod(By by)
    {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(by);
        action.moveToElement(element).perform();
    }

    //hover the element and click element to select
    public static void dropClickHover(By by)
    {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click();
        actions.perform();

    }



    //Wait for locator to be clickable for given time in seconds
    public static void clickableLocatorForSeconds(By by,int time)
    {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }




    //Wait for element to be clickable for given time in seconds
    public static void clickableElementBySeconds(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }



    ////date stamp short
    public static void shortDateStamp(int time)
    {
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHMMSS");
        Date date = new Date();
        String getCurrentDateTime = dateFormat.format(date);
        System.out.println(dateFormat.format(date));
    }
    public static String creatTimeStamp()
    {
        Date date = new Date();
        return new SimpleDateFormat("ddMMyyyyHHmmss").format(date);
    }


    //date stamp long
    public static void longDateStamp(int time)
    {
        Date date = new Date();
        System.out.println(new Timestamp(date.getTime()));

    }

    ////Wait for element for given time in second
    public static void waitForElementTime(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    //wait for element to be invisible
    public static void waitForElementInvisible(By by,int time)
    {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

    }

    // select from visible text
    public static void selectVisibleText(By by,String text)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);

    }

    //Select from visible number
    public static void selectVisibleNumber(By by,String text)
    {
        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        select.selectByVisibleText("text");

    }

    //Select from value
    public static void selectFromValue(By by,String value)
    {

        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        select.selectByValue(value);

    }

    // get selected value from dropdown
    public static void getSelectedValue(By by)
    {
        Select select = new Select(driver.findElement(by));
        WebElement element = select.getFirstSelectedOption();
        String defaultItem = element.getText();
        System.out.println(defaultItem );

    }

    //Scroll to view element
    public static void scrollViewElement(By by)
    {

        WebElement element = driver.findElement(by);
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        System.out.println(element.getText());

    }
    //Scroll to element and click
    public static void scrollElementClick(By by,String text)
    {
        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        select.selectByVisibleText("text");
        System.out.println(element.getText());


    }
    //Wait for alert to display
    public static void alertToDisplay(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());

    }
    //Get attribute of element
    public static void getElementAttribute(By by,String text)
    {
        WebElement element = driver.findElement(by);
        element.getAttribute("text");

    }

    //get css property of element
    public static void getCssPropertyElement(By by)
    {
        WebElement element = driver.findElement(by);
        String allCssProperty = element.getCssValue("text");

    }
    //take screenshot of browser
    public static void browserScreenshot(String screenshotName)
    {
        //This takes screenshot of the browser and store it tom specific location

        try {
            File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            copyFile(shot, new File("./Screenshots/"+ screenshotName+".png"));
            System.out.println("Screenshot Taken");
        }catch (IOException e)
        {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }

    //take screenshot of current display(full)
    public static void currentDisplayScreenShot() {
        try {
            // Setting your Chrome options (Desired capabilities)
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--start-fullscreen");

            // Creating a driver instance with the previous capabilities
            WebDriver driver = new ChromeDriver(options);

            // Load page & take screenshot of full-screen page
            driver.get("http://demo.nopcommerce.com/login");
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            copyFile(scrFile, new File("C:\\Programme File\\SRC"));
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

    //78343take ScreenShot
//    public static void takeScreenshot(String testname){
//    try
//    {
//        File sourcepath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File destinationPath = new File("./Screenshots/" + testname + ".png");
//        copyFile(sourcepath,destinationPath);
//    }
//    catch
//        {
//
//        }
//}
    //convert date....
    public static void converDate() throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm:ss");
        Date date = new Date();
        String getCurrentDateTime = dateFormat.format(date);
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy HH:mm:ss", Locale.ENGLISH);
        Date date1 = format.parse(getCurrentDateTime);
        System.out.println(date1);
    }
    //method to call assert



        public static String getTextFromElement(By by)
        {
            String text = driver.findElement(by).getText();
            return text;
        }

        public static void assertTextMessage(String expected, By by)
        {
        try {
            String actual = getTextFromElement(by);
            Assert.assertEquals(expected, actual);
            System.out.println("Expected Result : " + expected);
            System.out.println("Actual Result : " + actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

    //Reusable method for Assert equals where we want to know expected = actual
    public static String assertMessagetext(By by)
    {
        return driver.findElement(by).getText();
    }

    //calling Assert by URL
    public static void assertURL(String text)
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }


    public static void assertCurrrentURL(String url)
    {
        Assert.assertTrue(driver.getCurrentUrl().equals(url));
    }

    //when get text from error message and nned to assert that
//    public static void assertFromTextErrorMessage(By by)
//    {
//        public String getTextFromErrorMessage()
//    {
//        String errorMessage = driver.findElement(by).getText();
//        return errorMessage;
//    }
//
//        public void assertErrorMessages(){
//        Boolean isPresent = driver.findElements(by).size()>0;
//        if (isPresent) {
//            if (getTextFromErrorMessage().equals("No customer account found")) {
//                Utils.assertTextMessage("Login was unsuccessful. Please correct the errors and try again.\nNo customer account found", _assertErrorMessage);
//
//            } else if (getTextFromErrorMessage().equals("The credentials provided are incorrect")) {
//                Utils.assertTextMessage("Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect", _assertErrorMessage);
//            }
//        }
//        else {
//            Utils.assertTextMessage("Please enter your email",_assertEmailError);
//        }
//    }
//    }
}
