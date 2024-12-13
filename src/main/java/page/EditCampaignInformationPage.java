package page;

import model.CampaignType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EditCampaignInformationPage {
    By campaignNameTextBoxLocator = By.name("j_idt72:j_idt75");
    By campaignTypeListLocator = By.name("j_idt72:j_idt77");
    By statusDropdownListLocator = By.name("j_idt72:j_idt81");
    By startDateTextBoxLocator = By.id("j_idt72:sd");
    By endDateTextBoxLocator = By.id("j_idt72:ed");
    By expectedRevenueTextBoxLocator = By.id("j_idt72:er");
    By budgetedCostTextBoxLocator = By.id("j_idt72:bc");
    By actualCostTextBoxLocator = By.id("j_idt72:ac");
    By descriptionTextBoxLocator = By.id("j_idt72:de");
    By saveButtonLocator = By.xpath("//input[@value='Save']");

    WebDriver driver;

    public EditCampaignInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void editCampaignName(String campaignName) {
        driver.findElement(campaignNameTextBoxLocator).clear();
        driver.findElement(campaignNameTextBoxLocator).sendKeys(campaignName);
    }

    public void selectTypeOptionByCampaignType(CampaignType campaignType) {
        Select campaignTypeOption = new Select(driver.findElement(campaignTypeListLocator));
        campaignTypeOption.selectByVisibleText(campaignType.getTypeName());
    }

    public void selectTypeOption(String type) {
        Select campaignTypeOption = new Select(driver.findElement(campaignTypeListLocator));
        campaignTypeOption.selectByVisibleText(type);
    }

    public String getSelectedCampaignType() {
        return driver.findElement(campaignTypeListLocator).getText();
    }

    public void selectDoneStatusOption() {
        Select campaignStatusOption = new Select(driver.findElement(statusDropdownListLocator));
        campaignStatusOption.selectByVisibleText("Done");
    }

    public void selectYetStatusOption() {
        Select campaignStatusOption = new Select(driver.findElement(statusDropdownListLocator));
        campaignStatusOption.selectByVisibleText("Yet");
    }

    public void selectStatusOption(String status) {
        Select campaignStatusOption = new Select(driver.findElement(statusDropdownListLocator));
        campaignStatusOption.selectByVisibleText(status);
    }

    public void enterStartDate(String startDate) {
        driver.findElement(startDateTextBoxLocator).sendKeys(startDate);
    }

    public void enterEndDate(String endDate) {
        driver.findElement(endDateTextBoxLocator).sendKeys(endDate);
    }

    public void enterExpectedRevenue(double exRevenue) {
        driver.findElement(expectedRevenueTextBoxLocator).sendKeys(Double.toString(exRevenue));
    }

    public void enterBudgetedCost(double budget ) {
        driver.findElement(budgetedCostTextBoxLocator).sendKeys(Double.toString(budget));
    }

    public void enterActualCost(double actual) {
        driver.findElement(actualCostTextBoxLocator).sendKeys(Double.toString(actual));
    }

    public void enterDescription(String description) {
        driver.findElement(descriptionTextBoxLocator).sendKeys(description);
    }
}
