package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CustomerInformationPage {
    By addOrderButtonLocator = By.xpath("//a[text()='Add order']");
    By paymentDateLinkLocator = By.xpath("//tr/td/a");
    WebDriver driver;

    public CustomerInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    //click add order button
    public void clickAddOrderButton() {

        driver.findElement(addOrderButtonLocator).click();
    }

    //click last payment date to open orer information page
    public void clickLastPaymentDate(){
        driver.findElement(paymentDateLinkLocator).click();
    }

    //get order information

}
