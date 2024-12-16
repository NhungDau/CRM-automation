import com.github.javafaker.Faker;
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
    CustomerInformationPage customerInformationPage;
    EditCustomerInformationPage editCustomerInformationPage;
    CreateCustomer createCustomer;
    Customer customer;
    Customer customerUpdatedName;
    String newCustomerName;
    Faker faker;
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
        createCustomer = new CreateCustomer(driver);
        customer = Customer.random();
        customerUpdatedName = new Customer();
        faker = new Faker();
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


        showAllCustomerPage.openShowAllCampaignsPage();
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
