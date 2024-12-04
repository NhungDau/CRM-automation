package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShowAllCustomerPage {
    By campaignsNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Campaigns']");
    By showAllCampaignsLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Campaigns']");

    By clickNewCustomerButtonLocator = By.xpath("//a[text()='New Customer']");
    By enterNameValueLocator = By.xpath("//input[@id='j_idt70:name']");
    By enterEmailValueLocator = By.xpath("//input[@id='j_idt70:email']");
    By enterPhoneValueLocator = By.xpath("//input[@id='j_idt70:phone']");
    By enterAddressValueLocator = By.xpath("//input[@id='j_idt70:address']");
    By clickCreateACustomerLocator = By.xpath("//input[@value='Create a customer']");
    By clickGoToLastPageButtonLocator = By.xpath("//span[@class='ui-paginator-last ui-state-default ui-corner-all ui-state-disabled']");
    By getListCustomerByNameLocator = By.xpath("//a[@class='ui-link ui-widget']");




    //click New Customer button
    public void clickNewCustomerButton(){
        Driver.driver.findElement(clickNewCustomerButtonLocator).click();
    }

    //create new customer
    public void createCustomer(String name, String email, String phone, String address){
        //enter value
        Driver.driver.findElement(enterNameValueLocator).sendKeys(name);
        Driver.driver.findElement(enterEmailValueLocator).sendKeys(email);
        Driver.driver.findElement(enterPhoneValueLocator).sendKeys(phone);
        Driver.driver.findElement(enterAddressValueLocator).sendKeys(address);
        //click create a customer button
        Driver.driver.findElement(clickCreateACustomerLocator).click();
    }

    //click go to last page button
    public void clickGoToLastPageButton(){
        Driver.driver.findElement(clickGoToLastPageButtonLocator).click();
    }

    //click to the newest customer
    public void clickNewestCustomer(){
        List<WebElement> list = Driver.driver.findElements(getListCustomerByNameLocator);
        list.get(list.size()-1).click();
    }


    public void openShowAllCampaignsPage() {
        Driver.driver.findElement(campaignsNavigationLabelLocator).click();
        Driver.driver.findElement(showAllCampaignsLabelLocator).click();
    }
}
