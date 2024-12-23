package page;

import model.Campaign;
import model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CampaignsInformationPage extends BasePage {
    By campaignNameLabelLocator = By.xpath("//label[@class='col-lg-2 control-label'][text()='Campaign Name']/..//div/span[@class='form-control']");
    By campaignTypeLabelLocator = By.xpath("//label[@class='col-sm-2 control-label'][text()='Type']/..//div/span[@class='form-control']");
    By campaignStatusLabelLocator = By.xpath("//label[@class='col-sm-2 control-label'][text()='Status']/..//div/span[@class='form-control']");
    By campaignStartDateLocator = By.xpath("//label[@class='col-lg-4 control-label'][text()='Start Date']/..//div/span[@class='form-control']");
    By campaignEndDateLocator = By.xpath("//label[@class='col-lg-4 control-label'][text()='End Date']/..//div/span[@class='form-control']");
    By campaignExpectedRevenueLocator = By.xpath("//label[@class='col-lg-4 control-label'][text()='Expected Revenue']/..//div/span[@class='form-control']");
    By campaignBudgetedCostLocator = By.xpath("//label[@class='col-lg-4 control-label'][text()='Budgeted Cost']/..//div/span[@class='form-control']");
    By campaignActualCostLocator = By.xpath("//label[@class='col-lg-4 control-label'][text()='Actual Cost']/..//div/span[@class='form-control']");
    By campaignDescriptionLocator = By.xpath("//label[@class='col-lg-2 control-label'][text()='Description']/..//div/span[@class='form-control']");
    By addCustomerButtonLocator = By.xpath("//a[@class='btn btn-primary'][text()='Add customer']");
    By newlyAddedCustomerLocator = By.xpath("//tr/td/a");
    By customerNameLabelLocator = By.xpath("//table/tbody//td/a");
    By customerEmailLabelLocator = By.xpath("//table/tbody//td[2]");
    By customerAddressLabelLocator = By.xpath("//table/tbody//td[3]");
    By customerPhoneLabelLocator = By.xpath("//table/tbody//td[4]");
    By dynamicCustomerNameLocator;
    By editCampaignInformationButtonLocator = By.xpath("//a[@class='btn btn-primary'][text()='Edit']");

    public CampaignsInformationPage(WebDriver driver) {
        super(driver);
    }

    public void goToAddCustomerIntoCampaignPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addCustomerButtonLocator));
        driver.findElement(addCustomerButtonLocator).click();
    }

    //open latest customer information page
    public void openTheLastCustomerInformationPage() {
        List<WebElement> listCustomer = driver.findElements(newlyAddedCustomerLocator);
        listCustomer.get(listCustomer.size() - 1).click();
    }

    //open customer information page by name
    public void openCustomerInformationPageByName(String customerName) {
        String xpathValue = String.format("//table/tbody//td/a[text()='%s']", customerName);
        dynamicCustomerNameLocator = By.xpath(xpathValue);
        driver.findElement(dynamicCustomerNameLocator).click();
    }

    public Customer getCustomerInformation() {
        Customer customer = new Customer();
        customer.setName(driver.findElement(customerNameLabelLocator).getText());
        customer.setEmail(driver.findElement(customerEmailLabelLocator).getText());
        customer.setAddress(driver.findElement(customerAddressLabelLocator).getText());
        customer.setPhone(driver.findElement(customerPhoneLabelLocator).getText());
        return customer;
    }

    public Campaign getCampaignInformation() {
        Campaign campaign = new Campaign();
        campaign.setName(driver.findElement(campaignNameLabelLocator).getText());
        campaign.setType(driver.findElement(campaignTypeLabelLocator).getText());
        campaign.setStatus(driver.findElement(campaignStatusLabelLocator).getText());
        campaign.setStartDate(driver.findElement(campaignStartDateLocator).getText());
        campaign.setEndDate(driver.findElement(campaignEndDateLocator).getText());
        campaign.setExpectedRevenue((int)Double.parseDouble(driver.findElement(campaignExpectedRevenueLocator).getText()));
        campaign.setBudgetedCost((int)Double.parseDouble(driver.findElement(campaignBudgetedCostLocator).getText()));
        campaign.setActualCost((int)Double.parseDouble(driver.findElement(campaignActualCostLocator).getText()));
        return campaign;
    }

    //open edit campaign information page
    public void openEditCampaignInformationPage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(editCampaignInformationButtonLocator).click();
    }
}
