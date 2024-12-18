package page;

import model.Campaign;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class CampaignReportPage  {
    By campaignNameLabelLocator = By.xpath("//a[@class='ui-link ui-widget']");
    By campaignTypeLabelLocator = By.xpath("//a[@class='ui-link ui-widget']/../following-sibling::td[1]");
    By statusLabelLocator = By.xpath("//a[@class='ui-link ui-widget']/../following-sibling::td[2]");
    By startDateLocator = By.xpath("//a[@class='ui-link ui-widget']/../following-sibling::td[3]");
    By endDateLocator = By.xpath("//a[@class='ui-link ui-widget']/../following-sibling::td[4]");
    By searchByCampaignNameTextboxLocator = By.xpath("//span[text()='Campaign Name']//..//input");

    WebDriver driver;
    WebDriverWait wait;

    public CampaignReportPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //enter campaign name to search box
    public void searchByCampaignName(String campaignName){
        driver.findElement(searchByCampaignNameTextboxLocator).click();
        driver.findElement(searchByCampaignNameTextboxLocator).sendKeys(campaignName);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(campaignNameLabelLocator, campaignName));
    }


    //get campaign information
    public Campaign getCampaignInformation(){
        Campaign campaign = new Campaign();

        campaign.setName(driver.findElement(campaignNameLabelLocator).getText());
        campaign.setStatus(driver.findElement(statusLabelLocator).getText());
        campaign.setType(driver.findElement(campaignTypeLabelLocator).getText());
        campaign.setStartDate(driver.findElement(startDateLocator).getText());
        campaign.setEndDate(driver.findElement(endDateLocator).getText());

        return campaign;
    }

}
