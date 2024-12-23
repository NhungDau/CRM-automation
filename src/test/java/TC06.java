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

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class TC06 {
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    CreateCampaignPage createCampaignPage;
    CustomerInformationPage customerInformationPage;
    AddCampaignIntoCustomerPage addCampaignIntoCustomerPage;
    ShowAllCampaignsPage showAllCampaignsPage;
    CampaignsInformationPage campaignsInformationPage;
    EditCampaignInformationPage editCampaignInformationPage;
    CreateCustomer createCustomer;
    Campaign campaign;
    Campaign campaignUpdated;
    Campaign campaignAfterEdit;
    Campaign campaignInCustomerInformationPage;
    Campaign campaignInCampaignInformationPage;
    Customer customer;
    WebDriver driver;
    Faker faker;
    Random random;
    String formattedValue;
    LocalDate randomDate;
    List<String> typeOption;

    SoftAssert softAssert;

    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        createCampaignPage = new CreateCampaignPage(driver);
        customerInformationPage = new CustomerInformationPage(driver);
        addCampaignIntoCustomerPage = new AddCampaignIntoCustomerPage(driver);
        createCustomer = new CreateCustomer(driver);
        showAllCampaignsPage = new ShowAllCampaignsPage(driver);
        campaignsInformationPage = new CampaignsInformationPage(driver);
        editCampaignInformationPage = new EditCampaignInformationPage(driver);
        customer = Customer.random();
        random = new Random();
        faker = new Faker();
        campaign = new Campaign();
        campaignUpdated = new Campaign();
        campaignAfterEdit = new Campaign();
        campaignInCustomerInformationPage = new Campaign();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DecimalFormat df = new DecimalFormat("###.#");
        formattedValue = df.format(random.nextDouble());
        randomDate = LocalDate.now().plusDays(random.nextInt(366));

        softAssert = new SoftAssert();
    }

    @Test
    public void TC06() {
        //login
        loginPage.login(User.defaultUser());

        //create new customer
        showAllCustomerPage.clickNewCustomerButton();

        createCustomer.createCustomer(customer);

        //create new campaign
        showAllCustomerPage.openCreateCampaignPage();

        campaign.setName(faker.company().buzzword());
        //c1
        typeOption = createCampaignPage.getListTypeOption();
        //c2
        faker.options().nextElement(typeOption);
        //c3
//        campaign.setType((createCampaignPage.getListTypeOption().get(random.nextInt(createCampaignPage.getListTypeOption().size()))).toString());
        campaign.setType(faker.options().nextElement(typeOption));
//        campaign.setStatus(createCampaignPage.getListStatusOption().get(random.nextInt(createCampaignPage.getListStatusOption().size())).toString());
        campaign.setStatus(faker.options().nextElement(createCampaignPage.getListStatusOption()));
        campaign.setStartDate(randomDate.toString());
        campaign.setEndDate(randomDate.plusDays(random.nextInt(366)).toString());
        campaign.setExpectedRevenue(Double.parseDouble(formattedValue));
        campaign.setBudgetedCost(Double.parseDouble(formattedValue));
        campaign.setActualCost(Double.parseDouble(formattedValue));
        campaign.setDescription(faker.lorem().sentence());

        createCampaignPage.createNewCampaign(campaign);

//        createCampaignPage.enterDescription(faker.lorem().sentence());
//
//        createCampaignPage.clickCreateButton();

        showAllCampaignsPage.openShowAllCustomersPage();

        //open customer information page
        showAllCustomerPage.searchCustomerByName(customer);

        showAllCustomerPage.openCustomerInformationByName(customer);

        //add new campaign
        customerInformationPage.clickAddCampaignButton();

        addCampaignIntoCustomerPage.selectCampainByCampainName(campaign.getName());

        addCampaignIntoCustomerPage.clickToAddButton();

        //Verify customer information display correctly campaign
        softAssert.assertEquals(customerInformationPage.getCampaignInformation(), campaign, "Added campaign is not consistent");
        System.out.println("All columns of new campaign display correctly");

        //Edit campaign information
        customerInformationPage.openShowAllCampaignsPage();

        showAllCampaignsPage.openCampaignInformationPageByCampaignName(campaign.getName());

        campaignsInformationPage.openEditCampaignInformationPage();

        //modify campaign
        campaignUpdated.setExpectedRevenue(random.nextDouble());

        editCampaignInformationPage.editCampaignInformation(campaignUpdated);

        campaignAfterEdit = editCampaignInformationPage.getCampaignInformation();

        editCampaignInformationPage.clickSaveButton();

        //Verify campaign information is updated
        campaignInCampaignInformationPage = campaignsInformationPage.getCampaignInformation();

        softAssert.assertEquals(campaignInCampaignInformationPage, campaignAfterEdit, "Update incorrectly in Campaign Information page.");
        System.out.println("Update campaign correctly");

        //Verify that campaign information is updated in Show all campaign
        campaignsInformationPage.openShowAllCampaignsPage();

        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getName(), campaignAfterEdit.getName(),"Campaign name is not updated");
        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getType(), campaignAfterEdit.getType(),"Campaign type is not updated");
        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getStatus(), campaignAfterEdit.getStatus(),"Campaign status is not updated");
        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getStartDate(), campaignAfterEdit.getStartDate(),"Campaign start date is not updated");
        softAssert.assertEquals(showAllCampaignsPage.getCampaignInformation().getEndDate(), campaignAfterEdit.getEndDate(), "Campaign end date is not updated");
        System.out.println("Update campaign correctly in Show All Campaign page");

        //Verify that campaign information is updated in Customer information
        showAllCampaignsPage.openShowAllCustomersPage();

        showAllCustomerPage.searchCustomerByName(customer);

        showAllCustomerPage.openCustomerInformationByName(customer);

        campaignInCustomerInformationPage = customerInformationPage.getCampaignInformation();

        System.out.println(campaignAfterEdit);
        System.out.println(campaignInCustomerInformationPage);

        softAssert.assertEquals(campaignInCustomerInformationPage, campaignAfterEdit, "Update incorrectly in Customer Information page.");
        System.out.println("Update campaign correctly in Customer Information page");

        softAssert.assertAll();
    }


//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}
