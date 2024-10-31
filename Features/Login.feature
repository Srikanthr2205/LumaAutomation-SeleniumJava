#Author: srikanthr2205@gmail.com

Feature: Login
  
Scenario: Successful Login with Valid Credentials
    Given User launch a "Chrome" browser
    And User opens URL "https://magento.softwaretestingboard.com/"
    When User clicks on Signin button
    Then user should be redirected to the signin page title should be "Customer Login"
    When User enter Email as "srikanthr2205@gmail.com"
    And User enter password as "Srikanth@1234"
    When User clicks on Sign in button
    Then The welcome message "Welcome, Srikanth Reddy!" should be displayed
    And close browser
    
@login1
Scenario Outline: Successful Login with DATA DRIVEN
    Given User launch a "Chrome" browser
    And User opens URL "https://magento.softwaretestingboard.com/"
    When User clicks on Signin button
    Then user should be redirected to the signin page title should be "Customer Login"
    When User enter Email as "<email>"
    And User enter password as "<password>"
    When User clicks on Sign in button
    Then The welcome message "Welcome, Srikanth Reddy!" should be displayed
    And close browser
    
    Examples:
    | email  										| 			password				|
    | srikanthr2205@gmail.com		|				Srikanth@1234		|
    | vinay123@gmail.com				|				Vinay1234				|