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

        //create new campagin
        //go to create campaign page
        showAllCustomerPage.openCreateCampaignPage();

        //create campaign
        createCampaignPage.getListTypeOption();

        campaign.setName(faker.company().catchPhrase());
        campaign.setType(createCampaignPage.getListTypeOption().get(random.nextInt(createCampaignPage.listTypeOption().size())).toString());
        campaign.setStatus(createCampaignPage.getListStatusOption().get(random.nextInt(createCampaignPage.listStatusOption().size())).toString());
        campaign.setStartDate(today.format(formatter));
        campaign.setEndDate(today.plusDays(random.nextInt(366)).format(formatter));
        campaign.setExpectedRevenue(random.nextDouble());
        campaign.setBudgetedCost(random.nextDouble());
        campaign.setActualCost(random.nextDouble());

        createCampaignPage.createNewCampaign(campaign);


        createCampaignPage.enterDescription("campaign");

        createCampaignPage.clickCreateButton();

        //search newly created campaign and go to the campaign information page
        showAllCampaignsPage.searchByCampaignName(campaign.getName());

        showAllCampaignsPage.openCampaignInformationPageByCampaignName(campaign.getName());

        //go to add customer in to campaign page
        campaignsInformationPage.goToAddCustomerIntoCampaignPage();

        //select newly created customer
        addCustomerIntoCampaignPage.selectTheNewestCustomer();

        //click add button
        addCustomerIntoCampaignPage.clickToAddButton();

        //click customer name to open customer information page
        campaignsInformationPage.openTheLastCustomerInformationPage();

        //get campaign information
        customerInformationPage.getCampaignInformation();

        //verify the campaign information is displayed same as when created
        customerInformationPage.getCampaignInformation();

        campaign2.setName(customerInformationPage.getCampaignInformation().getName());
        campaign2.setType(customerInformationPage.getCampaignInformation().getType());
        campaign2.setStatus(customerInformationPage.getCampaignInformation().getStatus());
        campaign2.setStartDate(customerInformationPage.getCampaignInformation().getStartDate());
        campaign2.setEndDate(customerInformationPage.getCampaignInformation().getEndDate());
        campaign2.setExpectedRevenue(customerInformationPage.getCampaignInformation().getExpectedRevenue());
        campaign2.setBudgetedCost(customerInformationPage.getCampaignInformation().getBudgetedCost());
        campaign2.setActualCost(customerInformationPage.getCampaignInformation().getActualCost());


        softAssert.assertEquals(campaign,campaign2,"Campaign information is not consistent");

        softAssert.assertAll();
    }

//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}




