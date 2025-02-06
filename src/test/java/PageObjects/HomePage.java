package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
		}
	
	
	//Elements
	
	@FindBy(xpath= "//ol//li[2]")
	WebElement product;

	
	//Methods
	
	public void SelectAnyProduct(){
		
		
		
		product.click();
	}
}





