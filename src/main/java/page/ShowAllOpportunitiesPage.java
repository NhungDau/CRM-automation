package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShowAllOpportunitiesPage {
    By searchCustomerNameTextBoxLocator = By.id("form:carTable:j_idt70:filter");

    WebDriver driver;

    public ShowAllOpportunitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    //search by customer name
    public void searchbyCustomerName(String name) {
        driver.findElement(searchCustomerNameTextBoxLocator).sendKeys(name);

    }
}
