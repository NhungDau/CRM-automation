package page;

import model.Campaign;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CampaignsInformationPage {
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
    WebDriver driver;

    public CampaignsInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAddCustomerIntoCampaignPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addCustomerButtonLocator));
        driver.findElement(addCustomerButtonLocator).click();
    }

    //open latest customer information page
    public void openTheLastCustomerInformationPage() {
        List<WebElement> listCustomer = driver.findElements(newlyAddedCustomerLocator);
                listCustomer.get(listCustomer.size()-1).click();
    }

    //get latest customer name
    public String getNewCutomerName() {
        List<WebElement> listCustomer = driver.findElements(customerNameLabelLocator);
        return listCustomer.get(listCustomer.size() - 1).getText();
    }

    public Campaign getCampaignInformation() {
        Campaign campaign = new Campaign();
        campaign.setName(driver.findElement(campaignNameLabelLocator).getText());
        campaign.setType(driver.findElement(campaignTypeLabelLocator).getText());
        campaign.setStatus(driver.findElement(campaignStatusLabelLocator).getText());
        campaign.setStartDate(driver.findElement(campaignStartDateLocator).getText());
        campaign.setEndDate(driver.findElement(campaignEndDateLocator).getText());
        campaign.setExpectedRevenue(Double.parseDouble(driver.findElement(campaignExpectedRevenueLocator).getText()));
        campaign.setBudgetedCost(Double.parseDouble(driver.findElement(campaignBudgetedCostLocator).getText()));
        campaign.setActualCost(Double.parseDouble(driver.findElement(campaignActualCostLocator).getText()));
        return campaign;
    }
}
