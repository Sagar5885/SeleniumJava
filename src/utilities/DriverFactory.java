package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver open(String browserType){
        WebDriver driver;

        if(browserType.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/sdodia/Downloads/chromedriver");
            driver = new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "/Users/sdodia/Downloads/geckodriver");
            driver = new FirefoxDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", "/Users/sdodia/Downloads/chromedriver");
            driver = new ChromeDriver();
        }

        return driver;
    }
}
