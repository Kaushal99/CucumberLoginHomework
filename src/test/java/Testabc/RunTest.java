package Testabc;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".",tags = "@login",
        plugin ={"pretty","html:target/cucumber-reports"})
public class RunTest
{


}
