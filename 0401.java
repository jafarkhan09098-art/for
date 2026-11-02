
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;

public class GridTest {

    public static void main(String[] args) throws Exception {

        // Chrome configuration
        ChromeOptions options = new ChromeOptions();

        // Connect to Selenium Grid Hub
        WebDriver driver = new RemoteWebDriver(
            URI.create("http://localhost:4444").toURL(),
            options
        );

        try {

            System.out.println("Starting Chrome...");

            // Open website
            driver.get("https://www.google.com");

            // Print title
            System.out.println("Title: " + driver.getTitle());

            // Find search box
            WebElement searchBox = driver.findElement(By.name("q"));

            // Enter text
            searchBox.sendKeys("WebDriver Testing");

            // Search
            searchBox.submit();

            Thread.sleep(3000);

            System.out.println("Test PASSED");

        } finally {

            // Close browser
            driver.quit();
        }
    }
}
