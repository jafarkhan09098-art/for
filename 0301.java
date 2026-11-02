
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class seleniumdemo {

    static String driverPath = "C:\\Selenium\\geckodriver-v0.37.1-win64\\geckodriver.exe";

    public static WebDriver driver;

    public static void main(String[] args) {

        int a = 10, b = 20;

        System.out.println("Hi....");
        System.out.println(a + b);
        System.out.println("Selenium demo.....");

        // Set GeckoDriver path
        System.setProperty("webdriver.gecko.driver", driverPath);

        // Create Firefox options
        FirefoxOptions options = new FirefoxOptions();

        // Launch Firefox browser
        driver = new FirefoxDriver(options);

        // Open Facebook website
        driver.get("https://facebook.com");

        // Maximize browser window
        driver.manage().window().maximize();

        // Close browser
        driver.quit();
    }
}
