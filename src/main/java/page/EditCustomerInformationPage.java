package page;

import model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditCustomerInformationPage {
    By customerNameTextBoxLocator = By.id("j_idt74:name");
    By customerEmailTextBoxLocator = By.id("j_idt74:email");
    By customerAddressTextBoxLocator = By.id("j_idt74:address");
    By customerPhoneTextBoxLocator = By.id("j_idt74:phone");
    By saveButtonLocator = By.xpath("//input[@value='Save']");
    WebDriver driver;
    WebDriverWait wait;

    public EditCustomerInformationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void editCustomerName(String name) {
        driver.findElement(customerNameTextBoxLocator).clear();
        driver.findElement(customerNameTextBoxLocator).sendKeys(name);
//        wait.until(ExpectedConditions.textToBePresentInElementValue(customerNameTextBoxLocator, name));
    }

    public void editCustomerEmail(String email) {
        driver.findElement(customerEmailTextBoxLocator).clear();
        driver.findElement(customerEmailTextBoxLocator).sendKeys(email);
//        wait.until(ExpectedConditions.textToBePresentInElementValue(customerEmailTextBoxLocator, email));
    }

    public void editCustomerAddress(String address) {
        driver.findElement(customerAddressTextBoxLocator).clear();
        driver.findElement(customerAddressTextBoxLocator).sendKeys(address);
//        wait.until(ExpectedConditions.textToBePresentInElementValue(customerAddressTextBoxLocator, address));
    }

    public void editCustomerPhone(String phone) {
        driver.findElement(customerPhoneTextBoxLocator).clear();
        driver.findElement(customerPhoneTextBoxLocator).sendKeys(phone);
//        wait.until(ExpectedConditions.textToBePresentInElementValue(customerPhoneTextBoxLocator, phone));
    }

    public void clickSaveButton() {
        driver.findElement(saveButtonLocator).click();
    }

    public void editCustomerInformation(Customer customer) {
        if (customer.getName() != null) {
            editCustomerName(customer.getName());
        }
        if (customer.getEmail() != null) {
            editCustomerEmail(customer.getEmail());
        }
        if (customer.getAddress() != null) {
            editCustomerAddress(customer.getAddress());
        }
        if (customer.getPhone() != null) {
            editCustomerPhone(customer.getPhone());
        }
    }

    public Customer getCustomerInformation() {
        Customer customer = new Customer();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        customer.setName(driver.findElement(customerNameTextBoxLocator).getAttribute("value"));
        customer.setEmail(driver.findElement(customerEmailTextBoxLocator).getAttribute("value"));
        customer.setAddress(driver.findElement(customerAddressTextBoxLocator).getAttribute("value"));
        customer.setPhone(driver.findElement(customerPhoneTextBoxLocator).getAttribute("value"));
        return customer;
    }


}
