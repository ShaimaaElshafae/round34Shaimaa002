package botDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class ElementActionBot {

 Wait<WebDriver> wait;

    public ElementActionBot(Wait<WebDriver> wait)
    {
        this.wait = wait;
    }
public void navigateTo(String url) {
    wait.until(d -> {
        System.out.println("Navigating to: " + url);
        d.navigate().to(url);
        System.out.println("Navigation was successful.");
        return true;
    });
}
    public void type(By locator, String text) {


    wait.until(d-> {
        System.out.println("Typing: " + text + " into " + locator+".");
        d.findElement(locator).sendKeys(text);
        System.out.println("Typing was successful.");
        return true;

                   });

                        }
    public void pressEnter(By locator) {


        wait.until(d-> {
            System.out.println("Pressing Enter key on " + locator+".");
            d.findElement(locator).sendKeys(Keys.ENTER);
            System.out.println("Enter key was pressed successfully.");
            return true;

        });}
    public void assertTextEquals(By locator, String expectedText) {
        wait.until(d-> {
            String actualText = d.findElement(locator).getText();
            System.out.println("Asserting that text of " + locator + " equals: " + expectedText);
            Assert.assertEquals(actualText, expectedText);
            System.out.println("Assertion was successful.");
            return true;
        });
    }

}
