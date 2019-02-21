package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utilities.CSVReader.get;
import static utilities.DriverFactory.open;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
    String name, email, phone, gender, password, country;
    boolean weeklyEmail, monthlyEmail, occasionalEmail;
    WebElement nameElement, emailElement, phoneElement, passElement, passreElement, radioBtnFemale, radioBtnMale, countryElement, weeklyCheckbox;
    WebDriver driver;

    @Test
    public void newAccountTest(){
        System.out.println("Name: "+name+"   Email: "+email+"   Phone: "+phone+"   Gender: "+gender+"   Password: "+password+"   Country: "+country+"   WeeklyEmail: "+weeklyEmail+"   MonthlyEmail: "+monthlyEmail+"   OccasionalEmail: "+occasionalEmail);

        //Define Web Elements
        defineWebElements();

        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phone);
        passElement.sendKeys(password);
        passreElement.sendKeys(password);
        new Select(countryElement).selectByVisibleText(country);


        if(gender.equalsIgnoreCase("male")){
            radioBtnMale.click();
        }else {
            radioBtnFemale.click();
        }


        if(weeklyEmail){
            if(!weeklyCheckbox.isSelected()) {
                weeklyCheckbox.click();
            }
        }else{
            if(weeklyCheckbox.isSelected()){
                weeklyCheckbox.click();
            }
        }

        driver.findElement(By.id("MainContent_btnSubmit")).click();

    }

    @Before
    public void setup(){
        driver = open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
    }

    @After
    public void teardown(){
        driver.quit();
    }

    public void defineWebElements(){
        nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        passElement = driver.findElement(By.cssSelector("#MainContent_txtPassword"));
        passreElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
        radioBtnFemale = driver.findElement(By.id("MainContent_Female"));
        radioBtnMale = driver.findElement(By.id("MainContent_Male"));
        countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
    }

    @Parameters
    public static List<String[]> getData(){
        return get("/Users/sdodia/Desktop/SeleniumProjectJava/UserAccounts.csv");
    }

    //Constructor which passes test data (parameters) to test method
    public NewAccountDDT(String name, String email, String phone, String gender, String password, String country,
                         String weeklyEmail, String monthlyEmail, String occasionalEmail) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.country = country;
        this.weeklyEmail = weeklyEmail.equalsIgnoreCase("true")? true : false;
        this.monthlyEmail = monthlyEmail.equalsIgnoreCase("true")? true : false;
        this.occasionalEmail = occasionalEmail.equalsIgnoreCase("true")? true : false;
    }
}
