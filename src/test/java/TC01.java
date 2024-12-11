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

        softAssert = new SoftAssert();
        customer = Customer.random();
    }

    @Test
    public void TC01() {
        //login
        loginPage.login(User.defaultUser());

        //create new customer
        showAllCustomerPage.clickNewCustomerButton();
        showAllCustomerPage.createCustomer(customer);

        //open the newly created customer to add new order
        showAllCustomerPage.clickGoToLastPageButton();
        showAllCustomerPage.openLastCustomer();
        customerInformationPage.clickAddOrderButton();
        createOrderPage.addOrderByIndex();
        createOrderPage.getProductOrderInformation();

        //step 4.verify new order created successfully and display in customer information page
        customerInformationPage.isOrderDisplay();
        customerInformationPage.getPrice();
        customerInformationPage.getCustomerName();
        softAssert.assertEquals(customerInformationPage.getPaymentDate(),createOrderPage.getProductOrderInformation().getPaymentDate(),"Payment date is not correct");
        softAssert.assertEquals(customerInformationPage.getPrice(),createOrderPage.getProductOrderInformation().getProductPrice(),"Price is not correct");

//        basePage.openShowAllOrdersPage();
//        showAllOrdersPage.searchByCustomerName(customer.getName());
//        showAllOrdersPage.clickLastCustomerName();
//        customerInformationPage.clickLastPaymentDate();
////        orderInformationPage.getCustomerOderInformation();
////        System.out.println("Create Order: " + createOrderPage.getProductOrderInformation());
////        System.out.println("Order Information Page: " + orderInformationPage.getProductOrderInformation());
//
//        //verify after add new order in create order page, product name/price/quanity/total price are same in oder in formation page
//        softAssert.assertEquals(createOrderPage.getProductOrderInformation(),orderInformationPage.getProductOrderInformation(),"Product information is not correct");
//        softAssert.assertAll();

    }

//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}
