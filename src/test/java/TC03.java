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


public class TC03 {

    WebDriver driver;
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    CustomerInformationPage customerInformationPage;
    CreateCustomer createCustomer;
    CreateOpportunityPage createOpportunityPage;
    OpportunityInformation opportunityInformation1;
    OpportunityInformation opportunityInformation2;
    Random random;
    Customer customer;

    Integer index;

    SoftAssert softAssert;

    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        createOpportunityPage = new CreateOpportunityPage(driver);
        customerInformationPage = new CustomerInformationPage(driver);
        opportunityInformation1 = new OpportunityInformation();
        opportunityInformation2 = new OpportunityInformation();
        createCustomer = new CreateCustomer(driver);

        softAssert = new SoftAssert();

        customer = Customer.random();
        random = new Random();
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

        //open the newly created customer to add new opportunity
        showAllCustomerPage.clickGoToLastPageButton();
        showAllCustomerPage.openLastCustomer();

        //add opportunity
        customerInformationPage.clickAddOpportunityButton();

            //get random index by product name
        index = random.nextInt(createOpportunityPage.totalProductInPage());

        createOpportunityPage.selectOpportunityByIndex(index);

        createOpportunityPage.getOpportunityInformation(index);
        opportunityInformation1.setStatus(createOpportunityPage.getOpportunityInformation(index).getStatus());
        opportunityInformation1.setProductName(createOpportunityPage.getOpportunityInformation(index).getProductName());
        opportunityInformation1.setPrice(createOpportunityPage.getOpportunityInformation(index).getPrice());

        createOpportunityPage.clickAddOpportunityButton();

        //get opportunity in customer information page
        customerInformationPage.getLastOpportunityInformation();
        opportunityInformation2.setStatus(customerInformationPage.getLastOpportunityInformation().getStatus());
        opportunityInformation2.setProductName(customerInformationPage.getLastOpportunityInformation().getProductName());
        opportunityInformation2.setPrice(customerInformationPage.getLastOpportunityInformation().getPrice());

        softAssert.assertEquals(opportunityInformation1, opportunityInformation2,
                                                            "Opportunity information is not consistent");


        softAssert.assertAll();
    }

//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}
