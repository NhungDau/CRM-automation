package page;

import constant.Driver;
import model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShowAllCustomerPage extends BasePage  {
    By campaignsNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Campaigns']");
    By showAllCampaignsLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Campaigns']");

    By newCustomerButtonLocator = By.xpath("//a[text()='New Customer']");
    By nameTextboxLocator = By.id("j_idt70:name");
    By emailTextboxLocator = By.id("j_idt70:email");
    By phoneTextboxLocator = By.id("j_idt70:phone");
    By addressTextboxLocator = By.id("j_idt70:address");
    By createCustomerLocator = By.xpath("//input[@value='Create a customer']");
    By lastPageButtonLocator = By.xpath("//span[@class='ui-paginator-last ui-state-default ui-corner-all ui-state-disabled']");
    By getListCustomerByNameLocator = By.xpath("//a[@class='ui-link ui-widget']");




    //click New Customer button
    public void clickNewCustomerButton(){
        Driver.driver.findElement(newCustomerButtonLocator).click();
    }

    //enter name
    public void enterName(String sdflksjdhf){
        Driver.driver.findElement(nameTextboxLocator).sendKeys(sdflksjdhf);
    }
    //enter email
    public void enterEmail(String email){
        Driver.driver.findElement(emailTextboxLocator).sendKeys(email);
    }
    //enter phone
    public void enterPhone(String phone){
        Driver.driver.findElement(phoneTextboxLocator).sendKeys(phone);
    }
    //enter address
    public void enterAddress(String address){
        Driver.driver.findElement(addressTextboxLocator).sendKeys(address);
    }
    //create new customer
//    public void createCustomer(String name, String email, String phone, String address){
//        //enter value
//        Driver.driver.findElement(nameTextboxLocator).sendKeys(name);
//        Driver.driver.findElement(emailTextboxLocator).sendKeys(email);
//        Driver.driver.findElement(phoneTextboxLocator).sendKeys(phone);
//        Driver.driver.findElement(addressTextboxLocator).sendKeys(address);
//        //click create a customer button
//        Driver.driver.findElement(createCustomerLocator).click();
//    }

    public void createCustomer(Customer customer){
        //        //enter value
        enterName(customer.getName());
        enterEmail(customer.getEmail());
        enterPhone(customer.getPhone());
        enterAddress(customer.getAddress());
//        click create a customer button
        Driver.driver.findElement(createCustomerLocator).click();
    }


    //click go to last page button
    public void clickGoToLastPageButton(){
        Driver.driver.findElement(lastPageButtonLocator).click();
    }

    //click to the newest customer
    public void openLastCustomer(){
        List<WebElement> list = Driver.driver.findElements(getListCustomerByNameLocator);
        list.get(list.size()-1).click();
    }

    //open CAipaign


}
