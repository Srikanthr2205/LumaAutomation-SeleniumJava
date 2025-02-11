
📌 README.md - Selenium Cucumber Test Automation Framework


🚀 Selenium Cucumber Test Automation Framework

📖 Overview
This project is a Selenium-based automation framework that tests the LUMA e-commerce website using Cucumber (BDD), Java, Maven, and Extent Reports.  
It includes test scenarios for user login and placing an order, ensuring the reliability of the platform.

🛠️ Tech Stack
- Java 8+
- Selenium WebDriver
- Cucumber (BDD) 
- TestNG 
- Maven (Dependency Management & Build Tool)  
- Extent Reports (Test Reporting)  
- WebDriverManager (Browser Driver Management)

---

📂 Project Structure


📦 Selenium-Cucumber-LUMA
│── 📂 src
│   ├── 📂 main
│   │   ├── 📂 java
│   │   ├── 📂 resources
│   ├── 📂 test
│   │   ├── 📂 java
│   │   │   ├── 📂 PageObjects        # Page Object Model (POM) classes
│   │   │   ├── 📂 StepDefinations    # Cucumber Step Definitions
│   │   │   ├── 📂 TestRunner         # Cucumber Test Runner
│   │   │   ├── 📂 Utils              # Utility classes (Extent Reports, Config)
│   │   ├── 📂 resources
│   │   │   ├── Config.properties     # Configuration File (Browser, URL)
│   │   │   ├── extent.properties     # Extent Report Configuration
│── 📂 target
│   ├── 📂 ExtentReports              # Test Reports (Generated)
│   ├── cucumber.json                 # Cucumber JSON report
│   ├── cucumber-reports.html         # Cucumber HTML Report
│── 📂 Features
│   ├── Login.feature                  # Cucumber Feature File for Login
│   ├── PlaceOrder.feature              # Cucumber Feature File for Place Order
│── 📂 Screenshots                      # Stores failure screenshots
│── pom.xml                              # Maven Dependencies
│── TestNG.xml                           # TestNG Configuration
│── README.md                            # Project Documentation


---

🚀 How to Set Up & Run the Tests

1️⃣ Clone the Repository

git clone https://github.com/Srikanthr2205/LumaAutomation-SeleniumJava.git
cd Selenium-Cucumber-LUMA


2️⃣ Install Dependencie
Make sure Maven is installed, then run : mvn clean install


3️⃣ Run Tests
Execute the test suite using : mvn test


---
📝 Features Implemented

1️⃣ Login Feature
✅ User can log in with valid credentials.  
✅ Validation of the welcome message after login.  

Feature File: `Features/Login.feature`
gherkin
Feature: Login

  @login
  Scenario: Successful Login with Valid Credentials
    Given the user clicks on the "Sign In" button
    Then the user should be redirected to the "Customer Login" page
    When the user enters the email as "srikanthr2205@gmail.com"
    And the user enters the password as "Srikanth@1234"
    And the user clicks on the "Sign In" button
    Then the welcome message "Welcome, Srikanth Reddy!" should be displayed


---

2️⃣ Place Order Feature
✅ User can select a product, add it to the cart, and place an order.  
✅ Ensures the correct product details are selected.  
✅ Validates the order confirmation message after checkout.  

📌 Feature File: `Features/PlaceOrder.feature`
gherkin
Feature: Place Order Functionality

  Background:
    Given the user clicks on the "Sign In" button
    Then the user should be redirected to the "Customer Login" page
    When the user enters the email as "srikanthr2205@gmail.com"
    And the user enters the password as "Srikanth@1234"
    And the user clicks on the "Sign In" button

  Scenario: Successfully placing an order with valid details
    Given the user selects a product from the "Hot Sellers" section
    And the user chooses size "M", color "Yellow", and quantity "2"
    When the user adds the product to the cart
    And proceeds to checkout
    And enters valid shipping and payment details
    And places the order
    Then the order should be placed successfully, and an order confirmation message should be displayed


---

📊 Test Reports
Cucumber Reports
- JSON Report:`target/cucumber.json`
- HTML Report: `target/cucumber-reports.html`

### Extent Reports
- 📌 Location: `target/ExtentReports/ExtentReport.html`
- 📸 Screenshots are saved in `Screenshots/` for failed tests.

To view the report, open:

target/ExtentReports/ExtentReport.html


---

🛠️ Configuration
Modify `src/test/resources/extent.properties` to customize reports.
Modify `Config.properties` to update:
- Browser (Chrome, Firefox, Edge)
- URL of the application


---

## 🔥 CI/CD Integration
This project is designed to integrate with Jenkins,GitHub Actions, or any CI/CD pipeline.  
To run tests in headless mode, update `BaseClass.java`:


ChromeOptions options = new ChromeOptions();
options.addArguments("--headless");
driver = new ChromeDriver(options);


---

## 📩 Contributing
1. Fork the repo 
2. Create a feature branch(`git checkout -b new-feature`)  
3. Commit your changes(`git commit -m "Added new feature"`)  
4. Push to the branch (`git push origin new-feature`)  
5. Submit a Pull Request  

---

💡 Future Enhancements
- ✅ Add more test scenarios (e.g., cart management, search functionality).  
- ✅ Integrate with Jenkins for CI/CD pipeline.  
- ✅ Enable Cross-browser testing using Selenium Grid.  

---

🤝 Contact
📧 Email: srikanthr2205@gmail.com 
🔗 LinkedIn: linkedin.com/in/srikanth-reddy-42811b2a3

---


