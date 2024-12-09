package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomerInformationPage {
    By addOrderButtonLocator = By.xpath("//a[text()='Add order']");
    By paymentDateLocator = By.xpath("//tr/td/a");
    By priceLocator = By.xpath("//tr/td[2]");
    By addOpportunityButtonLocator = By.xpath("//a[text()='Add opportunity']");
    WebDriver driver;

    String paymentDate;
    Double price;

    public CustomerInformationPage(WebDriver driver) {
        this.driver = driver;
    }


    //click add order button
    public void clickAddOrderButton() {

        driver.findElement(addOrderButtonLocator).click();
    }

    //click last payment date to open order information page
    public void clickLastPaymentDate(){
        driver.findElement(paymentDateLocator).click();
    }

    //click add opportunity button
    public void clickAddOpportunityButton(){
        driver.findElement(addOpportunityButtonLocator).click();
    }

    //check newest order display
    public void isOrderDisplay(){
        List<WebElement> list = driver.findElements(paymentDateLocator);
        paymentDate = list.get(list.size()-1).getText();

        List<WebElement> list1 = driver.findElements(priceLocator);
        price = Double.parseDouble(list1.get(list1.size()-1).getText());
    }

    public String getPaymentDate(){
        return paymentDate;
    }

    public  Double getPrice(){
        return price;

    }

}
