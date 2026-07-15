package demo;

import botDemo.ElementActionBot;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DuckduckgoFirfoxTests {

    public WebDriver firefoxDriver;
    Wait<WebDriver> wait;
    ElementActionBot bot;
/*Ignoring NoSuchElementException is narrow:
 It only protects you from missing HTML elements.
 If a browser tab or alert is missing, your code will crash.

Ignoring NotFoundException is broad:
It acts as a catch-all.
It protects your code from crashing whether it's a missing HTML element, tab, alert, or frame.*/

    @Test
    public void  searchForTestNGTutorial() {




       bot.navigateTo("https://duckduckgo.com/");

       By searchBoxLocator = By.id("searchbox_input");
       By fourthResultsLocator = By.xpath("(//a[@data-testid='result-title-a']/span)[4]");



        bot.type(searchBoxLocator, "TestNG");
        bot.pressEnter(searchBoxLocator);
        bot.assertTextEquals(fourthResultsLocator, "TestNG Tutorial");





    }


    @BeforeMethod
    public void setUp() {
        firefoxDriver = new FirefoxDriver();
        wait= new FluentWait<>(firefoxDriver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);
          bot = new ElementActionBot(wait);



    }

    @AfterMethod
    public void tearDown() {

        firefoxDriver.quit();

    }
}
