package page;

import model.Reminder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShowAllReminderPage extends BasePage {
    By searchDescriptionTextBoxLocator = By.id("j_idt70:j_idt71:j_idt72:filter");
    By reminderDescriptionLabelLocator = By.xpath("//a[@class='ui-link ui-widget']");
    By reminderDateLabelLocator = By.xpath("//a[@class='ui-link ui-widget']/../following-sibling::td[1]");
    By reminderTimeLabelLocator = By.xpath("//a[@class='ui-link ui-widget']/../following-sibling::td[2]");
    By deleteButtonLocator = By.xpath("//div//input[@value='Delete']");

    WebDriverWait wait ;

    public ShowAllReminderPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchReminderByDescription(String description) {
        driver.findElement(searchDescriptionTextBoxLocator).sendKeys(description);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public Reminder getReminderInformation() {
        Reminder reminder = new Reminder();
        reminder.setDate(driver.findElement(reminderDateLabelLocator).getText());
        reminder.setTime(driver.findElement(reminderTimeLabelLocator).getText());
        reminder.setDescription(driver.findElement(reminderDescriptionLabelLocator).getText());
        return reminder;
    }

    public boolean isReminderDisplay(String description) {
        List<WebElement> list = driver.findElements(reminderDescriptionLabelLocator);
        for (WebElement a : list) {
            if (a.getText().equals(description)){
                return true;
            }
        }
        return false;
    }

    public void clickDeleteButton(){
        driver.findElement(deleteButtonLocator).click();
    }
}
