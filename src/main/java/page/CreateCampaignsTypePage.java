package page;

import model.CampaignType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateCampaignsTypePage {
    By campaignTypeNameTextBoxLocator = By.id("campaigntypeform:ctn");
    By saveButtonLocator = By.xpath("//input[@value='Save']");

    WebDriver driver;

    public CreateCampaignsTypePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCampaignTypeName(String type) {
        driver.findElement(campaignTypeNameTextBoxLocator).sendKeys(type);
    }

    public CampaignType getNewCampaignType() {
       return new CampaignType(driver.findElement(campaignTypeNameTextBoxLocator).getText());
    }

    public void clickSaveButton() {
        driver.findElement(saveButtonLocator).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
