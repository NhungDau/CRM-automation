import com.github.javafaker.Faker;
import model.Campaign;
import model.Customer;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TC09 {

    WebDriver driver;
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    CustomerInformationPage customerInformationPage;
    CreateCustomer createCustomer;
    Random random;
    Customer customer;
    CreateCampaignPage createCampaignPage;
    ShowAllCampaignsPage showAllCampaignsPage;
    Campaign campaign;
    Campaign campaign2;
    CampaignsInformationPage campaignsInformationPage;
    AddCustomerIntoCampaignPage addCustomerIntoCampaignPage;
    Faker faker;
    LocalDate today;
    DateTimeFormatter formatter;

    SoftAssert softAssert;
    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        faker = new Faker();
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        customerInformationPage = new CustomerInformationPage(driver);
        createCustomer = new CreateCustomer(driver);
        createCampaignPage = new CreateCampaignPage(driver);
        showAllCampaignsPage = new ShowAllCampaignsPage(driver);
        campaign = new Campaign();
        campaign2 = new Campaign();
        campaignsInformationPage = new CampaignsInformationPage(driver);
        addCustomerIntoCampaignPage = new AddCustomerIntoCampaignPage(driver);
        softAssert = new SoftAssert();
        customer = Customer.random();
        random = new Random();
        faker = new Faker();
        today = LocalDate.now();
        formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");

    }

    @Test
    public void TC07() {
        //login
        loginPage.login(User.defaultUser());


        //create new customer
        showAllCustomerPage.clickNewCustomerButton();
        createCustomer.createCustomer(customer);

        //search newly created customer and go to customer information page
        showAllCampaignsPage.searchByCampaignName(campaign.getName());

        showAllCustomerPage.


        softAssert.assertAll();
    }

//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}




