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
    By searchByCampaignNameTextboxLocator = By.xpath("//span[text()='Campaign Name']//..//input[@class='ui-column-filter ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all']");
    By searchByCampaignTypeTextboxLocator = By.xpath("//span[text()='Type']//..//input[@class='ui-column-filter ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all']");
    By dynamicCampaignNameLocator;
    Random random = new Random();

    WebDriver driver;

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
        driver.findElement(searchByCampaignNameTextboxLocator).sendKeys(campaignName);
    }

    //enter campaign typr to search box
    public void searchByCampaignType(String campaginType) {
        driver.findElement(searchByCampaignTypeTextboxLocator).sendKeys();
    }


}
