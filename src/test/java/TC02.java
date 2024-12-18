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

import java.time.LocalDate;
import java.util.Random;


public class TC02 {

    LoginPage loginPage;
    BasePage basePage;
    ShowAllCustomerPage showAllCustomerPage;
    ShowAllCampaignsPage showAllCampaignsPage;
    CampaignsInformationPage campaignsInformationPage;
    AddCustomerIntoCampaignPage addCustomerIntoCampaignPage;
    CustomerInformationPage customerInformationPage;
    EditCustomerInformationPage editCustomerInformationPage;
    CreateCampaignPage createCampaignPage;
    CreateCustomer createCustomer;
    Campaign campaign;
    Customer customer;
    Customer customerUpdatedName;
    String newCustomerName;
    Faker faker;
    Random random;
    LocalDate randomDate;
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        basePage = new BasePage(driver);
        showAllCampaignsPage = new ShowAllCampaignsPage(driver);
        campaignsInformationPage = new CampaignsInformationPage(driver);
        addCustomerIntoCampaignPage = new AddCustomerIntoCampaignPage(driver);
        customerInformationPage = new CustomerInformationPage(driver);
        editCustomerInformationPage = new EditCustomerInformationPage(driver);
        createCampaignPage = new CreateCampaignPage(driver);
        createCustomer = new CreateCustomer(driver);
        customer = Customer.random();
        campaign = new Campaign();
        customerUpdatedName = new Customer();
        faker = new Faker();
        random = new Random();
        randomDate = LocalDate.now().plusDays(random.nextInt(366));
        newCustomerName = faker.name().lastName();
        softAssert = new SoftAssert();
    }

    @Test
    public void TC02() {
        //login
        loginPage.login(User.defaultUser());

        //Add new customer
        showAllCustomerPage.clickNewCustomerButton();

        createCustomer.createCustomer(customer);

        //create a new campaign
        showAllCustomerPage.openCreateCampaignPage();

        campaign.setName(faker.company().catchPhrase());
        campaign.setType((createCampaignPage.listTypeOption().get(random.nextInt(createCampaignPage.listTypeOption().size()))).toString());
        campaign.setStatus(createCampaignPage.listStatusOption().get(random.nextInt(createCampaignPage.listStatusOption().size())).toString());
        campaign.setStartDate(randomDate.toString());
        campaign.setEndDate(randomDate.plusDays(random.nextInt(366)).toString());
        campaign.setExpectedRevenue((double)random.nextInt(9000));
        campaign.setBudgetedCost((double)random.nextInt(9000));
        campaign.setActualCost((double)random.nextInt(9000));

        createCampaignPage.createNewCampaign(campaign);

        createCampaignPage.enterDescription(faker.lorem().sentence());

        createCampaignPage.clickCreateButton();



        showAllCampaignsPage.openCampaignInformationPage();
        campaignsInformationPage.goToAddCustomerIntoCampaignPage();
        addCustomerIntoCampaignPage.selectTheNewestCustomer();
        addCustomerIntoCampaignPage.clickToAddButton();
        campaignsInformationPage.openTheLastCustomerInformationPage();
        customerInformationPage.openEditCustomerInformationPage();
        editCustomerInformationPage.editCustomerName(newCustomerName); //edit

        customerUpdatedName.setName("abc");

        editCustomerInformationPage.clickSaveButton();
        customerUpdatedName.setName(newCustomerName);

        //verify that New customer name display correctly at customer page
        softAssert.assertEquals(customerInformationPage.getCustomerName(), customerUpdatedName.getName(),"Name has not updated");
        System.out.println("Customer name is updated: " + newCustomerName);

//        customerInformationPage.openCampaignInformationPage();
//
//        //Customer name is updated in customer table in Campaign information page
//        softAssert.assertEquals(campaignsInformationPage.getLastCustomerName(), newCustomerName, "Name has not updated");
//        System.out.println("Customer name is updated in customer table: " + newCustomerName);

        softAssert.assertAll();
    }

//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}
