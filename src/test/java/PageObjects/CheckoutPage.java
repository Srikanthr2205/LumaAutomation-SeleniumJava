package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
	
	
	//Elements
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement btnNext;
	
	@FindBy(xpath="//span[text()='Place Order']")
	WebElement btnPlaceOrder;
	
	
	//Method
	
	public void ShippingAddress()  {
		
		;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-mask")));
		    
		
		btnNext.click();
	}
	
	public void PlaceOrder() {
		
		 // Wait for the loading mask to disappear
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-mask")));
	    
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Place Order']")));
		
				   
		btnPlaceOrder.click();
	}

}
