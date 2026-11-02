
// Folder: DropdownVerification/src/test/java/
// File Name: DropdownVerificationTest.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownVerificationTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // Launch Chrome
        driver = new ChromeDriver();

        // Maximize browser
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts()
            .implicitlyWait(Duration.ofSeconds(10));

        // Open website
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void verifyDropdown() {

        // Locate dropdown
        WebElement dropdownElement =
            driver.findElement(By.id("dropdown"));

        // Create Select object
        Select dropdown = new Select(dropdownElement);

        // Get all items
        List<WebElement> options = dropdown.getOptions();

        // Count items
        System.out.println("Total number of items: " + options.size());

        Assert.assertEquals(
            options.size(),
            3,
            "Incorrect number of dropdown items"
        );

        // Verify default selected value
        String defaultValue =
            dropdown.getFirstSelectedOption().getText();

        System.out.println("Default selected value: " + defaultValue);

        Assert.assertEquals(
            defaultValue,
            "Please select an option",
            "Incorrect default value"
        );

        // Select Option A by visible text
        dropdown.selectByVisibleText("Option A");

        String selectedValue =
            dropdown.getFirstSelectedOption().getText();

        System.out.println("Selected value: " + selectedValue);

        Assert.assertEquals(
            selectedValue,
            "Option A",
            "Option A was not selected"
        );

        // Select Option B by index
        dropdown.selectByIndex(2);

        selectedValue =
            dropdown.getFirstSelectedOption().getText();

        System.out.println("Selected by index: " + selectedValue);

        Assert.assertEquals(
            selectedValue,
            "Option B",
            "Option B was not selected"
        );

        // Select Option A by value
        dropdown.selectByValue("1");

        selectedValue =
            dropdown.getFirstSelectedOption().getText();

        System.out.println("Selected by value: " + selectedValue);

        Assert.assertEquals(
            selectedValue,
            "Option A",
            "Option A was not selected by value"
        );
    }

    @AfterMethod
    public void tearDown() {

        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}
