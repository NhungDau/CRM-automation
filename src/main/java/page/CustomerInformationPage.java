package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CustomerInformationPage {
    By addOrderButtonLocator = By.xpath("//a[text()='Add order']");
    By lastPaymentDateLocator = By.xpath("//tr/td/a");
    By addOpportunityButtonLocator = By.xpath("//a[text()='Add opportunity']");
    WebDriver driver;

    public CustomerInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    //click add order button
    public void clickAddOrderButton() {

        driver.findElement(addOrderButtonLocator).click();
    }

    //click last payment date to open order information page
    public void clickLastPaymentDate(){
        driver.findElement(lastPaymentDateLocator).click();
    }

    //click add opportunity button
    public void clickAddOpportunityButton(){
        driver.findElement(addOpportunityButtonLocator).click();
    }


}
