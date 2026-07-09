package template;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Test scenario starts with a navigation
 * Test scenario contains multiple assertions
 * Every assertion must have its own test method (one assertion per test method)
 * Test methods are clearly dependent on each other (pass/fail/block)
 * The browser session is controlled per test class
 */
public class TestScenario {
    WebDriver driver;
    @BeforeClass
    public void beforeClass()
    {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
