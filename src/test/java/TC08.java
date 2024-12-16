import com.github.javafaker.Faker;
import model.Customer;
import model.Reminder;
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
import java.time.LocalTime;
import java.util.Random;

public class TC08 {
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    CreateCampaignPage createCampaignPage;
    CustomerInformationPage customerInformationPage;
    CreateReminderPage createReminderPage;
    ShowAllReminderPage showAllReminderPage;
    Customer customer;
    Reminder reminder;
    Reminder reminderInCustomerInformationPage;
    Reminder reminderInShowAllReminderPage;
    CreateCustomer createCustomer;
    Faker faker;
    Random random;
    int randomDate;
    WebDriver driver;
    SoftAssert softAssert;


    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        customerInformationPage = new CustomerInformationPage(driver);
        createReminderPage = new CreateReminderPage(driver);
        showAllReminderPage = new ShowAllReminderPage(driver);
        createCustomer = new CreateCustomer(driver);
        customer = Customer.random();
        faker = new Faker();
        random = new Random();
        randomDate = random.nextInt(366);
        reminder = new Reminder(faker.hipster().word(),LocalDate.now().plusDays(randomDate).toString(), LocalTime.now().toString());
        softAssert = new SoftAssert();

    }

    @Test
    public void TC08() {
        //login
        loginPage.login(User.defaultUser());

        //create new customer
        showAllCustomerPage.clickNewCustomerButton();

        createCustomer.createCustomer(customer);

        //open customer information page
        showAllCustomerPage.searchCustomerByName(customer);

        showAllCustomerPage.openCustomerInformationByName(customer);

        //create reminder
        customerInformationPage.openCreateReminderPage();

        createReminderPage.createNewReminder(reminder);

        createReminderPage.clickCreateAReminderButton();

        //Verify that new reminder display at customer information page
        reminderInCustomerInformationPage = customerInformationPage.getReminderInformation();

        softAssert.assertEquals(reminderInCustomerInformationPage, reminder, "Reminder is not correct");
        System.out.println("New reminder is added correctly in Customer Information Page");

        //Verify that new reminder display at Reminder page
        customerInformationPage.openShowAllRemindersPage();

        showAllReminderPage.searchReminderByDescription(reminder.getDescription());

        reminderInShowAllReminderPage = showAllReminderPage.getReminderInformation();

        softAssert.assertEquals(reminderInShowAllReminderPage, reminder, "Reminder is not correct");
        System.out.println("New reminder is added correctly in Show All Reminder Page");


        softAssert.assertAll();
    }

//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}