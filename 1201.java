// Folder: CrossBrowserTesting/src/main/java/
// File Name: CrossBrowserTesting.java

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class CrossBrowserTesting {

    public static void main(String[] args) throws MalformedURLException {

        String gridURL = "http://localhost:4444";

        String[] browsers = {"chrome", "firefox", "MicrosoftEdge"};

        for (String browser : browsers) {

            WebDriver driver = null;

            try {

                System.out.println("-----------------------------------");
                System.out.println("Testing Browser: " + browser);

                DesiredCapabilities capabilities =
                        new DesiredCapabilities();

                capabilities.setBrowserName(browser);

                long startTime = System.currentTimeMillis();

                driver = new RemoteWebDriver(
                        URI.create(gridURL).toURL(),
                        capabilities
                );

                driver.manage().timeouts()
                        .implicitlyWait(Duration.ofSeconds(10));

                driver.manage().window().maximize();

                driver.get("https://www.google.com");

                System.out.println(
                        "Page Title: " + driver.getTitle()
                );

                System.out.println(
                        "Current URL: " + driver.getCurrentUrl()
                );

                long endTime = System.currentTimeMillis();

                long executionTime =
                        endTime - startTime;

                System.out.println(
                        "Execution Time: "
                                + executionTime + " ms"
                );

                System.out.println(
                        "Status: PASSED"
                );

            } catch (Exception e) {

                System.out.println(
                        "Status: FAILED"
                );

                System.out.println(
                        "Error: " + e.getMessage()
                );

            } finally {

                if (driver != null) {
                    driver.quit();
                }
            }
        }
    }
}