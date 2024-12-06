import model.Customer;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import page.ShowAllCustomerPage;


public class TC02 {

    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    Customer customer;
    WebDriver driver;


    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        customer = Customer.random();
        driver.manage().window().maximize();
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");


    }

    @Test
    public void TC02() {
        loginPage.login(User.defaultUser());
        showAllCustomerPage.createCustomer(customer);
        //showAllCustomerPage.openShowAllCampaignsPage();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
