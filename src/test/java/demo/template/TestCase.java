package demo.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Test cases start with a navigation
 * Test cases end with a single assertion
 * Test cases are independent
 * The browser session is controlled per test method
 */
public class TestCase {
     public WebDriver chromeDriver;

    @BeforeMethod
    public void setUp() {
        // Setup code here
        chromeDriver = new ChromeDriver(getOptimizedOptions());
    }

    @AfterMethod
    public void tearDown() {

            chromeDriver.quit();

    }
    // Optimize ChromeOptions for CI/CD environments
    public static ChromeOptions getOptimizedOptions() {
        ChromeOptions options = new ChromeOptions();

        // headless mode for CI/CD environments
        //options.addArguments("--headless");


        // CI/CD-specific stability
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Performance & consistency
        options.addArguments("--disable-extensions");
        // Set the starting position to the top-left corner (0,0)
        options.addArguments("--window-position=0,0");
        options.addArguments("--window-size=1920,1080");

        return options;
    }



}