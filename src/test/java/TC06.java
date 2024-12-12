import model.Campaign;
import model.Customer;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.CampaignsInformationPage;
import page.CreateCampaignPage;
import page.LoginPage;
import page.ShowAllCustomerPage;

public class TC06 {
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    CreateCampaignPage createCampaignPage;
    CampaignsInformationPage campaignsInformationPage;
    Campaign campaign;
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
        campaignsInformationPage = new CampaignsInformationPage(driver);
        customer = Customer.random();
        campaign = new Campaign("Campaign01", "Sale", "Done", "2024-12-13", "2024-12-14", 100000.0, 10000.0, 50000.0);
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

        createCampaignPage.createNewCampaign(campaign);

        createCampaignPage.enterDescription("abc");

        createCampaignPage.clickCreateButton();

        //open customer information page
        showAllCustomerPage.searchCustomerNameByObject(customer); //null???

        showAllCustomerPage.openCustomerInformationByObject(customer);


    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
