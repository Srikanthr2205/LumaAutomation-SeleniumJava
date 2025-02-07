package StepDefinations;


import Utils.ExtentManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import PageObjects.BaseClass;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Hooks {
	
	private static ExtentReports extent = ExtentManager.getInstance();
    private static ExtentTest test;
    BaseClass base = new BaseClass(); // Load properties

    @Before
    public void setup(Scenario scenario) {
        System.out.println("Running @Before Hook: Initializing Browser and Opening URL");
        base.initializeBrowser();
        base.openUrl();
        
     // Create a test case in Extent Report
        test = extent.createTest(scenario.getName());
        
    }

    @After
    public void teardown(Scenario scenario) {
        System.out.println("Running @After Hook: Closing Browser");
        
        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Test Failed: " + scenario.getName());

            // Capture Screenshot
            File screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "target/ExtentReports/screenshots/" + scenario.getName().replaceAll(" ", "_") + ".png";
            
            try {
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                test.addScreenCaptureFromPath(screenshotPath); // Attach screenshot to report
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            test.log(Status.PASS, "Test Passed: " + scenario.getName());
        }

        base.teardown(scenario); // ✅ Calls teardown from BaseClass
        
        extent.flush(); // Save Extent Report
    }
}
