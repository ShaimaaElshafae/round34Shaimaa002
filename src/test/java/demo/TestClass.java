package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        // 1. Initialize ChromeDriver with optimized options

                driver = new ChromeDriver(getOptimizedOptions());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    //#1 Assert that the page title is [Google]
    @Test
    public  void checkDuckDuckGoPageTitle() {


        driver.navigate().to("https://duckduckgo.com/");

        // Get the current page title
        String currentPageTitle = driver.getTitle();
        System.out.println("Current page title is: " + currentPageTitle);
        Assert.assertEquals(currentPageTitle, "Google");

    }

    //#2 Assert that the DuckDuckGo logo is displayed
    @Test
    public  void checkDuckDuckGoLogo() {

        driver.navigate().to("https://duckduckgo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get Logo element  by css selector and check if it is displayed
        WebElement logoElement = driver.findElement(By.cssSelector(
                ".header_headerWrapDesktop__KDZ5D.header_isResponsive__flh8y.header_hasSearchbox__heiXH"
        ));
        boolean isLogoDisplayed = logoElement.isDisplayed();
        Assert.assertTrue(isLogoDisplayed, "Logo is not displayed");
        System.out.println("Logo is displayed: " + isLogoDisplayed);

    }

    //#3 Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
    @Test
    public void  searchForSeleniumWebDriver() {
        driver.navigate().to("https://duckduckgo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get Search Box  element  by Id
        WebElement searchBoxInput = driver.findElement(By.id("searchbox_input"));
        searchBoxInput.sendKeys("Selenium WebDriver");
        // Get Search Button  element  by css selector and click it

        WebElement searchButton = driver.findElement(By.cssSelector(
                ".search-input_searchButton__IZyVQ.ai-searchbox_searchButton__LJ3t3.button_button__GGtY1.button_size-sm__fklol"
        ));
        searchButton.click();
        // Get first result of seach by xPath
        WebElement firstResult = driver.findElement(By.xpath("//*[@id=\"r1-0\"]/div[3]/h2/a"));
        String firstResultUrl = firstResult.getAttribute("href");
        Assert.assertEquals(firstResultUrl, "https://www.selenium.dev/documentation/webdriver/");
   System.out.println("First result URL is: " + firstResultUrl);

    }
    //#5 Assert that the link of the second result contains [https://www.linkedin.com]
    @Test
    public void  searchForCucumberIO() {
        driver.navigate().to("https://duckduckgo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get Search Box  element  by Id
        WebElement searchBoxInput = driver.findElement(By.id("searchbox_input"));
        searchBoxInput.sendKeys("Cucumber IO");
        // Get Search Button  element  by css selector and click it

        WebElement searchButton = driver.findElement(By.cssSelector(
                ".search-input_searchButton__IZyVQ.ai-searchbox_searchButton__LJ3t3.button_button__GGtY1.button_size-sm__fklol"
        ));
        searchButton.click();
        // Get first result of seach by xPath
        WebElement secondResult = driver.findElement(By.xpath("//*[@id=\"r1-1\"]/div[2]/div/div/a"));
        String secondResultUrl = secondResult.getAttribute("href");
        Assert.assertEquals(secondResultUrl, "https://www.linkedin.com");
        System.out.println("Second result URL is: " + secondResultUrl);

    }
    //#6 Check CheckBox1 & Assert that both Checkboxes are checked
    @Test
    public void checkCheckBoxes() {
        driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement checkBox1 =
                driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkBox2 =
                driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        checkBox1.click();
        checkBox1.isSelected();
        Assert.assertEquals(checkBox1.isSelected()&&checkBox2.isSelected(),true,"Both checkboxes are not checked");

    }
//#7 •	Assert that the Country for the Company [Ernst Handel] is [Austria]
    @Test
    public void checkCountryForCompany() {
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement countryCell=driver.findElement
                (By.xpath("//*[@id='customers']//tr[td[text()='Ernst Handel']]/td[3]"));
        String country=countryCell.getText();
        Assert.assertEquals(country,"Austria","Country for the Company [Ernst Handel] is not [Austria]");
        System.out.println("Country for the Company [Ernst Handel] is: " + country);

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

