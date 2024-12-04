package page;

import constant.Driver;
import org.openqa.selenium.By;

public class CustomerInformationPage {
    By addOrderButtonLocator = By.xpath("//a[text()='Add order']");


    //click add order button
    public void clickAddOrderButton(){
        Driver.driver.findElement(addOrderButtonLocator).click();
    }
}
