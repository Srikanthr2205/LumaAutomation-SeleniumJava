package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
	
	WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	
	//Elements 
	
	@FindBy(xpath="//input[@name='qty']")
	WebElement Quantity;
	
	@FindBy(xpath="//button[@title='Add to Cart']")
	WebElement AddtoCart;
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement btnCart;
	
	@FindBy(xpath="//button[@id='top-cart-btn-checkout']")
	WebElement ProceedtoCheckout;
	
	
	
	//method
	
	public String getSizeXPath(String size) {
	    // Base XPath
	    String xpath = "//div[@class=\"swatch-option text\"]";
	    
	    // Convert size to lowercase to handle case-insensitive input
	    switch (size.toLowerCase()) {
	        case "xs":
	            xpath += "[0]";  // For size XS
	            break;
	        case "s":
	            xpath += "[1]";  // For size S
	            break;
	        case "m":
	            xpath += "[2]";  // For size M
	            break;
	        case "l":
	            xpath += "[3]";  // For size L
	            break;
	        case "xl":
	            xpath += "[4]";  // For size XL
	            break;
	        default:
	            System.out.println("Invalid size selected. Please choose XS, S, M, L, or XL.");
	            break;
	    }
	    
	    // Return the final XPath
	    return xpath;
	}

	
	public void SelectSize(String size) 
	{
		
		String sizexpath = getSizeXPath(size);
		
		WebElement sizeElement = driver.findElement(By.xpath(sizexpath));
		sizeElement.click();
	}
	
	
	public String getColorxpath(String color) {
		
		
		String xpath = "//div[@class=\"swatch-option color\"]";
		
		switch(color.toLowerCase()) {
		
		case "purple" :
			xpath +="[1]";
			break;
			
		case "white" :
			xpath +="[2]";
			break;
			
		case "yellow" :
			xpath +="[3]";
			break;
			
		default:
            System.out.println("Invalid color selected. Please choose purple , white or yellow.");
            break;
		
		}
		return xpath;
	}
	
	public void SelectColor(String color) {
		
		String colorxpath = getColorxpath(color);
		
		WebElement colorElement = driver.findElement(By.xpath(colorxpath));
		colorElement.click();
		
		
	}
	
	
	public void SelectQuantity(String qty) {
		Quantity.clear();
		Quantity.sendKeys(qty);
	}
	
	
	public void AddtoCart() {
		
		AddtoCart.click();
	}
	
	
	public void cartbtn(){
		
		
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='action showcart']")));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		btnCart.click();
	}
	
	
	public void ProceedtoCheckout() {
		
		ProceedtoCheckout.click();
	}
	

	
	
	
}
