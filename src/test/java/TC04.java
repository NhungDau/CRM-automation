import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LoginPage;
import page.ShowAllCustomerPage;

public class TC04 {
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    WebDriver driver;
    SoftAssert softAssert;


    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void TC04() {
        //login
        loginPage.login(User.defaultUser());
        showAllCustomerPage.openCreateCampaignTypePage();

//        softAssert.assertAll();
    }
//        @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }

}
