package page;

import constant.Driver;
import org.openqa.selenium.By;

public class BasePage {
    By customerNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Customer']");
    By showAllCustomersLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Customers']");
    By createCustomerLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Create Customer']");
    By remindersNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Reminders']");
    By showAllRemindersLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Reminders']");
    By campaignsNavigationLabelLocator = By.xpath("//span[@class='nav-label'][text()='Campaigns']");
    By showAllCampaignsLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Create Campaign']");
    By createCampaignLabelLocator = By.xpath("//ul[@class='nav nav-second-level collapse in']//a[text()='Show All Reminders']");
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

    //open showAllCustomer page
    public void openShowAllCustomersPage() {
        Driver.driver.findElement(customerNavigationLabelLocator).click();
        Driver.driver.findElement(showAllCustomersLabelLocator).click();
    }
    //open create customer page
    public void openCreateCustomerPage() {
        Driver.driver.findElement(customerNavigationLabelLocator).click();
        Driver.driver.findElement(createCustomerLabelLocator).click();
    }
    //open showAllReminder page
    public void openShowAllRemindersPage() {
        Driver.driver.findElement(remindersNavigationLabelLocator).click();
        Driver.driver.findElement(showAllRemindersLabelLocator).click();
    }
    //open showAllCampaign page
    public void openShowAllCampaignsPage() {
        Driver.driver.findElement(campaignsNavigationLabelLocator).click();
        Driver.driver.findElement(showAllCampaignsLabelLocator).click();
    }

    //open create campaign page
    public void openCreateCampaignPage() {
        Driver.driver.findElement(campaignsNavigationLabelLocator).click();
        Driver.driver.findElement(createCampaignLabelLocator).click();
    }

    //open showAllCampaignTypesLabelLocator page
    public void openShowAllCampaignTypesPage() {
        Driver.driver.findElement(campaignsNavigationLabelLocator).click();
        Driver.driver.findElement(showAllCampaignTypesLabelLocator).click();
    }

    //open create campaign page
    public void openCreateCampaignTypePage() {
        Driver.driver.findElement(campaignsNavigationLabelLocator).click();
        Driver.driver.findElement(createCampaignTypesLabelLocator).click();
    }

    //open showAllOpportunities page
    public void openShowAllOpportunitiesPage() {
        Driver.driver.findElement(opportunitiesNavigationLabelLocator).click();
        Driver.driver.findElement(showAllOpportunitysLabelLocator).click();
    }
    //open showAllOrders page
    public void openShowAllOrdersPage() {
        Driver.driver.findElement(ordersNavigationLabelLocator).click();
        Driver.driver.findElement(showAllOrdersLabelLocator).click();
    }

    //open create revenue page
    public void openCreateRevenuePage() {
        Driver.driver.findElement(revenuesNavigationLabelLocator).click();
        Driver.driver.findElement(createRevenueLabelLocator).click();
    }

    //open search revenue page
    public void openSearchRevenuePage() {
        Driver.driver.findElement(revenuesNavigationLabelLocator).click();
        Driver.driver.findElement(searchRevenueLabelLocator).click();
    }
    //open Campaign report page
    public void openCampaignReportsPage() {
        Driver.driver.findElement(reportNavigationLabelLocator).click();
        Driver.driver.findElement(campaignReportsLabelLocator).click();
    }

}
