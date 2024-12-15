package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShowAllOrdersPage extends BasePage {

    By customerNameTextboxLocator = By.xpath("//input[@id='j_idt70:carTable:j_idt71:filter']");
    By paymentDateTextboxLocator = By.xpath("//input[@id='j_idt70:carTable:j_idt73:filter']");
    By totalTextboxLocator = By.xpath("//input[@id='j_idt70:carTable:j_idt75:filter']");
    By getListCustomerNameLocator = By.xpath("//tr//td[1]//a[@class='ui-link ui-widget']");
    By getListByPaymentDateLocator = By.xpath("//tr//td//a");




    WebDriver driver;

    public ShowAllOrdersPage(WebDriver driver) {
        super(driver);
    }

    //search by customer name
    public void searchByCustomerName(String customername){
        driver.findElement(customerNameTextboxLocator).sendKeys(customername);
    }

    //search by payment date
    public void searchByPaymentDate(String paymentDate){
        driver.findElement(paymentDateTextboxLocator).sendKeys(paymentDate);
    }

    //search by total
    public void searchByTotal(String total){
        driver.findElement(totalTextboxLocator).sendKeys(total);
    }


    //click customer name
    public void clickLastCustomerName(){
        List<WebElement> list = driver.findElements(getListCustomerNameLocator);
        list.get(list.size()-1).click();
    }

}
