package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import demo.template.TestCase;

@Test
public class DuckDuckGoTests extends TestCase {

@BeforeMethod
public void beforeDuckDuckMethod()
{
    chromeDriver.navigate().to("https://duckduckgo.com/");
}

    //#1 Assert that the page title is [Google]
    public void checkDuckDuckGoPageTitle() {

        // Get the current page title
        String currentPageTitle = chromeDriver.getTitle();
        System.out.println("Current page title is: " + currentPageTitle);
        Assert.assertEquals(currentPageTitle, "Google");
    }

    //#2 Assert that the DuckDuckGo logo is displayed
    public  void checkDuckDuckGoLogo() {




          By logoSelector = By.xpath("(//section/a/picture/img)[2]");
          var actualLogoElement = chromeDriver.findElement(logoSelector).isDisplayed() ;
          Assert.assertTrue(actualLogoElement, "DuckDuckGo logo is not displayed.");
        System.out.println("Logo is displayed: " + actualLogoElement );


    }
    //#3 Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
    public void  searchForSeleniumWebDriver() {

        By searchBoxInput = By.id("searchbox_input");
        chromeDriver.findElement(searchBoxInput).sendKeys("Selenium WebDriver");
        chromeDriver.findElement(searchBoxInput).sendKeys(Keys.ENTER);

        By firstResultSelector = By.xpath("(//a[@data-testid=\"result-extras-url-link\"])[1]");
        var  actualResult= chromeDriver.findElement(firstResultSelector).getAttribute("href");

        Assert.assertEquals(actualResult, "https://www.selenium.dev/documentation/webdriver/");
        System.out.println("First result URL is: " + actualResult);

    }

    //#5 Assert that the link of the second result contains [https://www.linkedin.com]

    public void  searchForCucumberIO() {

       By searchboxInput = By.id("searchbox_input");
       WebElement searchInputElement = chromeDriver.findElement(searchboxInput);
       searchInputElement.sendKeys("Cucumber IO");
       searchInputElement.sendKeys(Keys.ENTER);

        By secondResultSelector = By.xpath("(//a[@data-testid=\"result-extras-url-link\"])[2]");
        var secondResultUrl = chromeDriver.findElement(secondResultSelector).getDomAttribute("href");
        Assert.assertEquals(secondResultUrl, "https://www.linkedin.com");
        System.out.println("Second result URL is: " + secondResultUrl);
 }





}
