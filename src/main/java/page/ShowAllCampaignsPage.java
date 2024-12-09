package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ShowAllCampaignsPage {
    By campaignNameLabelLocator = By.xpath("//a[@class='ui-link ui-widget']");
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
}
