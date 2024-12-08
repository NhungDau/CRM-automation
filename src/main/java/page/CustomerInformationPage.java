package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CustomerInformationPage {
    By addOrderButtonLocator = By.xpath("//a[text()='Add order']");
    By lastPaymentDateLocator = By.xpath("//tr/td/a");
    By editCustomerInformationButtonLocator = By.xpath("//a[@class='btn btn-primary'][text()='Edit']");
    By customerNameLabelLocator = By.xpath("//label[@class='col-lg-1'][text()='Name:']/..//span[@class='col-lg-10']");
    By campaignNameLabelLocator = By.xpath("//h5[text()='Campaigns']/../../div[@class='ibox-content']//table/tbody//td/a");
    WebDriver driver;

    public CustomerInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    //click add order button
    public void clickAddOrderButton() {

        driver.findElement(addOrderButtonLocator).click();
    }

    //click last payment date to open order information page
    public void clickLastPaymentDate() {
        driver.findElement(lastPaymentDateLocator).click();
    }

    //get order information

    //open edit customer information page
    public void openEditCustomerInformationPage() {
        driver.findElement(editCustomerInformationButtonLocator).click();
    }

    //get customer name
    public String getCustomerName() {
        return driver.findElement(customerNameLabelLocator).getText();
    }

    //open campaign information details page via click campaign name
    public void openCampaignInformationPage() {
        driver.findElement(campaignNameLabelLocator).click();
    }
}
