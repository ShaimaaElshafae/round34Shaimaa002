package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class TestClass {

    WebDriver chromeDriver;
    WebDriver firefoxDriver;
    @BeforeMethod
    public void setUp( ) {
        // 1. Initialize ChromeDriver with optimized options

        chromeDriver = new ChromeDriver(getOptimizedOptions());
        firefoxDriver= new FirefoxDriver();
    }

    @AfterMethod
    public void tearDown() {

        if ((chromeDriver != null) || (firefoxDriver != null))
        {
            if (chromeDriver != null) {
                chromeDriver.quit();
            }
        }
        if (firefoxDriver != null) {
            firefoxDriver.quit();
        }
    }
    //#1 Assert that the page title is [Google]
    @Test
    public  void checkDuckDuckGoPageTitle() {


        chromeDriver.navigate().to("https://duckduckgo.com/");

        // Get the current page title
        String currentPageTitle = chromeDriver.getTitle();
        System.out.println("Current page title is: " + currentPageTitle);
        Assert.assertEquals(currentPageTitle, "Google");

    }

    //#2 Assert that the DuckDuckGo logo is displayed
    @Test
    public  void checkDuckDuckGoLogo() {

        chromeDriver.navigate().to("https://duckduckgo.com/");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get Logo element  by css selector and check if it is displayed
        WebElement logoElement = chromeDriver.findElement(By.cssSelector(
                ".header_headerWrapDesktop__KDZ5D.header_isResponsive__flh8y.header_hasSearchbox__heiXH"
        ));
        boolean isLogoDisplayed = logoElement.isDisplayed();
        Assert.assertTrue(isLogoDisplayed, "Logo is not displayed");
        System.out.println("Logo is displayed: " + isLogoDisplayed);

    }

    //#3 Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
    @Test
    public void  searchForSeleniumWebDriver() {
        chromeDriver.navigate().to("https://duckduckgo.com/");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get Search Box  element  by Id
        WebElement searchBoxInput = chromeDriver.findElement(By.id("searchbox_input"));
        searchBoxInput.sendKeys("Selenium WebDriver");
        // Get Search Button  element  by css selector and click it

        WebElement searchButton = chromeDriver.findElement(By.cssSelector(
                ".search-input_searchButton__IZyVQ.ai-searchbox_searchButton__LJ3t3.button_button__GGtY1.button_size-sm__fklol"
        ));
        searchButton.click();
        // Get first result of seach by xPath
        WebElement firstResult = chromeDriver.findElement(By.xpath("//*[@id=\"r1-0\"]/div[3]/h2/a"));
        String firstResultUrl = firstResult.getAttribute("href");
        Assert.assertEquals(firstResultUrl, "https://www.selenium.dev/documentation/webdriver/");
   System.out.println("First result URL is: " + firstResultUrl);

    }
    //#4  •	Assert that the text of the fourth result is [TestNG Tutorial] using Firefox
    @Test
    public void  searchForTestNGTutorial() {
        firefoxDriver.navigate().to("https://duckduckgo.com/");
        firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get Search Box  element  by Id
        WebElement searchBoxInput = firefoxDriver.findElement(By.id("searchbox_input"));
        searchBoxInput.sendKeys("TestNG");
        // Get Search Button  element  by xpath and click it

        WebElement searchButton = firefoxDriver.findElement(By.xpath("/html/body/div/div/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[2]/div/div/form/div/div[3]/button")
        );
        searchButton.click();
        // Get fourth result of seach by xPath
        WebElement fourthResult = firefoxDriver.findElement(By.xpath("//span[contains(text(),'Maven Repository')]"));
        String fourthResultUrl = fourthResult.getText();
        Assert.assertEquals(fourthResultUrl, "TestNG Tutorial");
        System.out.println("Fourth result Title is: " + fourthResultUrl);

    }







    //#5 Assert that the link of the second result contains [https://www.linkedin.com]
    @Test
    public void  searchForCucumberIO() {
        chromeDriver.navigate().to("https://duckduckgo.com/");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get Search Box  element  by Id
        WebElement searchBoxInput = chromeDriver.findElement(By.id("searchbox_input"));
        searchBoxInput.sendKeys("Cucumber IO");
        // Get Search Button  element  by css selector and click it

        WebElement searchButton = chromeDriver.findElement(By.cssSelector(
                ".search-input_searchButton__IZyVQ.ai-searchbox_searchButton__LJ3t3.button_button__GGtY1.button_size-sm__fklol"
        ));
        searchButton.click();
        // Get first result of seach by xPath
        WebElement secondResult = chromeDriver.findElement(By.xpath("//*[@id=\"r1-1\"]/div[2]/div/div/a"));
        String secondResultUrl = secondResult.getAttribute("href");
        Assert.assertEquals(secondResultUrl, "https://www.linkedin.com");
        System.out.println("Second result URL is: " + secondResultUrl);

    }
    //#6 Check CheckBox1 & Assert that both Checkboxes are checked
    @Test
    public void checkCheckBoxes() {
        chromeDriver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement checkBox1 =
                chromeDriver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkBox2 =
                chromeDriver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        checkBox1.click();
        checkBox1.isSelected();
        Assert.assertEquals(checkBox1.isSelected()&&checkBox2.isSelected(),true,"Both checkboxes are not checked");

    }
//#7 •	Assert that the Country for the Company [Ernst Handel] is [Austria]
    @Test
    public void checkCountryForCompany() {
        chromeDriver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement countryCell=chromeDriver.findElement
                (By.xpath("//*[@id='customers']//tr[td[text()='Ernst Handel']]/td[3]"));
        String country=countryCell.getText();
        Assert.assertEquals(country,"Austria","Country for the Company [Ernst Handel] is not [Austria]");
        System.out.println("Country for the Company [Ernst Handel] is: " + country);

    }

    //#8 Upload a small image file
    @Test
    public void  uploadSmallImage() {
        chromeDriver.navigate().to("http://the-internet.herokuapp.com/upload");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get uploadinput element  by Id
        WebElement fileuploadInput = chromeDriver.findElement(By.id("file-upload"));
        fileuploadInput.sendKeys("C:\\Users\\shaim\\Downloads\\shared image.jpg");

        // Get Upload Button  element  by ID & click it

        WebElement uploadButton = chromeDriver.findElement(By.id("file-submit"));
        uploadButton.click();
        String uploadedFileResult = chromeDriver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
        Assert.assertEquals(uploadedFileResult, "File Uploaded!");
        System.out.println("Uploaded file result is: " + uploadedFileResult);


    }
    //#9 •	Drag [Drag me to my target] and drop it on [Drop here]
    @Test
    public void  dragAndDrop() {
        chromeDriver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Get source and target elements by ID
        WebElement sourceElement = chromeDriver.findElement(By.id("draggable"));
        WebElement targetElement = chromeDriver.findElement(By.id("droppable"));
        //initialize Actions class and perform drag and drop
        Actions actions = new Actions(chromeDriver);
        actions.dragAndDrop(sourceElement, targetElement).perform();
        String targetText = targetElement.getText();
        Assert.assertEquals(targetText, "Dropped!");
        System.out.println(targetElement.getText());





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

