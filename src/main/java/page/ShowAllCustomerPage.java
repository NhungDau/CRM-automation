package page;

import model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShowAllCustomerPage extends BasePage {
    By campaignsNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Campaigns']");
    By showAllCampaignsLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Campaigns']");

    By newCustomerButtonLocator = By.xpath("//a[text()='New Customer']");
    By lastPageButtonLocator = By.xpath("//span[@class='ui-icon ui-icon-seek-end']");
    By customerNameLocator = By.xpath("//a[@class='ui-link ui-widget']");
    By searchByCustomerNameTextboxLocator = By.xpath("//input[@id='j_idt71:tbl:j_idt72:filter']");
    By dynamicCustomerNameLocator;



    public ShowAllCustomerPage(WebDriver driver) {
        super(driver);
    }

    //click New Customer button
    public void clickNewCustomerButton() {
        driver.findElement(newCustomerButtonLocator).click();
    }


    //click go to last page button
    public void clickGoToLastPageButton() {

        driver.findElement(lastPageButtonLocator).click();
    }

    //click to the newest customer
    public void openLastCustomer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(customerNameLocator));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> list = driver.findElements(customerNameLocator);
        list.get(list.size() - 1).click();
    }

    //open customer information page by customer object
    public void openCustomerInformationByName(Customer customer) {
        String xpathValue = String.format("//a[@class='ui-link ui-widget'][text()='%s']", customer.getName());
        dynamicCustomerNameLocator = By.xpath(xpathValue);
        driver.findElement(dynamicCustomerNameLocator).click();
    }

    //search customer name by object
    public void searchCustomerByName(Customer customer) {
        driver.findElement(searchByCustomerNameTextboxLocator).sendKeys(customer.getName());
        wait.until(ExpectedConditions.textToBePresentInElementLocated(customerNameLocator, customer.getName()));
        driver.findElement(searchByCustomerNameTextboxLocator).sendKeys(Keys.ENTER);
    }

    //click to customer name by random index
    public void getCustomerNameByIndex(int a) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(customerNameLocator));

        List<WebElement> list = driver.findElements(customerNameLocator);
        Customer customer = new Customer();
        customer.setName(list.get(a).getText());
    }


}
