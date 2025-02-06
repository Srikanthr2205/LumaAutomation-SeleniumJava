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

    @Given("User selects any product from Hotsellers list")
    public void user_selects_any_product_from_hotsellers_list() {
    	hp = new HomePage(driver);
        hp.SelectAnyProduct();
    }

    // Step to select size, color, and quantity
    @Given("User selects size {string}, color {string}, and quantity {string}")
    public void user_selects_size_color_and_quantity(String size, String color, String qty) {
    	pd = new ProductDetailsPage(driver);
        pd.SelectSize(size);  // Select product size
        pd.SelectColor(color);  // Select product color
        pd.SelectQuantity(qty);  // Select product quantity
    }

    @When("User adds product to the cart")
    public void user_adds_product_to_the_cart() {
        pd.AddtoCart();  // Add product to the cart
        pd.cartbtn();  // Click on the cart button
    }

    @When("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        pd.ProceedtoCheckout();  // Proceed to checkout
    }

    @When("User enters valid shipping and payment details")
    public void user_enters_valid_shipping_and_payment_details() {
    	cp = new CheckoutPage(driver);
        cp.ShippingAddress();  // Enter shipping details
    }

    @When("User place the order")
    public void user_place_the_order() {
        cp.PlaceOrder();  // Place the order
    }

    @Then("Order placed and user should see an order confirmation message")
    public void order_placed_and_user_should_see_an_order_confirmation_message() {
    	sp = new SuccessPage(driver);
        sp.ValidateSuccessMsg();  // Validate the success message
    }

    
}






