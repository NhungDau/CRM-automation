package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ShowAllCampaignsPage {
    By campaignNameLabelLocator = By.xpath("//a[@class='ui-link ui-widget']");
    By searchByCampaignNameTextboxLocator = By.xpath("//span[text()='Campaign Name']//..//input[@class='ui-column-filter ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all']");
    By searchByCampaignTypeTextboxLocator = By.xpath("//span[text()='Type']//..//input[@class='ui-column-filter ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all']");
    Random random = new Random();

    WebDriver driver;

    public ShowAllCampaignsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCampaignInformationPage() {
        List<WebElement> listOfCampaign = driver.findElements(campaignNameLabelLocator);
        int randomIndex = random.nextInt(listOfCampaign.size());
        listOfCampaign.get(randomIndex).click();
    }

    //enter campaign name to search box
    public void searchByCampaignName(String campaignName){
        driver.findElement(searchByCampaignNameTextboxLocator).sendKeys();
    }

    //enter campaign typr to search box
    public void searchByCampaignType(String campaginType){
        driver.findElement(searchByCampaignTypeTextboxLocator).sendKeys();
    }


}
