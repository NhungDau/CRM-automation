import model.Customer;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;


public class TC02 {

    LoginPage loginPage;
    BasePage basePage;
    ShowAllCustomerPage showAllCustomerPage;
    ShowAllCampaignsPage showAllCampaignsPage;
    CampaignsInformationPage campaignsInformationPage;
    AddCustomerIntoCampaignPage addCustomerIntoCampaignPage;
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
        basePage = new BasePage(driver);
        showAllCampaignsPage = new ShowAllCampaignsPage(driver);
        campaignsInformationPage = new CampaignsInformationPage(driver);
        addCustomerIntoCampaignPage = new AddCustomerIntoCampaignPage(driver);
        customer = Customer.random();

        softAssert = new SoftAssert();
    }

    @Test
    public void TC02() {
        loginPage.login(User.defaultUser());
        showAllCustomerPage.clickNewCustomerButton();
        showAllCustomerPage.createCustomer(customer);
        basePage.openShowAllCampaignsPage();
        showAllCampaignsPage.openCampaignInformationPage();
        campaignsInformationPage.goToAddCustomerIntoCampaignPage();
        addCustomerIntoCampaignPage.selectTheNewestCustomer();
        addCustomerIntoCampaignPage.clickToAddButton();
        campaignsInformationPage.openTheLastCustomerInformationPage();

//        softAssert.assertAll();
    }
//
//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}
