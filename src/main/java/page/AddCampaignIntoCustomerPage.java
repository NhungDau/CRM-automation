package page;

import model.Campaign;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCampaignIntoCustomerPage {
    By dynamicCheckBoxByCampaignNameLocator;
    By addButtonLocator = By.name("j_idt72:j_idt103");
    WebDriver driver;

    public AddCampaignIntoCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCampainByCampainName(Campaign campaign) {
        String xpathValue = String.format("//tbody//td[2][text()='%s']..//input[@type='checkbox']", campaign.getName());
        dynamicCheckBoxByCampaignNameLocator = By.xpath(xpathValue);
        driver.findElement(dynamicCheckBoxByCampaignNameLocator).click();
    }

    public void clickToAddButton() {
        driver.findElement(addButtonLocator).click();
    }
}
