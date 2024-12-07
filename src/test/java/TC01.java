import model.Customer;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;




public class TC01 {

    WebDriver driver;
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    Customer customer;
    CreateOrderPage createOrderPage;
    CustomerInformationPage customerInformationPage;
    BasePage basePage;
    ShowAllOrdersPage showAllOrdersPage;
    OrderInformationPage orderInformationPage;

    SoftAssert softAssert;

    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        createOrderPage = new CreateOrderPage(driver);
        customerInformationPage = new CustomerInformationPage(driver);
        basePage = new BasePage(driver);
        showAllOrdersPage = new ShowAllOrdersPage(driver);
        orderInformationPage = new OrderInformationPage(driver);
        driver.manage().window().maximize();
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");

        customer = Customer.random();
    }

    @Test
    public void TC02() {
        loginPage.login(User.defaultUser());
        showAllCustomerPage.clickNewCustomerButton();
        showAllCustomerPage.createCustomer(customer);
        showAllCustomerPage.clickGoToLastPageButton();
        showAllCustomerPage.openLastCustomer();
        customerInformationPage.clickAddOrderButton();
        createOrderPage.addOrderByIndex();
        basePage.openShowAllOrdersPage();
        showAllOrdersPage.searchByCustomerName(customer.getName());
        showAllOrdersPage.clickLastCustomerName();
        customerInformationPage.clickLastPaymentDate();
        orderInformationPage.getCustomerOderInformation();

        softAssert.assertEquals(createOrderPage.getProductOrderInformation(),orderInformationPage.getProductOrderInformation(),"Product information is not correct");
        softAssert.assertAll();

    }

//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}
