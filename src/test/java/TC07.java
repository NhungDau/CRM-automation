import com.github.javafaker.Faker;
import model.Campaign;
import model.Customer;
import model.OpportunityInformation;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;

import java.time.Duration;
import java.util.Random;

public class TC07 {

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
    CampaignsInformationPage campaignsInformationPage;
    AddCustomerIntoCampaignPage addCustomerIntoCampaignPage;
    Faker faker;

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
        campaignsInformationPage = new CampaignsInformationPage(driver);
        addCustomerIntoCampaignPage = new AddCustomerIntoCampaignPage(driver);
        softAssert = new SoftAssert();
        customer = Customer.random();
        random = new Random();
        faker = new Faker();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");

    }

    @Test
    public void TC03() {
        //login
        loginPage.login(User.defaultUser());


        //create new customer
        showAllCustomerPage.clickNewCustomerButton();
        createCustomer.createCustomer(customer);

        //create new campagin
        //go to create campaign page
        createCampaignPage.openCreateCampaignPage();

        //create campaign
        createCampaignPage.getListTypeOption();



        createCampaignPage.createNewCampaign(campaign);


        createCampaignPage.enterDescription("campaign");

        createCampaignPage.clickCreateButton();

        //search newly created campaign and go to the campaign information page
        showAllCampaignsPage.searchByCampaignName(campaign.getName());

        showAllCampaignsPage.openCampaignInformationPageByCampaignName(campaign.getName());

        //go to add customer in to campaign page
        campaignsInformationPage.goToAddCustomerIntoCampaignPage();

        //select customer








        //check the newly created campaign information


        softAssert.assertAll();
    }

//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}




