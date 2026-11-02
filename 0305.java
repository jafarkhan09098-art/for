
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class nlinks {

    static String driverPath = "C:\\Selenium\\geckodriver-v0.37.1-win64\\geckodriver.exe";

    public static WebDriver driver;

    public static void main(String[] args) {

        // Set GeckoDriver path
        System.setProperty("webdriver.gecko.driver", driverPath);

        // Create Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Launch Firefox browser
        driver = new FirefoxDriver(
            new org.openqa.selenium.firefox.FirefoxOptions().merge(capabilities)
        );

        // Open website
        driver.get("http://toolsqa.wpengine.com/");

        // Find all links on the webpage
        java.util.List<WebElement> links =
            driver.findElements(By.tagName("a"));

        // Display total number of links
        System.out.println("Total links are: " + links.size());

        // Display all link names
        for (int i = 0; i < links.size(); i = i + 1) {

            System.out.println(
                "Link " + i + " Link name: " + links.get(i).getText()
            );
        }

        // Close browser
        driver.quit();
    }
}
