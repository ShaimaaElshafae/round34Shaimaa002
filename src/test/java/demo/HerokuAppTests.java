package demo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import template.TestCase;
import static org.testng.Assert.assertTrue;


public class HerokuAppTests extends TestCase {



    //#6 Check CheckBox1 & Assert that both Checkboxes are checked
    @Test
    public void checkCheckBoxes1() {
        chromeDriver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
        By checkBox1Selector = By.xpath("(//input)[1]");
        var  checkBox1 = chromeDriver.findElement(checkBox1Selector);

        checkBox1.click();
        boolean checkBox1ActualResult = checkBox1.isSelected();

        Assert.assertTrue(checkBox1ActualResult, "Both checkbox1 are not checked");
        System.out.println(" checkbox1 is  checked: " + checkBox1ActualResult);

    }
    @Test(dependsOnMethods = {"checkCheckBoxes1"})
    public void checkCheckBoxes2() {
        chromeDriver.navigate().to("http://the-internet.herokuapp.com/checkboxes");

        By checkBox2Selector = By.xpath("(//input)[2]");
        var checkBox2 = chromeDriver.findElement(checkBox2Selector);

        assertTrue(checkBox2.isSelected(), "checkbox2 is not checked");
        System.out.println("Both checkboxes are   checked: " );

    }

    //#8 Upload a small image file
    @Test
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
