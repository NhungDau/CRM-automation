package page;

import model.CampaignType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateCampaignPage {
    By campaignTypeListLocator = By.name("j_idt70:j_idt74");

    WebDriver driver;

    public CreateCampaignPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectTypeOption(CampaignType campaignType) {
        Select campaignTypeOption = new Select(driver.findElement(campaignTypeListLocator));
        campaignTypeOption.selectByVisibleText(campaignType.getTypeName());
    }

    public String getSelectedCampaignType() {
        return driver.findElement(campaignTypeListLocator).getText();
    }
}

