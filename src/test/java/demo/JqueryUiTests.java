package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import demo.template.TestCase;

@Test
public class JqueryUiTests extends TestCase {
    //#9 •	Drag [Drag me to my target] and drop it on [Drop here]

    public void  dragAndDrop() {
        chromeDriver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");


        // Get source and target elements by ID
        By sourceLocator = By.id("draggable");
        By targetLocator = By.id("droppable");
        WebElement sourceElement = chromeDriver.findElement(sourceLocator);
        WebElement targetElement = chromeDriver.findElement(targetLocator);
        //initialize Actions class and perform drag and drop
        Actions actions = new Actions(chromeDriver);
        actions.dragAndDrop(sourceElement, targetElement).perform();
        String targetText = targetElement.getText();
        Assert.assertEquals(targetText, "Dropped!");
        System.out.println(targetElement.getText());





    }
}
