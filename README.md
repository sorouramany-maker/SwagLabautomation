# Swag Labs Automation Assignment

Selenium WebDriver + TestNG + POM + JSON Data-Driven Testing.

## Requirements
- JDK 17+
- Maven 3.8+
- Google Chrome installed (Selenium Manager handles driver setup)
- Internet access to download Maven dependencies and open saucedemo.com

## Run
```bash
mvn test
```
Or open `pom.xml` as a Maven project in IntelliJ and run `LoginTest` / `InventoryTest`.

## Test scenarios
1. Successful login redirects to `/inventory.html`
2. Invalid login displays invalid-credentials message
3. Login with missing password displays required-password message
4. Inventory has page title `Swag Labs`, visible cart, and 6 products

All usernames and passwords are loaded from `src/main/resources/testData.json` via `DataDriven.jsonReader()`.

Note: Existing Java project classes from another automation framework should not be mixed with these packages unless imports and class names are adjusted.

## Submission
Push this project to a **public** GitHub repository, then send the repository link following the assignment instructions.
