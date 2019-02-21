package smokeTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static utilities.DriverFactory.open;

public class PageTitleJUnit {

    WebDriver driver;
    String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

    @Test
    public void pageTitleTest(){
        System.out.println("Running Test!");
        driver.get(url);
        String actualTitle = driver.getTitle();
        String expectedTitle = "SDET Training | Account Management";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Before
    public void setup(){
        System.out.println("Initialize driver in before setup method!");
        driver = open("chrome");
    }

    @After
    public void tearDown(){
        System.out.println("Close driver in after teardown method!");
        driver.close();
    }
}
