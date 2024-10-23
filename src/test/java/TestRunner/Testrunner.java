package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    // Provide the path to multiple feature files
    features = {
      // "Features/Login.feature", 
        "Features/PlaceOrder.feature" // Add the second feature file path here
    },
    glue = {"StepDefinations"}, // Path to the step definition package
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true // Make console output more readable
)
public class Testrunner {
}
