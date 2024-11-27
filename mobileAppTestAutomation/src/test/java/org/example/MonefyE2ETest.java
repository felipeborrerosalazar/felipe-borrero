package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MonefyE2ETest {

    private AndroidDriver<MobileElement> driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        caps.setCapability(MobileCapabilityType.APP, "mobileAppTestAutomation/src/test/java/org/example/resources/monefy-1-18-0.apk"); // Ruta al APK de la aplicación

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAddExpenseTransaction() {
        // Navigate to the add transaction screen
        // TODO: Implement navigateToAddTransactionScreen()

        // Select expense category
        // TODO: Implement selectExpenseCategory("Food")

        // Enter transaction amount
        // TODO: Implement enterTransactionAmount("50")

        // Save transaction
        // TODO: Implement saveTransaction()

        // Verify transaction is added
        // TODO: Implement verifyTransactionAdded("Food", "50")
    }

    @Test
    public void testAddIncomeTransaction() {
        // Navigate to the add transaction screen
        // TODO: Implement navigateToAddTransactionScreen()

        // Select income category
        // TODO: Implement selectIncomeCategory("Salary")

        // Enter transaction amount
        // TODO: Implement enterTransactionAmount("1000")

        // Save transaction
        // TODO: Implement saveTransaction()

        // Verify transaction is added
        // TODO: Implement verifyTransactionAdded("Salary", "1000")
    }

    @Test
    public void testAddFutureTransaction() {
        // Navigate to the add transaction screen
        // TODO: Implement navigateToAddTransactionScreen()

        // Select expense category
        // TODO: Implement selectExpenseCategory("Utilities")

        // Enter transaction amount
        // TODO: Implement enterTransactionAmount("200")

        // Set future date
        // TODO: Implement setTransactionDate("2023-12-31")

        // Save transaction
        // TODO: Implement saveTransaction()

        // Verify future transaction is added
        // TODO: Implement verifyFutureTransactionAdded("Utilities", "200", "2023-12-31")
    }
}