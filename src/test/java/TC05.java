import model.Campaign;
import model.Customer;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;

public class TC05 {


    WebDriver driver;
    LoginPage loginPage;
    CreateCampaignPage createCampaignPage;
    Campaign campaign;


    SoftAssert softAssert;

    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        createCampaignPage = new CreateCampaignPage(driver);
        campaign = new Campaign("Super sale", "Sale", "Done", "2024-12-13", "2024-12-14", 356.0, 54.0, 88.4);


        driver.manage().window().maximize();
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");


    }

    @Test
    public void TC03() {
        //login
        loginPage.login(User.defaultUser());

        //go to create campaign page
        createCampaignPage.openCreateCampaignPage();

        //create campaign
        createCampaignPage.createNewCampaign(campaign);

        createCampaignPage.enterDescription("campaign");

        createCampaignPage.clickCreateButton();

        //search newly created campaign




        softAssert.assertAll();
    }

//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}
