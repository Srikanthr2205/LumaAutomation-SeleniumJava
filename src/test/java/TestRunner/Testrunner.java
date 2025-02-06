package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
    // Provide the path to multiple feature files
    features = {
      "Features/Login.feature", 
       //"Features/PlaceOrder.feature" 
    },
    glue = {"StepDefinations"}, // Path to the step definition package
    plugin = {"pretty", "html:target/cucumber-reports.html",
    		"json:target/cucumber.json"},
    publish = true,
    monochrome = true, 
    tags = "@login1",
    dryRun = false
   
)
@Test
public class Testrunner extends AbstractTestNGCucumberTests  {
	
}
