#Author: your.email@your.domain.com


Feature: Place Order Functionality  

  As a customer,  
  I want to place an order on the e-commerce platform,  
  So that I can purchase products.  

  Background:  
    Given the user clicks on the Sign In button  
    Then the user should be redirected to the "Customer Login" page  
    When the user enters the email as "srikanthr2205@gmail.com"  
    And the user enters the password as "Srikanth@1234"  
    And the user clicks on the below Sign-In button  

  Scenario: Successfully placing an order with valid details  
    Given the user selects a product from the Hot Sellers section  
    And the user chooses size "M", color "Yellow", and quantity "2"  
    When the user adds the product to the cart  
    And proceeds to checkout  
    And enters valid shipping and payment details  
    And places the order  
    Then the order should be placed successfully, and an order confirmation message should be displayed  

    
    
    
    
   


