package page;

import model.CampaignType;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShowAllCampaignTypePage extends BasePage {
    By searchTextBoxLocator = By.id("formcampaigntype:j_idt72:j_idt73:filter");
    By getCampaignTypeNameLabelLocator = By.xpath("//tr[@class='ui-widget-content ui-datatable-even']/td[1]");
    By newCampaignTypeButtonLocator = By.xpath("//a[@class=\"btn btn-primary\"][text()='New Campagin Type']");

    WebDriverWait wait;

    public ShowAllCampaignTypePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    public void searchByCampaignType(CampaignType campaignType) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newCampaignTypeButtonLocator));
        driver.findElement(searchTextBoxLocator).click();
        driver.findElement(searchTextBoxLocator).sendKeys(campaignType.getTypeName());
        wait.until(ExpectedConditions.textToBePresentInElementLocated(getCampaignTypeNameLabelLocator, campaignType.getTypeName()));

    }

    public boolean isSearchResultCorrect(CampaignType campaignType) {
        if (driver.findElement(getCampaignTypeNameLabelLocator).getText().equalsIgnoreCase(campaignType.getTypeName())) {
            return true;
        } else {
            return false;
        }
    }

}
