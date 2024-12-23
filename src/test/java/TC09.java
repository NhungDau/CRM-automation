import com.github.javafaker.Faker;
import model.Campaign;
import model.Customer;
import model.Reminder;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TC09 {

    WebDriver driver;
    LoginPage loginPage;
    ShowAllCustomerPage showAllCustomerPage;
    CustomerInformationPage customerInformationPage;
    CreateCustomer createCustomer;
    Customer customer;
    Campaign campaign;
    Campaign campaign2;
    CreateReminderPage createReminderPage;
    ShowAllReminderPage showAllReminderPage;
    Faker faker;
    Reminder reminder;
    LocalDate today;
    LocalTime time;
    DateTimeFormatter formatter;
    DateTimeFormatter formatter2;

    SoftAssert softAssert;
    @BeforeMethod
    public void initData() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        showAllCustomerPage = new ShowAllCustomerPage(driver);
        customerInformationPage = new CustomerInformationPage(driver);
        createCustomer = new CreateCustomer(driver);
        campaign = new Campaign();
        campaign2 = new Campaign();
        createReminderPage = new CreateReminderPage(driver);
        showAllReminderPage = new ShowAllReminderPage(driver);
        softAssert = new SoftAssert();
        customer = Customer.random();
        faker = new Faker();
        today = LocalDate.now();
        time = LocalTime.now();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter2 = DateTimeFormatter.ofPattern("HH:mm");
        reminder = new Reminder(faker.lorem().sentence(),today.format(formatter),time.format(formatter2));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");

    }

    @Test
    public void TC09() {
        //login
        loginPage.login(User.defaultUser());


        //create new customer
        showAllCustomerPage.clickNewCustomerButton();
        createCustomer.createCustomer(customer);

        //search newly created customer and go to customer information page
        showAllCustomerPage.searchCustomerByName(customer);

        //go to customer information page
        showAllCustomerPage.openCustomerInformationByName(customer);

        //add reminder
        customerInformationPage.openCreateReminderPage();

        createReminderPage.createNewReminder(reminder);

        createReminderPage.clickCreateAReminderButton();

        //search by reminder description in show all reminder page
        customerInformationPage.openShowAllRemindersPage();

        showAllReminderPage.searchReminderByDescription(reminder.getDescription());

        showAllReminderPage.clickDeleteButton();


        //re-search the newly deleted reminder
        showAllReminderPage.searchReminderByDescription2(reminder.getDescription());

        //verify whether reminder displayed in reminder
        showAllReminderPage.isReminderDisplay(reminder.getDescription());

        softAssert.assertFalse(showAllReminderPage.isReminderDisplay(reminder.getDescription()),"Still display reminder");

        //go to customer information page
        showAllReminderPage.openShowAllCustomersPage();

        showAllCustomerPage.searchCustomerByName(customer);

        showAllCustomerPage.openLastCustomer();


        //verify whether reminder displayed in reminder
        softAssert.assertFalse(customerInformationPage.isReminderDisplay(reminder.getDescription()),"Still display reminder");


        softAssert.assertAll();
    }

//    @AfterMethod
//    public void cleanUp() {
//        driver.quit();
//    }
}




