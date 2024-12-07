package page;

import model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShowAllOrdersPage {

    By searchByCustomerNameTextboxLocator = By.xpath("//input[@id='j_idt70:carTable:j_idt71:filter']");
    By getListCustomerNameLocator = By.xpath("//tr//td[1]//a[@class='ui-link ui-widget']");
    By getListByPaymentDateLocator = By.xpath("//tr//td//a");




    WebDriver driver;

    public ShowAllOrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    //search by customer name
    public void searchByCustomerName(String customername){
        driver.findElement(searchByCustomerNameTextboxLocator).sendKeys(customername);
    }

    //click customer name
    public void clickLastCustomerName(){
        List<WebElement> list = driver.findElements(getListCustomerNameLocator);
        list.get(list.size()-1).click();
    }

}
