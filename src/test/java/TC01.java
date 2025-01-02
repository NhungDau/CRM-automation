import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import model.Customer;
import model.ProductOrderInformation;
import model.User;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;

import java.util.Random;


public class TC01 {

    WebDriver driver;
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    CreateCustomer createCustomer;
    Customer customer;
    CreateOrderPage createOrderPage;
    CustomerInformationPage customerInformationPage;
    BasePage basePage;
    ShowAllOrdersPage showAllOrdersPage;
    OrderInformationPage orderInformationPage;
    ProductOrderInformation productOrderInformation1;
    ProductOrderInformation productOrderInformation2;
    ProductOrderInformation productOrderInformation3;
    Random random;
    SoftAssert softAssert;

    Integer index;

    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        createOrderPage = new CreateOrderPage(driver);
        customerInformationPage = new CustomerInformationPage(driver);
        createCustomer = new CreateCustomer(driver);
        basePage = new BasePage(driver);
        showAllOrdersPage = new ShowAllOrdersPage(driver);
        orderInformationPage = new OrderInformationPage(driver);
        productOrderInformation1 = new ProductOrderInformation();
        productOrderInformation2 = new ProductOrderInformation();
        productOrderInformation3 = new ProductOrderInformation();

        driver.manage().window().maximize();
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");

        random = new Random();
        softAssert = new SoftAssert();
        customer = Customer.random();
    }

    @Test
    public void TC01() {
        //login
        loginPage.login(User.defaultUser());

        //create new customer
        showAllCustomerPage.clickNewCustomerButton();

        createCustomer.createCustomer(customer);

        Allure.step("Add new order");
        //open the newly created customer to add new order
        showAllCustomerPage.clickGoToLastPageButton();
        showAllCustomerPage.openLastCustomer();

        customerInformationPage.clickAddOrderButton();

        index = random.nextInt(createOrderPage.getTotalProduct());
        createOrderPage.selectProductByRandomIndex(index);

        createOrderPage.getProductOrderInformation(index);
        productOrderInformation1.setProductName(createOrderPage.getProductOrderInformation(index).getProductName());
        productOrderInformation1.setProductPrice(createOrderPage.getProductOrderInformation(index).getProductPrice());
        productOrderInformation1.setProductQuantity(createOrderPage.getProductOrderInformation(index).getProductQuantity());
        productOrderInformation1.setPaymentDate(createOrderPage.getProductOrderInformation(index).getPaymentDate());
        productOrderInformation1.setTotalPrice(productOrderInformation1.getProductPrice()*productOrderInformation1.getProductQuantity());


        createOrderPage.clickCreateOrderButton();

        Allure.step("Verify new oder is displayed in customer information page");
        //step 4.verify new order created successfully and display in customer information page
        customerInformationPage.getLatestOrderInformation();


        productOrderInformation2.setPaymentDate(customerInformationPage.getLatestOrderInformation().getPaymentDate());
        productOrderInformation2.setTotalPrice(customerInformationPage.getLatestOrderInformation().getTotalPrice());

        softAssert.assertEquals(productOrderInformation2.getPaymentDate()
                                , productOrderInformation1.getPaymentDate()
                                ,"Payment date is not correct");
        softAssert.assertEquals(productOrderInformation2.getTotalPrice()
                                , productOrderInformation1.getTotalPrice()
                                ,"Price is not correct");


        Allure.step("View last order information");
        //go to order information page to view lastest order information
        customerInformationPage.clickLastPaymentDate();

        //get order information
        orderInformationPage.getCustomerOrderInformation();

        productOrderInformation3.setProductName(orderInformationPage.getCustomerOrderInformation().getProductName());

        productOrderInformation3.setProductPrice(orderInformationPage.getCustomerOrderInformation().getProductPrice());

        productOrderInformation3.setProductQuantity(orderInformationPage.getCustomerOrderInformation().getProductQuantity());

        productOrderInformation3.setTotalPrice(orderInformationPage.getCustomerOrderInformation().getTotalPrice());

        productOrderInformation3.setPaymentDate(orderInformationPage.getCustomerOrderInformation().getPaymentDate());

        Allure.step("Verify product information is displayed correctly between order information page and when create");
        //verify after add new order in create order page, product name/price/quanity/total price are same in oder information page
        softAssert.assertEquals(productOrderInformation1,productOrderInformation3,"Product information is not correct");
        softAssert.assertAll();

    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}