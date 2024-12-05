package page;

import model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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


    WebDriver driver;

    public ShowAllCustomerPage(WebDriver driver, WebDriver driver1) {
        super(driver);
        this.driver = driver1;
    }

    //click New Customer button
    public void clickNewCustomerButton(){
        driver.findElement(newCustomerButtonLocator).click();
    }

    //enter name
    public void enterName(String sdflksjdhf){
        driver.findElement(nameTextboxLocator).sendKeys(sdflksjdhf);
    }
    //enter email
    public void enterEmail(String email){

        driver.findElement(emailTextboxLocator).sendKeys(email);
    }
    //enter phone
    public void enterPhone(String phone){

        driver.findElement(phoneTextboxLocator).sendKeys(phone);
    }
    //enter address
    public void enterAddress(String address){

        driver.findElement(addressTextboxLocator).sendKeys(address);
    }

    //create new customer
    public void createCustomer(Customer customer){
        //enter value
        enterName(customer.getName());
        enterEmail(customer.getEmail());
        enterPhone(customer.getPhone());
        enterAddress(customer.getAddress());
        //click create a customer button
        driver.findElement(createCustomerLocator).click();
    }


    //click go to last page button
    public void clickGoToLastPageButton(){

        driver.findElement(lastPageButtonLocator).click();
    }

    //click to the newest customer
    public void openLastCustomer(){
        List<WebElement> list = driver.findElements(getListCustomerByNameLocator);
        list.get(list.size()-1).click();
    }

    //open CAipaign


}
