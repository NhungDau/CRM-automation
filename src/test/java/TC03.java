import model.Customer;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;


public class TC03 {

    WebDriver driver;
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    CustomerInformationPage customerInformationPage;
    CreateOpportunityPage createOpportunityPage;

    SoftAssert softAssert;

    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        createOpportunityPage = new CreateOpportunityPage(driver);
        customerInformationPage = new CustomerInformationPage(driver);

        driver.manage().window().maximize();
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");

    }

    @Test
    public void TC03() {
        //login
        loginPage.login(User.defaultUser());

        //go to customer information page
        showAllCustomerPage.getCustomerNameByIndex(4);
        showAllCustomerPage.clickCustomerNameByIndex(4);

        //add opportunity
        customerInformationPage.clickAddOpportunityButton();

        createOpportunityPage.createOpportunityByIndex(12);
        createOpportunityPage.getOpportunityInformationopportunityInformation(12);
        createOpportunityPage.clickAddOpportunityButton();

        //get opportunity in customer information page
        customerInformationPage.getLastOpportunityInformation();
        softAssert.assertEquals(customerInformationPage.getLastOpportunityInformation(),
                                createOpportunityPage.getOpportunityInformationopportunityInformation(12),
                                "Opportunity information is not consistent");


        softAssert.assertAll();
    }

//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}
