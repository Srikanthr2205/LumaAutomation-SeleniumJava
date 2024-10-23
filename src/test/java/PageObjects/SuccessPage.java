package PageObjects;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {
	
	
	WebDriver driver;
	
	public SuccessPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}

	//Elements
	
	@FindBy(xpath="//span[@class='base']")
	WebElement ThanksMsg;
	
	
	
	//Methods
	
	public void ValidateSuccessMsg() {
		
		String ExpectedMsg = "Thank you for your purchase!";
		
		String ActualMsg = ThanksMsg.getText();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ActualMsg,ExpectedMsg, "Title does not matched");
	}
}
