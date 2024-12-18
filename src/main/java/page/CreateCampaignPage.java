package page;

import model.Campaign;
import model.CampaignType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreateCampaignPage extends BasePage {
    By campaignNameTextBoxLocator = By.id("j_idt70:cn");
    By campaignTypeListLocator = By.name("j_idt70:j_idt74");
    By statusDropdownListLocator = By.name("j_idt70:j_idt77");
    By startDateTextBoxLocator = By.id("j_idt70:sd");
    By endDateTextBoxLocator = By.id("j_idt70:ed");
    By expectedRevenueTextBoxLocator = By.id("j_idt70:er");
    By budgetedCostTextBoxLocator = By.id("j_idt70:bc");
    By actualCostTextBoxLocator = By.id("j_idt70:ac");
    By descriptionTextBoxLocator = By.id("j_idt70:de");
    By createButtonLocator = By.name("j_idt70:j_idt93");


    public CreateCampaignPage(WebDriver driver) {
        super(driver);
    }

    public void enterCampaignName(String campaignName) {
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
        Select campaignTypeOption = new Select(driver.findElement(campaignTypeListLocator));
        return campaignTypeOption.getFirstSelectedOption().getText();
    }

    public void selectDoneStatusOption() {
        selectStatusOption("Done");
    }

    public void selectYetStatusOption() {
        selectStatusOption("Yet");
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

    public void clickCreateButton() {
        driver.findElement(createButtonLocator).click();
    }

    public void createNewCampaign(Campaign campaign) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        enterCampaignName(campaign.getName());
        selectTypeOption(campaign.getType());
        selectStatusOption(campaign.getStatus());
        enterStartDate(campaign.getStartDate());
        enterEndDate(campaign.getEndDate());
        enterExpectedRevenue(campaign.getExpectedRevenue());
        enterBudgetedCost(campaign.getBudgetedCost());
        enterActualCost(campaign.getActualCost());
    }

    public List listStatusOption() {
        Select statusOptions = new Select(driver.findElement(statusDropdownListLocator));
        return statusOptions.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List listTypeOption() {
        Select typeOptions = new Select(driver.findElement(campaignTypeListLocator));
        return typeOptions.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List getListTypeOption() {
        Select typeOptions = new Select(driver.findElement(campaignTypeListLocator));
        List<WebElement> options = typeOptions.getOptions();
        List<String> listDropdownValue = new ArrayList<>();
        for (WebElement option : options){
            listDropdownValue.add(option.getAttribute("value"));
        }
        return listDropdownValue;
    }


}

