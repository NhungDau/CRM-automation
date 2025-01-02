import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import model.Campaign;
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

        Allure.step("Search newly created customer");
        //search newly created customer and go to customer information page
        showAllCustomerPage.searchCustomerByName(customer);

        Allure.step("Go to customer information page");
        //go to customer information page
        showAllCustomerPage.openCustomerInformationByName(customer);

        Allure.step("Add remider");
        //add reminder
        customerInformationPage.openCreateReminderPage();

        createReminderPage.createNewReminder(reminder);

        createReminderPage.clickCreateAReminderButton();

        Allure.step("Search by reminder description");
        //search by reminder description in show all reminder page
        customerInformationPage.openShowAllRemindersPage();

        showAllReminderPage.searchReminderByDescription(reminder.getDescription());

        Allure.step("Delete reminder");
        //delete reminder
        showAllReminderPage.clickDeleteButton();

        Allure.step("Search the newly deleted reminder");
        //search the newly deleted reminder
        showAllReminderPage.searchReminderByDescription(reminder.getDescription());

        Allure.step("Verify the reminder whether displays in show all reminder page");
        //verify whether reminder displayed in reminder

        softAssert.assertFalse(showAllReminderPage.isReminderDisplay(reminder.getDescription()),"Still display reminder");

        //go to customer information page
        showAllReminderPage.openShowAllCustomersPage();

        showAllCustomerPage.searchCustomerByName(customer);

        showAllCustomerPage.openLastCustomer();


        //verify whether reminder displayed in reminder
        softAssert.assertFalse(customerInformationPage.isReminderDisplay(reminder.getDescription()),"Still display reminder");


        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}




