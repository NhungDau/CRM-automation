import com.github.javafaker.Faker;
import model.Campaign;
import model.Customer;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;

import java.time.Duration;

public class TC05 {


    WebDriver driver;
    LoginPage loginPage;
    CreateCampaignPage createCampaignPage;
    Campaign campaign;
    Campaign campaign1;
    Campaign campaign2;
    ShowAllCampaignsPage showAllCampaignsPage;
    CampaignReportPage campaignReportPage;
    Faker faker;
    SoftAssert softAssert;

    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginPage = new LoginPage(driver);
        faker = new Faker();
        createCampaignPage = new CreateCampaignPage(driver);
        campaign = new Campaign(faker.company().catchPhrase(), "Sale", "Done", "2024-12-13", "2024-12-14", 356.0, 54.0, 88.4);
        campaign1 = new Campaign();
        campaign2 = new Campaign();
        showAllCampaignsPage = new ShowAllCampaignsPage(driver);
        campaignReportPage = new CampaignReportPage(driver);

        softAssert = new SoftAssert();


    }

    @Test
    public void TC05() {
        //login
        loginPage.login(User.defaultUser());

        //go to create campaign page
        createCampaignPage.openCreateCampaignPage();

        //create campaign
        createCampaignPage.createNewCampaign(campaign);

        createCampaignPage.enterDescription("campaign");

        createCampaignPage.clickCreateButton();

        //search newly created campaign

        showAllCampaignsPage.searchByCampaignName(campaign.getName());

        showAllCampaignsPage.getCampaignInformation();

        // check whether newly created campaign can be searched
//        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getName()
//                                ,campaign.getName()
//                                ,"Campaign name is not consistent");
//
//        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getType()
//                                , campaign.getType()
//                                , "Campaign type is not consistent");
//
//        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getStatus()
//                                , campaign.getStatus()
//                                ,"Status is not consistent");
//
//        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getStartDate()
//                                , campaign.getStartDate()
//                                ,"Start date is not consistent");
//
//        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getEndDate()
//                                , campaign.getEndDate()
//                                , "End date is not consistent");

        softAssert.assertEquals(campaign,showAllCampaignsPage.getCampaignInformation(),"Campaign information is not consistent");
        //go to report page
        showAllCampaignsPage.openCampaignReportsPage();

        //search newly created campaign
        campaignReportPage.searchByCampaignName(campaign.getName());

        campaignReportPage.getCampaignInformation();

        //check whether newly created campaign can be searched in campaign report page
        softAssert.assertEquals(campaign,campaignReportPage.getCampaignInformation(),"Campaign information is not consistent");

//        softAssert.assertEquals(campaignReportPage.getCampaignInformation().getName()
//                ,campaign.getName()
//                ,"Campaign name is not consistent");
//
//        softAssert.assertEquals(campaignReportPage.getCampaignInformation().getType()
//                , campaign.getType()
//                , "Campaign type is not consistent");
//
//        softAssert.assertEquals(campaignReportPage.getCampaignInformation().getStatus()
//                , campaign.getStatus()
//                ,"Status is not consistent");
//



        softAssert.assertAll();
    }

//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}
