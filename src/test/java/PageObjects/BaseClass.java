package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public WebDriver driver;
    
    
    public void initializeBrowser(String browser) 
    {
        switch (browser.toLowerCase()) 
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
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
        }
        
     // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait for all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
