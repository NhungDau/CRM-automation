package page;

import model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddCustomerIntoCampaignPage {
    By checkBoxLocator = By.xpath("//input[@type=\"checkbox\"]");
    By dynamicLocator;
    By addButtonLocator = By.xpath("//input[@value=\"Add\"]");
    WebDriver driver;

    public AddCustomerIntoCampaignPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectTheNewestCustomer() {
        List<WebElement> listCustomers = driver.findElements(checkBoxLocator);
        listCustomers.get(listCustomers.size()-1).click();
    }

    public void selectCustomerByName(String customerName) {
        String xpathValue = String.format("//td[text()='%s']/..//input[@type='checkbox']", customerName);
        dynamicLocator = By.xpath(xpathValue);
        driver.findElement(dynamicLocator).click();
    }

    public void clickToAddButton() {
        driver.findElement(addButtonLocator).click();
    }

}
