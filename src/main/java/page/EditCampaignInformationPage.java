package page;

import model.Campaign;
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

    public void selectTypeOption(String type) {
        Select campaignTypeOption = new Select(driver.findElement(campaignTypeListLocator));
        campaignTypeOption.selectByVisibleText(type);
    }

    public String getSelectedType(){
        Select campaignTypeOption = new Select(driver.findElement(campaignTypeListLocator));
        return campaignTypeOption.getFirstSelectedOption().getText();
    }

    public String getSelectedStatus(){
        Select campaignStatusOption = new Select(driver.findElement(statusDropdownListLocator));
        return campaignStatusOption.getFirstSelectedOption().getText();
    }

    public void selectStatusOption(String status) {
        Select campaignStatusOption = new Select(driver.findElement(statusDropdownListLocator));
        campaignStatusOption.selectByVisibleText(status);
    }

    public void editStartDate(String startDate) {
        driver.findElement(startDateTextBoxLocator).sendKeys(startDate);
    }

    public void editEndDate(String endDate) {
        driver.findElement(endDateTextBoxLocator).sendKeys(endDate);
    }

    public void editExpectedRevenue(double exRevenue) {
        driver.findElement(expectedRevenueTextBoxLocator).clear();
        driver.findElement(expectedRevenueTextBoxLocator).sendKeys(Double.toString(exRevenue));
    }

    public void editBudgetedCost(double budget) {
        driver.findElement(budgetedCostTextBoxLocator).clear();
        driver.findElement(budgetedCostTextBoxLocator).sendKeys(Double.toString(budget));
    }

    public void editActualCost(double actual) {
        driver.findElement(actualCostTextBoxLocator).clear();
        driver.findElement(actualCostTextBoxLocator).sendKeys(Double.toString(actual));
    }

    public void editDescription(String description) {
        driver.findElement(descriptionTextBoxLocator).clear();
        driver.findElement(descriptionTextBoxLocator).sendKeys(description);
    }

    public void editCampaignInformation(Campaign campaign) {
        if (campaign.getName() != null) {
            editCampaignName(campaign.getName());
        }
        if (campaign.getType() != null) {
            selectTypeOption(campaign.getType());
        }
        if (campaign.getStatus() != null) {
            selectStatusOption(campaign.getStatus());
        }
        if (campaign.getStartDate() != null) {
            editStartDate(campaign.getStartDate());
        }
        if (campaign.getEndDate() != null) {
            editEndDate(campaign.getEndDate());
        }
        if (campaign.getExpectedRevenue() != null) {
            editExpectedRevenue(campaign.getExpectedRevenue());
        }
        if (campaign.getBudgetedCost() != null) {
            editBudgetedCost(campaign.getBudgetedCost());
        }
        if (campaign.getActualCost() != null) {
            editActualCost(campaign.getActualCost());
        }
    }

    public void clickSaveButton() {
        driver.findElement(saveButtonLocator).click();
    }


    public Campaign getCampaignInformation() {
        Campaign campaign = new Campaign();
        campaign.setName(driver.findElement(campaignNameTextBoxLocator).getAttribute("value"));
        campaign.setType(getSelectedType());
        campaign.setStatus(getSelectedStatus());
        campaign.setStartDate(driver.findElement(startDateTextBoxLocator).getAttribute("value"));
        campaign.setEndDate(driver.findElement(endDateTextBoxLocator).getAttribute("value"));
        campaign.setExpectedRevenue(Integer.parseInt(driver.findElement(expectedRevenueTextBoxLocator).getAttribute("value").replace(".0","")));
        campaign.setBudgetedCost(Integer.parseInt(driver.findElement(budgetedCostTextBoxLocator).getAttribute("value").replace(".0","")));
        campaign.setActualCost(Integer.parseInt(driver.findElement(actualCostTextBoxLocator).getAttribute("value").replace(".0","")));
        return campaign;
    }
}
