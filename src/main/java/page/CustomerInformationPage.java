package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerInformationPage {
    By addOrderButtonLocator = By.xpath("//a[text()='Add order']");

    WebDriver driver;

    public CustomerInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    //click add order button
    public void clickAddOrderButton(){
        driver.findElement(addOrderButtonLocator).click();
    }
}
