package demo;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class duckduckgoFirfoxTests {

    public WebDriver firefoxDriver;
/*Ignoring NoSuchElementException is narrow:
 It only protects you from missing HTML elements.
 If a browser tab or alert is missing, your code will crash.

Ignoring NotFoundException is broad:
It acts as a catch-all.
It protects your code from crashing whether it's a missing HTML element, tab, alert, or frame.*/

    @Test
    public void  searchForTestNGTutorial() {
        Wait<WebDriver> wait;
        wait= new FluentWait<>(firefoxDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);

        firefoxDriver.navigate().to("https://duckduckgo.com/");
        //firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By searchBoxLocator = By.id("searchbox_input");
        By fourthResultsLocator = By.xpath("(//a[@data-testid='result-title-a']/span)[4]");



        wait.until(d-> {
            d.findElement(searchBoxLocator).sendKeys("TestNG");
            d.findElement(searchBoxLocator).sendKeys(Keys.ENTER);
            return true;
                               });

        // Get fourth result of seach by xPath
        wait.until(d-> {
               String fourthResultUrl =d.findElement(fourthResultsLocator).getText();
               Assert.assertEquals(fourthResultUrl, "TestNG Tutorial");
               System.out.println("Fourth result Title is: " + fourthResultUrl);
            return true;
        });



    }


    @BeforeMethod
    public void setUp() {
        // Setup code here
        firefoxDriver = new FirefoxDriver();
    }

    @AfterMethod
    public void tearDown() {

        firefoxDriver.quit();

    }
}
