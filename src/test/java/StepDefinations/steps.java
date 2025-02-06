package StepDefinations;

import java.time.Duration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import PageObjects.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import PageObjects.CheckoutPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProductDetailsPage;
import PageObjects.SuccessPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class steps extends PageObjects.BaseClass{

    
    public LoginPage lp;
    public HomePage hp;
    public ProductDetailsPage pd;
    public CheckoutPage cp;
    public SuccessPage sp;
     
    
    @Given("the user clicks on the Sign In button")
    public void the_user_clicks_on_the_sign_in_button() 
    {
    	lp = new LoginPage(driver);
        lp.SignInPage();  			       // Navigate to the sign-in page    
    }
   
    
    @Then("the user should be redirected to the {string} page")
    public void the_user_should_be_redirected_to_the_page(String expectedTitle) {
        String actualTitle = driver.getTitle(); 														// Get the current page title
        Assert.assertEquals(actualTitle, expectedTitle, "Test Failed: Page title does not match!"); 	 // Assert to verify expected and actual page titles
    }
    
    
    
    @When("the user enters the email as {string}")
    public void the_user_enters_the_email_as(String email) {
    	lp.setUserEmail(email);
    }
    
    
    @When("the user enters the password as {string}")
    public void the_user_enters_the_password_as(String password) {
    	 lp.setUserPassword(password);
    }
    
    @When("the user clicks on the below Sign-In button")
    public void the_user_clicks_on_the_below_sign_in_button() {
    	lp.signin();
    }



    @Then("the welcome message {string} should be displayed")
    public void the_welcome_message_should_be_displayed(String ExpMessage)  {
        
    
    	String ActualMessage = lp.getwelcomemsg();
    	
    	Assert.assertEquals(ActualMessage,ExpMessage , "Welcome message mismatch!");
    	
    }

    
    
    //==================  Step to select a product from the Hotsellers list ============================

    
    
    @Given("the user selects a product from the Hot Sellers section")
    public void the_user_selects_a_product_from_the_hot_sellers_section() {
    	hp = new HomePage(driver);
        hp.SelectAnyProduct();
    	
    }

    // Step to select size, color, and quantity
        
        @Given("the user chooses size {string}, color {string}, and quantity {string}")
        public void the_user_chooses_size_color_and_quantity(String size, String color, String qty) {
        	pd = new ProductDetailsPage(driver);
            pd.SelectSize(size);  // Select product size
            pd.SelectColor(color);  // Select product color
            pd.SelectQuantity(qty);  // Select product quantity     
            
        }
   
            
        @When("the user adds the product to the cart")
        public void the_user_adds_the_product_to_the_cart() {
        	pd.AddtoCart();  // Add product to the cart
            pd.cartbtn();  // Click on the cart button
        }
        
   
        @When("proceeds to checkout")
        public void proceeds_to_checkout() {
        	 pd.ProceedtoCheckout();  // Proceed to checkout
        }
        

        @When("enters valid shipping and payment details")
        public void enters_valid_shipping_and_payment_details() {
        	cp = new CheckoutPage(driver);
            cp.ShippingAddress();  // Enter shipping details
        }
        

        @When("places the order")
        public void places_the_order() {
        	cp.PlaceOrder();  // Place the order
        }
        
        

        @Then("the order should be placed successfully, and an order confirmation message should be displayed")
        public void the_order_should_be_placed_successfully_and_an_order_confirmation_message_should_be_displayed() {
        	sp = new SuccessPage(driver);
            sp.ValidateSuccessMsg();  // Validate the success message
        }

    

    
}






