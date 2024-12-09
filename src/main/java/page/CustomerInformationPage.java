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
    By campaignNameLabelLocator = By.xpath("//h5[text()='Campaigns']/../../div[@class='ibox-content']//table//td/a");
    By editCustomerInformationButtonLocator = By.xpath("//a[@class='btn btn-primary'][text()='Edit']");
    By customerNameLabelLocator = By.xpath("//label[@class='col-lg-1'][text()='Name:']/../div/span");

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

    public void openEditCustomerInformationPage() {
        driver.findElement(editCustomerInformationButtonLocator).click();
    }

    public String getCustomerName() {
        return driver.findElement(customerNameLabelLocator).getText();
    }

    public void openCampaignInformationPage() {
        driver.findElement(campaignNameLabelLocator).click();
    }
}
