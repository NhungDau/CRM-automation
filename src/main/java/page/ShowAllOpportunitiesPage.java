package page;

import model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;


public class ShowAllOpportunitiesPage {

    By searchByCustomerNameTextboxLocator = By.xpath("//input[@id='form:carTable:j_idt70:filter']");
    By getListCustomerByNameLocator = By.xpath("//a[@class='ui-link ui-widget']");


    WebDriver driver;

    public ShowAllOpportunitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    ShowAllCustomerPage showAllCustomerPage;

//    //search by customer name
//    public void searchByCustomerName(){
//        showAllCustomerPage = new ShowAllCustomerPage(driver);
//        driver.findElement(searchByCustomerNameTextboxLocator).sendKeys(showAllCustomerPage.customerName());
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBePresentInElementValue(searchByCustomerNameTextboxLocator, showAllCustomerPage.customerName()));
//
//        driver.findElement(searchByCustomerNameTextboxLocator).sendKeys(Keys.ENTER);
//        wait.until(ExpectedConditions.textToBe(getListCustomerByNameLocator, showAllCustomerPage.customerName()));
//
//    }



}
