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

import java.time.Duration;

public class TC06 {
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    CreateCampaignPage createCampaignPage;
    CustomerInformationPage customerInformationPage;
    AddCampaignIntoCustomerPage addCampaignIntoCustomerPage;
    ShowAllCampaignsPage showAllCampaignsPage;
    CampaignsInformationPage campaignsInformationPage;
    EditCampaignInformationPage editCampaignInformationPage;
    CreateCustomer createCustomer;
    Campaign campaign;
    Campaign campaignUpdated;
    Campaign campaignAfterEdit;
    Customer customer;
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
        createCampaignPage = new CreateCampaignPage(driver);
        customerInformationPage = new CustomerInformationPage(driver);
        addCampaignIntoCustomerPage = new AddCampaignIntoCustomerPage(driver);
        createCustomer = new CreateCustomer(driver);
        showAllCampaignsPage = new ShowAllCampaignsPage(driver);
        campaignsInformationPage = new CampaignsInformationPage(driver);
        editCampaignInformationPage = new EditCampaignInformationPage(driver);
        customer = Customer.random();
        campaign = new Campaign("Campaign01", "Sale", "Done", "2024-12-13", "2024-12-14", 10000.0, 1000.0, 5000.0);
        campaignUpdated = new Campaign(null, null, null, null, null, 200.0, null, null);
        campaignAfterEdit = new Campaign();
        softAssert = new SoftAssert();
    }

    @Test
    public void TC06() {
        //login
        loginPage.login(User.defaultUser());

        //create new customer
        showAllCustomerPage.clickNewCustomerButton();

        createCustomer.createCustomer(customer);

        //create new campaign
        showAllCustomerPage.openCreateCampaignPage();

        createCampaignPage.createNewCampaign(campaign);

        createCampaignPage.enterDescription("abc");

        createCampaignPage.clickCreateButton();

        showAllCampaignsPage.openShowAllCustomersPage();

        //open customer information page
        showAllCustomerPage.searchCustomerByName(customer);

        showAllCustomerPage.openCustomerInformationByName(customer);

        //add new campaign
        customerInformationPage.clickAddCampaignButton();

        addCampaignIntoCustomerPage.selectCampainByCampainName(campaign.getName());

        addCampaignIntoCustomerPage.clickToAddButton();

        //Verify customer information display correctly campaign
        softAssert.assertEquals(customerInformationPage.getCampaignInformation(), campaign, "Added campaign is not consistent");
        System.out.println("All columns of new campaign display correctly");

        //Edit campaign information
        customerInformationPage.openShowAllCampaignsPage();

        showAllCampaignsPage.openCampaignInformationPageByCampaignName(campaign.getName());

        campaignsInformationPage.openEditCampaignInformationPage();

        editCampaignInformationPage.editCampaignInformation(campaignUpdated);

        campaignAfterEdit = editCampaignInformationPage.getCampaignInformationAfterEdit();

        editCampaignInformationPage.clickSaveButton();

        //Verify campaign information is updated
        softAssert.assertEquals(campaignsInformationPage.getCampaignInformation(), campaignAfterEdit, "Update incorrectly");
        System.out.println("Update campaign correctly");

        //Verify that campaign information is updated in Show all campaign
        campaignsInformationPage.openShowAllCampaignsPage();

        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getName(), campaignAfterEdit.getName(),"Campaign name is not updated");
        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getType(), campaignAfterEdit.getType(),"Campaign type is not updated");
        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getStatus(), campaignAfterEdit.getStatus(),"Campaign status is not updated");
        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getStartDate(), campaignAfterEdit.getStartDate(),"Campaign start date is not updated");
        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getEndDate(), campaignAfterEdit.getEndDate(), "Campaign end date is not updated");
        System.out.println("Update campaign correctly in Show All Campaign page");

        //Verify that campaign information is updated in Customer information
        showAllCampaignsPage.openShowAllCustomersPage();

        showAllCustomerPage.searchCustomerByName(customer);

        showAllCustomerPage.openCustomerInformationByName(customer);

        softAssert.assertEquals(customerInformationPage.getCampaignInformation(), campaignAfterEdit, "Update incorrectly");
        System.out.println("Update campaign correctly in Customer Information page");

    }


    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
