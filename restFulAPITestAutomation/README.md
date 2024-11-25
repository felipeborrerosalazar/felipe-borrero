# RESTful API Test Automation

**Asumptions**: The API service is up and running and the base URL is correct. `https://github.com/swagger-api/swagger-petstore`

## Setup

1. **Clone the repository**:
   ```sh
   git clone https://github.com/felipeborrerosalazar/felipe-borrero.git
   cd restFulAPITestAutomation
    ```
2. **Install dependencies**:  Ensure you have Maven installed. Run the following command to install the project dependencies:
   ```sh
   mvn clean install -DskipTests
   ```
3. **Configure Allure**: Allure is used for generating test reports. The configuration is already done in the `pom.xml` file and `allure.properties` file. 


## How to run the tests

1. **Run the tests using Maven**: Run the following command to execute the tests:
   ```sh
    mvn test
    ```
2. **Generate Allure report**: Run the following command to generate the Allure report:
    ```sh
     allure generate --clean && allure open
     ```
## Approach and Tech Stack

The approach taken for this project involves creating automated tests for a RESTful API using TestNG and Rest-Assured. The tests are organized to cover various scenarios, including creating, retrieving, updating, and deleting users, as well as placing orders. The tests are written in Java and are executed using Maven. Allure is used for generating test reports.

## Why This Tech Stack?
- **Java**: Java is a widely used programming language for test automation. It is platform-independent and has a rich set of libraries and frameworks.
- **TestNG**: TestNG is a testing framework that provides more functionalities than JUnit. It supports parallel execution, data-driven testing, and test grouping.
- **Rest-Assured**: Rest-Assured is a Java library for testing RESTful APIs. It provides a simple and intuitive API for making HTTP requests and validating responses.
- **Maven**: Maven is a build automation tool that simplifies the build process. It manages project dependencies and provides a standard way to build, test, and package projects.
- **Allure**: Allure is a test report tool that provides detailed and interactive reports. It supports test history, attachments, and test categorization.


