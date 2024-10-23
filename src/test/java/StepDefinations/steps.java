package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import PageObjects.CheckoutPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProductDetailsPage;
import PageObjects.SuccessPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class steps {

    WebDriver driver;
    public LoginPage lp;
    public HomePage hp;
    public ProductDetailsPage pd;
    public CheckoutPage cp;
    public SuccessPage sp;

    @Given("User launch a Chrome browser")
    public void user_launch_a_chrome_browser() {
        // Use WebDriverManager to set up chromeDriver
    	WebDriverManager.chromedriver().browserVersion("129").setup();

        driver = new ChromeDriver();  // Initialize the chrome driver
        driver.manage().window().maximize();  // Maximize the browser window
    }

    @Given("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        lp = new LoginPage(driver); // Initialize LoginPage object after loading the page
    }

    @When("User clicks on Signin button")
    public void user_clicks_on_signin_button() {
        lp.SignInPage();  // Navigate to the sign-in page
    }

    @Then("user should be redirected to the signin page title should be {string}")
    public void user_should_be_redirected_to_the_signin_page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
    }
    
   


    @When("User enter Email as {string}")
    public void user_enter_email_as(String email) {
        lp.setUserEmail(email);  // Set the user email
    }

    @When("User enter password as {string}")
    public void user_enter_password_as(String password) {
        lp.setUserPassword(password);  // Set the user password
    }

    @When("User clicks on Sign in button")
    public void user_clicks_on_sign_in_button() {
        lp.signin();  // Click on the sign-in button
    }

    @Then("The welcome message {string} should be displayed")
    public void the_welcome_message_should_be_displayed(String expectedMessage) throws InterruptedException {
        Thread.sleep(5000);  // Wait for the welcome message to appear
        try {
            String actualMessage = lp.getwelcomemsg();
            Assert.assertEquals(actualMessage, expectedMessage, "Welcome message does not match");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Step to select a product from the Hotsellers list
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

    @Then("close browser")
    public void close_browser() {
        driver.close();  // Close the browser
    }
}
