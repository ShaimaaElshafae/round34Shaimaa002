package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class w3schoolsTests  extends template.TestCase{

    @BeforeMethod
    public void beforeW3SchoolsMethod()
    {
        chromeDriver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
    }
    //#7 •	Assert that the Country for the Company [Ernst Handel] is [Austria]

    public void checkCountryForCompany() {

        By countryCellLocator = By.xpath("(//td[.='Ernst Handel']//parent::tr/td)[3]");
        var  countryCell=chromeDriver.findElement
                (countryCellLocator).getText();

        Assert.assertEquals(countryCell,"Austria","Country for the Company [Ernst Handel] is not [Austria]");
        System.out.println("Country for the Company [Ernst Handel] is: " + countryCell);

    }

}
