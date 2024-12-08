package page;

import model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditCustomerInformationPage {
    By customerNameTextBoxLocator = By.id("j_idt74:name");
    By customerEmailTextBoxLocator = By.id("j_idt74:email");
    By customerAddressTextBoxLocator = By.id("j_idt74:address");
    By customerPhoneTextBoxLocator = By.id("j_idt74:phone");
    By saveButtonLocator = By.xpath("//input[@value='Save']");
    WebDriver driver;

    public EditCustomerInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCustomerName() {
        return driver.findElement(customerNameTextBoxLocator).getText();
    }

    public String getCustomerEmail() {
        return driver.findElement(customerEmailTextBoxLocator).getText();
    }

    public String getCustomerAddress() {
        return driver.findElement(customerAddressTextBoxLocator).getText();
    }

    public String getCustomerPhone() {
        return driver.findElement(customerPhoneTextBoxLocator).getText();
    }
    public void editCustomerName(String newCustomerName) {
        driver.findElement(customerNameTextBoxLocator).sendKeys(newCustomerName);
        driver.findElement(saveButtonLocator).click();
    }
}
