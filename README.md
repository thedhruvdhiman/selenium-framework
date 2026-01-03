# selenium-framework

## Description

A comprehensive Selenium WebDriver framework built with Java, TestNG, and Maven. This project utilizes the Page Object Model (POM) design pattern to ensure maintainable and scalable test automation.

## Key Features

- **Page Object Model (POM)**: Promotes code reusability and maintainability by separating page objects from test logic.
- **ExtentReports**: Generates detailed and interactive HTML execution reports.
- **WebDriverManager**: Automatically manages browser drivers (e.g., ChromeDriver, GeckoDriver), eliminating the need for manual driver configuration.
- **Data-Driven Testing**: Supports testing with multiple data sets using TestNG DataProviders.
- **Maven Integration**: Easy build and dependency management.

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK) 17**
- **Maven**
- **IDE** (Eclipse, IntelliJ IDEA, etc.)

## Installation

1. **Clone the repository:**
   ```bash
   git clone <repository_url>
   ```
2. **Navigate to the project directory:**
   ```bash
   cd selenium-framework
   ```
3. **Install dependencies:**
   ```bash
   mvn clean install
   ```

## Running Tests

### Via Maven

To run all tests configured in the project:

```bash
mvn test
```

### Via TestNG XML Suites

You can run specific test suites using the XML files located in the `testSuites` directory:

- **All Tests**:
  Right-click `testSuites/regression.xml` -> Run As -> TestNG Suite

- **Purchase Tests**:
  Right-click `testSuites/Purchase.xml` -> Run As -> TestNG Suite

- **Error Handling Tests**:
  Right-click `testSuites/errorHandling.xml` -> Run As -> TestNG Suite

## Project Structure

- **`src/main/java`**: Contains the page objects, utilities, and resources.
  - `infinity`: Base package.
  - `infinity.pageObjects`: Page Object classes.
  - `infinity.resources`: Configuration files and reporting utilities.
  - `infinity.utility`: Common utility helper classes.
- **`src/test/java`**: Contains the test scripts and test data.
  - `infinity.Test`: Test classes calling page objects.
  - `infinity.data`: Data providers for data-driven testing.

## Reporting

After running the tests, ExtentReports are generated in the `reports` directory (or configured output path). Open the HTML file in a browser to view the detailed test execution results.
