#Author: your.email@your.domain.com


Feature: Place Order Functionality
  As a customer,
  I want to place an order on the e-commerce platform,
  So that I can purchase products.

  Background:
    Given User launch a Chrome browser
    And User opens URL "https://magento.softwaretestingboard.com/"
    When User clicks on Signin button
    Then user should be redirected to the signin page title should be "Customer Login"
    When User enter Email as "srikanthr2205@gmail.com"
    And User enter password as "Srikanth@1234"
    When User clicks on Sign in button
  
  
  Scenario: Successfully placing an order with valid details
    Given User selects any product from Hotsellers list
    And User selects size "M", color "Yellow", and quantity "2"
    When User adds product to the cart
    And User proceeds to checkout
    And User enters valid shipping and payment details
    And User place the order
    Then Order placed and user should see an order confirmation message
     And close browser
   


