package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}

	
	
	
	// Locators using @FindBy annotation for PageFactory
	
		@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
		WebElement SignInLink;
		
		@FindBy(xpath = "//input[@name='login[username]']")
		WebElement UserEmail;
		
		
		@FindBy(xpath = "//input[@name='login[password]']")
		WebElement UserPassword;
		
		
		@FindBy(xpath = "//span[text()='Sign In']")
		WebElement BtnSignin;
		
		
		@FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Srikanth Reddy!']")
		WebElement welcomemsg;
		
		
		//Methods  performed on the page.
		
		
		public void SignInPage() {
			
			SignInLink.click();
		}
		
		
		// Method to enter useremail
		public void setUserEmail(String Useremail) {
			
			UserEmail.clear();
			UserEmail.sendKeys(Useremail);
		}
		
		// Method to enter userpassword
		
		public void setUserPassword(String Userpassword) {
			
			UserPassword.clear();
			UserPassword.sendKeys(Userpassword);
			
		}
		
		
		// Method to click the signin button
		
		public void signin() {
			
			BtnSignin.click();
		}
		
		
		// Method to get the welcome message text
		
		public String getwelcomemsg() {
			
			return welcomemsg.getText();
		}
		
}
