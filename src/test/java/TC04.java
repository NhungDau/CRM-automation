import model.CampaignType;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;

public class TC04 {
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    CreateCampaignsTypePage createCampaignsTypePage;
    CampaignType campaignType;
    ShowAllCampaignTypePage showAllCampaignTypePage;
    CreateCampaignPage createCampaignPage;
    WebDriver driver;
    SoftAssert softAssert;


    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        createCampaignsTypePage = new CreateCampaignsTypePage(driver);
        showAllCampaignTypePage = new ShowAllCampaignTypePage(driver);
        createCampaignPage = new CreateCampaignPage(driver);
        campaignType = new CampaignType("Sale05");
        softAssert = new SoftAssert();
    }

    @Test
    public void TC04() {
        //login
        loginPage.login(User.defaultUser());

        //access to create campaign type page
        showAllCustomerPage.openCreateCampaignTypePage();

        //Enter campaign type and click Save
        createCampaignsTypePage.enterCampaignTypeName(campaignType.getTypeName());

        createCampaignsTypePage.clickSaveButton();

        //Check newly created campaign type in Show all campaign type page
        showAllCampaignTypePage.searchByCampaignType(campaignType);  //lỗi null??

        softAssert.assertTrue(showAllCampaignTypePage.isSearchResultCorrect(campaignType), "No found newly campaign type");
        System.out.println("New campaign type is created successfully");

        //open Create campaign page
        showAllCampaignTypePage.openCreateCampaignPage();

        //select the new campaign type
        createCampaignPage.selectTypeOptionByCampaignType(campaignType);

        //Verify that new campaign type can be selected
        softAssert.assertEquals(createCampaignPage.getSelectedCampaignType(), campaignType.getTypeName(), "Not found new camaign type");
        //getSelected nhưng lại ra full list type??

        System.out.println("Newly created campaign type in the Type field of create campaign page");

        softAssert.assertAll();
    }
        @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

}
