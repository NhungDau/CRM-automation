import model.Customer;
import model.User;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ShowAllCustomerPage;

import static constant.Driver.driver;


public class TC01 {

    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    Customer customer;

    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        loginPage = new LoginPage();
        showAllCustomerPage = new ShowAllCustomerPage();
        driver.manage().window().maximize();
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");

        customer = Customer.random();
    }

    @Test
    public void TC02() {
        loginPage.login(User.defaultUser());

        showAllCustomerPage.createCustomer(customer);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
