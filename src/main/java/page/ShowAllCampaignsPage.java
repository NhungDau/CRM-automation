package page;

import model.Campaign;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ShowAllCampaignsPage extends BasePage {
    By campaignNameLabelLocator = By.xpath("//a[@class='ui-link ui-widget']");
    By campaignTypeLabelLocator = By.xpath("//a[@class='ui-link ui-widget']/../following-sibling::td[1]");
    By statusLabelLocator = By.xpath("//a[@class='ui-link ui-widget']/../following-sibling::td[2]");
    By startDateLocator = By.xpath("//a[@class='ui-link ui-widget']/../following-sibling::td[3]");
    By endDateLocator = By.xpath("//a[@class='ui-link ui-widget']/../following-sibling::td[4]");
    By searchByCampaignNameTextboxLocator = By.xpath("//span[text()='Campaign Name']//..//input[@class='ui-column-filter ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all']");
    By searchByCampaignTypeTextboxLocator = By.xpath("//span[text()='Type']//..//input[@class='ui-column-filter ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all']");
    By searchByStatusTextboxLocator = By.xpath("//span[text()='Status']//..//input[@class='ui-column-filter ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all']");
    By searchByStartDateTextboxLocator = By.xpath("//span[text()='Start Date']//..//input[@class='ui-column-filter ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all']");
    By searchByEndDateTextboxLocator = By.xpath("//span[text()='End Date']//..//input[@class='ui-column-filter ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all']");
    Random random = new Random();


    public ShowAllCampaignsPage(WebDriver driver) {
        super(driver);
    }

    public void openCampaignInformationPage() {
        List<WebElement> listOfCampaign = driver.findElements(campaignNameLabelLocator);
        int randomIndex = random.nextInt(listOfCampaign.size());
        listOfCampaign.get(randomIndex).click();
    }

    public void openCampaignInformationPageByCampaignName(String campaignName) {
        driver.findElement(searchByCampaignNameTextboxLocator).sendKeys(campaignName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(campaignNameLabelLocator, campaignName));
        driver.findElement(campaignNameLabelLocator).click();
    }

    //enter campaign name to search box
    public void searchByCampaignName(String campaignName) {
//        driver.findElement(searchByCampaignNameTextboxLocator).click();
        driver.findElement(searchByCampaignNameTextboxLocator).sendKeys(campaignName);
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(searchByCampaignNameTextboxLocator, campaignName));
    }

    //enter campaign type to search box
    public void searchByCampaignType(String campaginType) {
        driver.findElement(searchByCampaignTypeTextboxLocator).click();
        driver.findElement(searchByCampaignTypeTextboxLocator).sendKeys(campaginType);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(searchByCampaignTypeTextboxLocator, campaginType));

    }

    //enter status to search box
    public void searchByStatus(String status){
        driver.findElement(searchByStatusTextboxLocator).click();
        driver.findElement(searchByStatusTextboxLocator).sendKeys(status);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(searchByStatusTextboxLocator, status));

    }

    //enter start date to search box
    public void searchByStartDate(String startDate){
        driver.findElement(searchByStartDateTextboxLocator).click();
        driver.findElement(searchByStartDateTextboxLocator).sendKeys(startDate);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(searchByStartDateTextboxLocator, startDate));

    }

    //enter end date to search box
    public void searchByEndDate(String endDate){
        driver.findElement(searchByEndDateTextboxLocator).click();
        driver.findElement(searchByEndDateTextboxLocator).sendKeys(endDate);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(searchByEndDateTextboxLocator, endDate));

    }


    //get campaign information
    public  Campaign getCampaignInformation(){
        Campaign campaign = new Campaign();

        campaign.setName(driver.findElement(campaignNameLabelLocator).getText());
        campaign.setStatus(driver.findElement(statusLabelLocator).getText());
        campaign.setType(driver.findElement(campaignTypeLabelLocator).getText());
        campaign.setStartDate(driver.findElement(startDateLocator).getText());
        campaign.setEndDate(driver.findElement(endDateLocator).getText());

        return campaign;
    }


}
