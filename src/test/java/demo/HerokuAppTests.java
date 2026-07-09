package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import template.TestCase;

import java.time.Duration;

@Test
public class HerokuAppTests extends TestCase {



    //#6 Check CheckBox1 & Assert that both Checkboxes are checked

    public void checkCheckBoxes() {
        chromeDriver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
        By checkBox1Selector = By.xpath("(//input)[1]");
        var  checkBox1 = chromeDriver.findElement(checkBox1Selector);
        By checkBox2Selector = By.xpath("(//input)[2]");
        var checkBox2 = chromeDriver.findElement(checkBox2Selector);
        checkBox1.click();
        checkBox1.isSelected();
        Assert.assertEquals(checkBox1.isSelected()&&checkBox2.isSelected(),true,"Both checkboxes are not checked");
        System.out.println("Both checkboxes are checked: " + (checkBox1.isSelected() && checkBox2.isSelected()));

    }

    //#8 Upload a small image file

    public void  uploadSmallImage() {
        chromeDriver.navigate().to("http://the-internet.herokuapp.com/upload");


        // Get uploadinput element  by Id
        By fileuploadInputSelector = By.id("file-upload");
        var fileuploadInput = chromeDriver.findElement(fileuploadInputSelector);
        fileuploadInput.sendKeys("C:\\Users\\shaim\\Downloads\\shared image.jpg");

        // Get Upload Button  element  by ID & click it
        By uploadButtonSelector = By.id("file-submit");
        chromeDriver.findElement(uploadButtonSelector).click();

        String uploadedFileResult = chromeDriver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(uploadedFileResult, "File Uploaded!");
        System.out.println("Uploaded file result is: " + uploadedFileResult);




    }}
