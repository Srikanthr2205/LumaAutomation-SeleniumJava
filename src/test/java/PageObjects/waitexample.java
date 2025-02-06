package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waitexample {
	
	

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.youtube.com/");
		
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		WebElement liked = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//yt-formatted-string[text()='Liked videos']")));
		
		
		
		
		
		
		
	}

}
