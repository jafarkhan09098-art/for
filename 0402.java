// Folder: SeleniumGridDemo/src/main/java/
// File Name: FirefoxGridTest.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URI;

public class FirefoxGridTest {

    public static void main(String[] args) throws Exception {

        // Firefox configuration
        FirefoxOptions options = new FirefoxOptions();

        // Connect to Selenium Grid Hub
        WebDriver driver = new RemoteWebDriver(
            URI.create("http://localhost:4444").toURL(),
            options
        );

        try {
            // Starting Firefox
            System.out.println("Starting Firefox...");

            // Open Google website
            driver.get("https://www.google.com");

            // Print page title
            System.out.println("Title: " + driver.getTitle());

            // Find search box
            WebElement searchBox = driver.findElement(By.name("q"));

            // Enter text
            searchBox.sendKeys("WebDriverTesting");

            // Perform search
            searchBox.submit();

            // Wait for 3 seconds
            Thread.sleep(3000);

            // Display success message
            System.out.println("Firefox Test PASSED");

        } finally {
            // Close browser
            driver.quit();
        }
    }
}