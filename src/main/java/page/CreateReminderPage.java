package page;

import com.github.javafaker.Faker;
import model.Reminder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CreateReminderPage {
    By descriptionTextBoxLocator = By.id("j_idt74:des");
    By dateTextBoxLocator = By.id("j_idt74:d");
    By timeTextBoxLocator = By.id("j_idt74:t");
    By createAReminderButtonLocator = By.name("j_idt74:j_idt82");

    WebDriver driver;
    Faker faker = new Faker();

    public CreateReminderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDescription(String description) {
        driver.findElement(descriptionTextBoxLocator).sendKeys(description);
    }

    public void enterDate(String date) {
        driver.findElement(dateTextBoxLocator).sendKeys(date);
    }

    public void enterTime(String time) {
        driver.findElement(timeTextBoxLocator).sendKeys(time);
    }

    public void createNewReminder(Reminder reminder) {
        enterDescription(reminder.getDescription());
        enterDate(reminder.getDate());
        enterTime(reminder.getTime());
    }

    public void clickCreateAReminderButton() {
        driver.findElement(createAReminderButtonLocator).click();
    }


}
