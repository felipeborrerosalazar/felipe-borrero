# Monefy App Test Automation

## Project Overview

This project aims to develop a set of automated tests for the Monefy application on Android. The goal is to ensure the application's functionality is thoroughly tested, focusing on critical user flows and features. This README provides an overview of the software stack used and the approach taken to design and implement these tests.

## Setup

1. **Clone the repository**:
   ```sh
   git clone https://github.com/felipeborrerosalazar/felipe-borrero.git
   cd mobileAppTestAutomation
   ```

2. **Install dependencies**: Ensure you have Maven installed. Run the following command to install the project dependencies:
   ```sh
   mvn clean install -DskipTests
   ```

3. **Configure Appium**: Ensure Appium is installed and running. You can install Appium using npm:
   ```sh
   npm install -g appium
   appium
   ```

4. **Set up Android Emulator**: Ensure you have an Android emulator set up and running. You can use Android Studio to create and start an emulator.

5. **Run the tests**: Execute the tests using Maven:
   ```sh
   mvn test
   ```
6. **Generate Allure report**: Generate the Allure report to view the test results:
   ```sh
   allure generate --clean && allure open
   ```

## Why This Tech Stack?

- **Java**: Java is a widely used programming language for test automation. It is platform-independent and has a rich set of libraries and frameworks.
- **Maven**: Maven simplifies the build process by managing project dependencies and providing a standard way to build, test, and package projects.
- **Appium**: Appium is a versatile tool for automating mobile applications. It supports multiple platforms (iOS, Android) and allows for cross-platform testing.
- **TestNG**: TestNG provides more functionalities than JUnit, such as parallel execution, data-driven testing, and test grouping, making it suitable for complex test scenarios.
- **Allure**: Allure generates detailed and interactive test reports, supporting test history, attachments, and test categorization, which helps in better understanding test results and coverage.

## Approach

The approach taken for this project involves the following steps:

1. **Setup**: Configure the project with the necessary dependencies and tools.
2. **Test Design**: Identify critical user flows and features to be tested, such as adding transactions, account creation, and report visualization.
3. **Test Implementation**: Write automated test scripts using Appium and TestNG to cover the identified scenarios.
4. **Test Execution**: Run the tests on an Android emulator using the configured Appium server.
5. **Reporting**: Generate test reports using Allure to provide insights into the test results and coverage.

## Current Status

This is a first draft of the test automation project. Due to time constraints, the implementation is not complete. The following tasks are pending:

- Implementing the functions for navigating the app and performing actions (e.g., `navigateToAddTransactionScreen`, `selectExpenseCategory`).
- Expanding the test coverage to include more scenarios and edge cases.

## Conclusion

This project demonstrates the initial steps taken to automate the testing of the Monefy application on Android. Although the implementation is incomplete, it provides the initial blueprint for future development.


---