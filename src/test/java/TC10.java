import com.github.javafaker.Faker;
import model.Customer;
import model.Reminder;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class TC10 {
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;

    WebDriver driver;
    SoftAssert softAssert;


    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        softAssert = new SoftAssert();

    }

    @Test
    public void TC10() {
        //login
        loginPage.login(User.defaultUser());

        //create new revenue
        showAllCustomerPage.openCreateRevenuePage();


        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}