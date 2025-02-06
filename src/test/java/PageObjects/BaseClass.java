package PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public static WebDriver driver;
    Properties properties;

    // 🔹 Constructor: Calls `loadProperties()` to load configuration settings
    public BaseClass() {
        properties = new Properties();
        loadProperties();
    }

    // 🔹 Method to load properties from `Config.properties`
    public void loadProperties() {
        try {
            File file = new File("D:\\WorkSpace - EcllipseIDE\\Selenium-Cucumber-LUMA\\src\\test\\java\\Utils\\Config.properties");
            FileInputStream fileinput = new FileInputStream(file);
            properties.load(fileinput);
            fileinput.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("❌ Failed to load configuration file.");
        }
    }

    // Method to initialize browser using the value from properties file
    public void initializeBrowser() {
        String browser = properties.getProperty("browser").toLowerCase(); // Read browser type

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser not supported. Please use Chrome, Firefox, or Edge.");
                return;
        }

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait for all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Browser Initialized: " + browser);
    }

    public void openUrl() {
        String url = properties.getProperty("url");
        if (url != null && !url.isEmpty()) {
            driver.get(url);
        } else {
            System.out.println("URL not found in properties file.");
        }
    }

    // Enhanced teardown to capture screenshots on failure and quit the driver
    public void teardown(Scenario scenario) {
        // Check if the driver is initialized before trying to quit
        if (driver != null) {
            if (scenario.isFailed()) {
                // Capture screenshot if the scenario failed
                takesScreenshot(scenario.getName());
            }
            // Quit the driver after the test
            driver.quit();
            driver = null; // Clear the driver reference
            System.out.println("Driver quit successfully.");
        } else {
            System.out.println("❌ WebDriver is null. Cannot quit.");
        }
    }


    // Method to capture a screenshot and save it with a timestamp
    public void takesScreenshot(String scenarioName) {
        try {
            // ✅ Format timestamp for unique file name
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // ✅ Convert scenario name into a valid filename (remove spaces/special chars)
            String fileName = "FailedScenario_" + scenarioName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";

            // ✅ Take screenshot using Selenium
            File screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);

            // ✅ Define screenshot save location (relative path)
            String screenshotPath = "Screenshots/" + fileName;

            // ✅ Ensure the directory exists
            File screenshotDirectory = new File("Screenshots");
            if (!screenshotDirectory.exists()) {
                screenshotDirectory.mkdir(); // Create directory if it doesn't exist
            }

            // ✅ Save screenshot to file
            FileUtils.copyFile(screenshot, new File(screenshotPath));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("❌ Failed to capture screenshot.");
        }
    }
}
