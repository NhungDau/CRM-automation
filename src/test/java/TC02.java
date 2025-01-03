import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import model.Campaign;
import model.Customer;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
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
    Customer customerAfterUpdate;
    Customer customerInCustomerInformationPage;
    Customer customerInCampaignInformationPage;
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
        customerAfterUpdate = new Customer();
        customerInCustomerInformationPage = new Customer();
        customerInCampaignInformationPage = new Customer();
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
        Allure.step("Access to create Campaign page, and create new campaign.");
        showAllCustomerPage.openCreateCampaignPage();

        campaign.setName(faker.company().catchPhrase()+random.nextInt(100));
        campaign.setType(faker.options().nextElement(createCampaignPage.getListTypeOption()));
        campaign.setStatus(faker.options().nextElement(createCampaignPage.getListStatusOption()));
        campaign.setStartDate(randomDate.toString());
        campaign.setEndDate(randomDate.plusDays(random.nextInt(366)).toString());
        campaign.setExpectedRevenue(random.nextInt(9000));
        campaign.setBudgetedCost(random.nextInt(9000));
        campaign.setActualCost(random.nextInt(9000));
        campaign.setDescription(faker.lorem().sentence());

        createCampaignPage.createNewCampaign(campaign);

        //Add new customer into new campaign
        Allure.step("Add new customer into new campaign.");

        showAllCampaignsPage.searchByCampaignName(campaign.getName());

        showAllCampaignsPage.openCampaignInformationPageByCampaignName(campaign.getName());

        campaignsInformationPage.goToAddCustomerIntoCampaignPage();

        addCustomerIntoCampaignPage.selectCustomerByName(customer.getName());

        addCustomerIntoCampaignPage.clickToAddButton();

        //Edit customer information
        Allure.step("Access to Customer Information page, edit customer name.");

        campaignsInformationPage.openCustomerInformationPageByName(customer.getName());

        customerInformationPage.openEditCustomerInformationPage();

        //edit customer name
        customerUpdatedName.setName(faker.name().fullName());
        customerUpdatedName.setPhone(null);
        customerUpdatedName.setAddress(null);
        customerUpdatedName.setEmail(null);

        editCustomerInformationPage.editCustomerInformation(customerUpdatedName);

        //get new customer information
        customerAfterUpdate = editCustomerInformationPage.getCustomerInformation();

        editCustomerInformationPage.clickSaveButton();

        //Verify that customer name is updated in customer information page
        Allure.step("Verify that customer name is updated in customer information page.");

        customerInCustomerInformationPage = customerInformationPage.getCustomerInformation();

        softAssert.assertEquals(customerInCustomerInformationPage, customerAfterUpdate, "Customer information isn't updated correctly in Customer Information page.");
        System.out.println("Customer information is updated correctly in Customer Information page.");

        //Go to Campaign information page
        customerInformationPage.openShowAllCampaignsPage();

        showAllCampaignsPage.searchByCampaignName(campaign.getName());

        showAllCampaignsPage.openCampaignInformationPageByCampaignName(campaign.getName());

        //Verify that customer name is updated in campaign information page
        Allure.step("Verify that customer name is updated in campaign information page.");

        customerInCampaignInformationPage = campaignsInformationPage.getCustomerInformation();

        softAssert.assertEquals(customerInCampaignInformationPage, customerAfterUpdate, "Customer information isn't updated correctly in Campaign Information page.");
        System.out.println("Customer information is updated correctly in Campaign Information page.");

        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
