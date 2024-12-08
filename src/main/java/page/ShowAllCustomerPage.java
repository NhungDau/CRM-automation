package page;

import model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ShowAllCustomerPage  {
    By campaignsNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Campaigns']");
    By showAllCampaignsLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Campaigns']");

    By newCustomerButtonLocator = By.xpath("//a[text()='New Customer']");
    By nameTextboxLocator = By.xpath("//input[@id='j_idt70:name']");
    By emailTextboxLocator = By.id("j_idt70:email");
    By phoneTextboxLocator = By.id("j_idt70:phone");
    By addressTextboxLocator = By.id("j_idt70:address");
    By createCustomerLocator = By.xpath("//input[@value='Create a customer']");
    By lastPageButtonLocator = By.xpath("//span[@class='ui-icon ui-icon-seek-end']");
    By getListCustomerByNameLocator = By.xpath("//a[@class='ui-link ui-widget']");
    By searchByCustomerNameTextboxLocator = By.xpath("//input[@id='j_idt71:tbl:j_idt72:filter']");


    Random random = new Random();
    Customer customer;
    String customerName;

    WebDriver driver;

    public ShowAllCustomerPage(WebDriver driver) {
        this.driver = driver;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(getListCustomerByNameLocator));

        List<WebElement> list = driver.findElements(getListCustomerByNameLocator);
        list.get(list.size()-1).click();
    }

    //click to customer name by random index
    public void clickCustomerNameByIndex(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(getListCustomerByNameLocator));

        List<WebElement> list = driver.findElements(getListCustomerByNameLocator);

        int a = random.nextInt(list.size()+1);
        customerName = list.get(a).getText();

        list.get(a).click();
    }
    public String customerName(){
        return customerName;
    }


}
