package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    By customerNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Customer']");
    By showAllCustomersLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Customers']");
    By createCustomerLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Create Customer']");
    By remindersNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Reminders']");
    By showAllRemindersLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Reminders']");
    By campaignsNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Campaigns']");
    By showAllCampaignsLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Campaigns']");
    By createCampaignLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Create Campaign']");
    By showAllCampaignTypesLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Campaign Types']");
    By createCampaignTypesLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Create Campaign Type']");
    By opportunitiesNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Opportunities']");
    By showAllOpportunitysLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Opportunitys']");
    By ordersNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Orders']");
    By showAllOrdersLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Orders']");
    By revenuesNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Revenues']");
    By searchRevenueLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Search Revenue']");
    By createRevenueLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Create Revenue']");
    By reportNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Report']");
    By campaignReportsLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Campaign Reports']");


    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //open showAllCustomer page
    public void openShowAllCustomersPage() {
        driver.findElement(customerNavigationLabelLocator).click();
        driver.findElement(showAllCustomersLabelLocator).click();
    }
    //open create customer page
    public void openCreateCustomerPage() {
        driver.findElement(customerNavigationLabelLocator).click();
        driver.findElement(createCustomerLabelLocator).click();
    }
    //open showAllReminder page
    public void openShowAllRemindersPage() {
        driver.findElement(remindersNavigationLabelLocator).click();
        driver.findElement(showAllRemindersLabelLocator).click();
    }
    //open showAllCampaign page
    public void openShowAllCampaignsPage() {
        driver.findElement(campaignsNavigationLabelLocator).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(showAllCampaignsLabelLocator));
        driver.findElement(showAllCampaignsLabelLocator).click();
    }

    //open create campaign page
    public void openCreateCampaignPage() {
        driver.findElement(campaignsNavigationLabelLocator).click();
        driver.findElement(createCampaignLabelLocator).click();
    }

    //open showAllCampaignTypesLabelLocator page
    public void openShowAllCampaignTypesPage() {
        driver.findElement(campaignsNavigationLabelLocator).click();
        driver.findElement(showAllCampaignTypesLabelLocator).click();
    }

    //open create campaign page
    public void openCreateCampaignTypePage() {
        driver.findElement(campaignsNavigationLabelLocator).click();
        driver.findElement(createCampaignTypesLabelLocator).click();
    }

    //open showAllOpportunities page
    public void openShowAllOpportunitiesPage() {
        driver.findElement(opportunitiesNavigationLabelLocator).click();
        driver.findElement(showAllOpportunitysLabelLocator).click();
    }
    //open showAllOrders page
    public void openShowAllOrdersPage() {
        driver.findElement(ordersNavigationLabelLocator).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(showAllOrdersLabelLocator));

        driver.findElement(showAllOrdersLabelLocator).click();
    }

    //open create revenue page
    public void openCreateRevenuePage() {
        driver.findElement(revenuesNavigationLabelLocator).click();
        driver.findElement(createRevenueLabelLocator).click();
    }

    //open search revenue page
    public void openSearchRevenuePage() {
        driver.findElement(revenuesNavigationLabelLocator).click();
        driver.findElement(searchRevenueLabelLocator).click();
    }
    //open Campaign report page
    public void openCampaignReportsPage() {
        driver.findElement(reportNavigationLabelLocator).click();
        driver.findElement(campaignReportsLabelLocator).click();
    }

}
