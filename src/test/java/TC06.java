import model.Campaign;
import model.Customer;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.JsonOutput;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;

public class TC06 {
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    CreateCampaignPage createCampaignPage;
    CustomerInformationPage customerInformationPage;
    AddCampaignIntoCustomerPage addCampaignIntoCustomerPage;
    ShowAllCampaignsPage showAllCampaignsPage;
    CampaignsInformationPage campaignsInformationPage;
    EditCampaignInformationPage editCampaignInformationPage;
    Campaign campaign;
    Campaign campaignUpdated;
    Customer customer;
    WebDriver driver;

    SoftAssert softAssert;

    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        createCampaignPage = new CreateCampaignPage(driver);
        customerInformationPage = new CustomerInformationPage(driver);
        addCampaignIntoCustomerPage = new AddCampaignIntoCustomerPage(driver);
        showAllCampaignsPage = new ShowAllCampaignsPage(driver);
        campaignsInformationPage = new CampaignsInformationPage(driver);
        editCampaignInformationPage = new EditCampaignInformationPage(driver);
        customer = Customer.random();
        campaign = new Campaign("Campaign01", "Sale", "Done", "2024-12-13", "2024-12-14", 100000.0, 10000.0, 50000.0);
        campaignUpdated = new Campaign(null, null, null, null, null, 200.0, null, null);
        softAssert = new SoftAssert();
    }

    @Test
    public void TC06() {
        //login
        loginPage.login(User.defaultUser());

        //create new customer
        //Add new customer
        showAllCustomerPage.clickNewCustomerButton();
        showAllCustomerPage.createCustomer(customer);

        //create new campaign
        showAllCustomerPage.openCreateCampaignPage();

        createCampaignPage.createNewCampaign(campaign); //ko nhap ten duoc??

        createCampaignPage.enterDescription("abc");

        createCampaignPage.clickCreateButton();

        //open customer information page
        showAllCustomerPage.searchCustomerNameByObject(customer); //null???

        showAllCustomerPage.openCustomerInformationByObject(customer);

        //add new campaign
        customerInformationPage.clickAddCampaignButton();

        addCampaignIntoCustomerPage.selectCampainByCampainName(campaign);

        addCampaignIntoCustomerPage.clickToAddButton();

        //Verify customer information display correctly campaign
        softAssert.assertEquals(customerInformationPage.getCampaignInformation(), campaign, "Added campaign is not consistent");
        System.out.println("All columns of new campaign display correctly");

        //Edit campaign information
        customerInformationPage.openShowAllCampaignsPage();

        showAllCampaignsPage.openCampaignInformationPageByCampaignName(campaign.getName());

        campaignsInformationPage.openEditCampaignInformationPage();

        editCampaignInformationPage.editCampaignInformation(campaignUpdated);

        editCampaignInformationPage.getCampaignInformationAfterEdit();

        editCampaignInformationPage.clickSaveButton();

        //Verify campaign information is updated
        softAssert.assertEquals(campaignsInformationPage.getCampaignInformation(), editCampaignInformationPage.getCampaignInformationAfterEdit(), "Update incorrectly");
        System.out.println("Update campaign correctly");

        //Verify that campaign information is updated in Show all campaign
        campaignsInformationPage.openShowAllCampaignsPage();


        //Verify that campaign information is updated in Customer information
        showAllCampaignsPage.openShowAllCustomersPage();

        showAllCustomerPage.searchCustomerNameByObject(customer);

        showAllCustomerPage.openCustomerInformationByObject(customer);

        softAssert.assertEquals(customerInformationPage.getCampaignInformation(), editCampaignInformationPage.getCampaignInformationAfterEdit(), "Update incorrectly");
        System.out.println("Update campaign correctly in customer information page");

    }


//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}
