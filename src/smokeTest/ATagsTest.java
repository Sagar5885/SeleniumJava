package smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static utilities.DriverFactory.open;

public class ATagsTest {

    WebDriver driver;
    String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

    @Test
    public void loginElementsPresent(){
        System.out.println("Running Test!");
        boolean createAccountPresent = false;

        //test presense of tags links
        List<WebElement> aElements = (List<WebElement>) driver.findElements(By.tagName("a"));
        System.out.println("Total no of a tag elements: "+aElements.size());

        for (WebElement a: aElements) {
            System.out.println(a.getText());
            if(a.getText().equals("CREATE ACCOUNT")){
                createAccountPresent = true;
                break;
            }
        }

        //Assertion
        Assert.assertTrue(createAccountPresent);
    }

    @BeforeMethod
    public void setup(){
        System.out.println("Initialize driver in beforemethod setup method!");
        driver = open("chrome");
        driver.get(url);
    }

    @AfterMethod
    public void teardown(){
        System.out.println("Close driver in aftermethod teardown method!");
        driver.close();
    }
}
