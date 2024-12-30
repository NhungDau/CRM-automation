package page;

import io.qameta.allure.Step;
import model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateCustomer {

    By nameTextboxLocator = By.xpath("//input[@id='j_idt70:name']");
    By emailTextboxLocator = By.id("j_idt70:email");
    By phoneTextboxLocator = By.id("j_idt70:phone");
    By addressTextboxLocator = By.id("j_idt70:address");
    By createCustomerLocator = By.xpath("//input[@value='Create a customer']");

    WebDriver driver;

    public CreateCustomer(WebDriver driver) {
        this.driver = driver;
    }

    //enter name
    public void enterName(String name) {
        driver.findElement(nameTextboxLocator).sendKeys(name);
    }

    //enter email
    public void enterEmail(String email) {

        driver.findElement(emailTextboxLocator).sendKeys(email);
    }

    //enter phone
    public void enterPhone(String phone) {

        driver.findElement(phoneTextboxLocator).sendKeys(phone);
    }

    //enter address
    public void enterAddress(String address) {

        driver.findElement(addressTextboxLocator).sendKeys(address);
    }

    //create new customer
    @Step ("Create new customer into system.")
    public void createCustomer(Customer customer) {
        //enter value
        enterName(customer.getName());
        enterEmail(customer.getEmail());
        enterPhone(customer.getPhone());
        enterAddress(customer.getAddress());
        //click create a customer button
        driver.findElement(createCustomerLocator).click();
    }


}
