package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShowAllCustomer1Page {
    By campaignsNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Campaigns']");
    By showAllCampaignsLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Campaigns']");

    WebDriver driver;

    public ShowAllCustomer1Page(WebDriver driver) {
        this.driver = driver;
    }

    public void openShowAllCampaignsPage() {
        driver.findElement(campaignsNavigationLabelLocator).click();
        driver.findElement(showAllCampaignsLabelLocator).click();
    }
}
