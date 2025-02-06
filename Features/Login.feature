#Author: srikanthr2205@gmail.com

Feature: Login

@login12   
Scenario: Successful Login with Valid Credentials  
    Given the user clicks on the Sign In button  
    Then the user should be redirected to the "Customer Login" page  
    When the user enters the email as "srikanthr2205@gmail.com"  
    And the user enters the password as "Srikanth@1234"  
    And the user clicks on the below Sign-In button  
    Then the welcome message "Welcome, Srikanth Reddy!" should be displayed

    
@login1
Scenario Outline: Successful Login with Data-Driven Testing 
    
    Given the user clicks on the Sign In button  
    Then the user should be redirected to the "Customer Login" page  
    When the user enters the email as "<email>"  
    And the user enters the password as "<password>"  
    And the user clicks on the below Sign-In button  
    Then the welcome message "Welcome, <name>!" should be displayed
   
    
    Examples:
    | email  										| 			password				| name             |
    | srikanthr2205@gmail.com		|				Srikanth@1234		| Srikanth Reddy   |
    | udhayrao@gmail.com			  |				Udhay@1234			| Udhay Rao        |
    
    
    
    
    
    