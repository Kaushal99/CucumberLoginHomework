package Testabc;



import cucumber.api.Scenario;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hooks extends BasePage {
    BrowserSelectors browserSelectors = new BrowserSelectors();
    static String timestamp = new SimpleDateFormat("dd.MM.yy.HH.mm.ss").format(new Date());



    @Before
    public void openBrowser() {
        browserSelectors.setUpBrowser();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
        driver.manage().window().fullscreen();
        driver.get("http://demo.nopcommerce.com");
    }

    @After
    public void closeBrowser(Scenario scenario)
            throws IOException {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(".,:;?!", "") + timestamp + ".png";
            //This takes screenshot from the driver at save it to the specified location
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //Building up the destination path for the screenshot to save
            //Also make sure to create a folder 'screenshot' with in the cucumber-report folder
            File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/extend-reports/screenshots/" + screenshotName);
            //Copy taken screenshot from source location to destination location
            scenario.write("!!!!!!!!....Scenario Failed....!!!!!!!! Please se attached screenshot for the error/issue");
            //attach the scrrenshot to our report
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        driver.close();

    }
}



