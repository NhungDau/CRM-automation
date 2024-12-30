import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import model.Campaign;
import model.Customer;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.List;
import java.util.Random;

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
    LocalDate today;
    DateTimeFormatter formatter;
    Random random;



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
        campaign = new Campaign();
        campaign1 = new Campaign();
        campaign2 = new Campaign();
        showAllCampaignsPage = new ShowAllCampaignsPage(driver);
        campaignReportPage = new CampaignReportPage(driver);
        today = LocalDate.now();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        random = new Random();





        softAssert = new SoftAssert();


    }

    @Test
    public void TC05() {
        Allure.step("Login successfully");
        //login
        loginPage.login(User.defaultUser());

        //go to create campaign page
        createCampaignPage.openCreateCampaignPage();

        Allure.step("Create new campaign successfully");
        //create campaign

        campaign.setName(faker.company().buzzword()+random.nextInt(100));

        campaign.setType(faker.options().nextElement(createCampaignPage.getListTypeOption()));

        campaign.setStatus(faker.options().nextElement(createCampaignPage.getListStatusOption()));

        campaign.setStartDate(String.valueOf(today));

        campaign.setEndDate(String.valueOf(today.plusDays(15)));

        campaign.setExpectedRevenue(random.nextInt(9000));
        campaign.setBudgetedCost(random.nextInt(9000));
        campaign.setActualCost(random.nextInt(9000));

        campaign.setDescription(faker.lorem().sentence());


        createCampaignPage.createNewCampaign(campaign);

        Allure.step("Search newly cretaed campaign successfully");
        //search newly created campaign

        showAllCampaignsPage.searchByCampaignName(campaign.getName());

        showAllCampaignsPage.getCampaignInformation();

        Allure.step("Verity the newly created campaign can be search successfully in show all campaign page");
        // check whether newly created campaign can be searched
        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getName()
                                ,campaign.getName()
                                ,"Campaign name is not consistent");

        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getType()
                                , campaign.getType()
                                , "Campaign type is not consistent");

        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getStatus()
                                , campaign.getStatus()
                                ,"Status is not consistent");

        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getStartDate()
                                , campaign.getStartDate()
                                ,"Start date is not consistent");

        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getEndDate()
                                , campaign.getEndDate()
                                , "End date is not consistent");

        //go to report page
        showAllCampaignsPage.openCampaignReportsPage();

        //search newly created campaign
        campaignReportPage.searchByCampaignName(campaign.getName());

        campaignReportPage.getCampaignInformation();

        Allure.step("Verity the newly created campaign can be search successfully in campaign report page");
        //check whether newly created campaign can be searched in campaign report page

        softAssert.assertEquals(campaignReportPage.getCampaignInformation().getName()
                ,campaign.getName()
                ,"Campaign name is not consistent");

        softAssert.assertEquals(campaignReportPage.getCampaignInformation().getType()
                , campaign.getType()
                , "Campaign type is not consistent");

        softAssert.assertEquals(campaignReportPage.getCampaignInformation().getStatus()
                , campaign.getStatus()
                ,"Status is not consistent");




        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
