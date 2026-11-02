
// Folder: SeleniumGridDemo/src/main/java/
// File Name: LoginTest.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    public static void main(String[] args) {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Configure implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {

            // Open login page
            driver.get("https://www.saucedemo.com/");

            // Maximize browser
            driver.manage().window().maximize();

            // Enter username
            WebElement username = driver.findElement(By.id("user-name"));
            username.sendKeys("performance_glitch_user");

            // Enter password
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("secret_sauce");

            // Click Login button
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Assertion 1: URL Validation
            String expectedUrl = "https://www.saucedemo.com/inventory.html";
            String actualUrl = driver.getCurrentUrl();

            assertEquals(expectedUrl, actualUrl, "URL validation failed!");

            System.out.println("URL Validation: PASS");

            // Assertion 2: Welcome/Page Message
            WebElement productsTitle = driver.findElement(By.className("title"));
            String actualMessage = productsTitle.getText();

            assertEquals("Products", actualMessage, "Products page validation failed!");

            System.out.println("Welcome/Page Message Validation: PASS");

            // Assertion 3: Logout Visibility

            // Open menu
            WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
            menuButton.click();

            // Find logout button
            WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));

            assertTrue(logoutButton.isDisplayed(), "Logout button is not visible!");

            System.out.println("Logout Visibility Validation: PASS");

            System.out.println("--------------------------------");
            System.out.println("LOGIN TEST PASSED SUCCESSFULLY");
            System.out.println("--------------------------------");

        } catch (AssertionError e) {

            // Display test failure
            System.out.println("--------------------------------");
            System.out.println("LOGIN TEST FAILED");
            System.out.println("Reason: " + e.getMessage());
            System.out.println("--------------------------------");

        } finally {

            // Close browser
            driver.quit();
        }
    }
}
