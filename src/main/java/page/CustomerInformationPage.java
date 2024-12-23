package page;

import model.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CustomerInformationPage extends BasePage {
    By addOrderButtonLocator = By.xpath("//a[text()='Add order']");
    By paymentDateLocator = By.xpath("//tr/td/a");
    By priceLocator = By.xpath("//th[text()='Total Price']/../..//../tbody//tr//td[2]");
    By addOpportunityButtonLocator = By.xpath("//a[text()='Add opportunity']");
    By campaignNameLabelLocator = By.xpath("//h5[text()='Campaigns']/../../div[@class='ibox-content']//table//td/a");
    By editCustomerInformationButtonLocator = By.xpath("//a[@class='btn btn-primary'][text()='Edit']");
    By customerNameLabelLocator = By.xpath("//label[@class='col-lg-1'][text()='Name:']/../div/span");
    By customerEmailLabelLocator = By.xpath("//label[@class='col-lg-1'][text()='Email:']/../div/span");
    By customerPhoneLabelLocator = By.xpath("//label[@class='col-lg-1'][text()='Phone:']/../div/span");
    By customerAddressLabelLocator = By.xpath("//label[@class='col-lg-1'][text()='Address:']/../div/span");
    By addCampaignButtonLocator = By.xpath("//a[@class='btn btn-primary'][text()='Add campaign']");
    By campaignTypeLabelLocator = By.xpath("//h5[text()='Campaigns']/../../div[@class='ibox-content']//table//tbody//td[2]");
    By campaignStatusLabelLocator = By.xpath("//h5[text()='Campaigns']/../../div[@class='ibox-content']//table//tbody//td[3]");
    By campaignStartDateLabelLocator = By.xpath("//h5[text()='Campaigns']/../../div[@class='ibox-content']//table//tbody//td[4]");
    By campaignEndDateLabelLocator = By.xpath("//h5[text()='Campaigns']/../../div[@class='ibox-content']//table//tbody//td[5]");
    By campaignExpectedRevenueLabelLocator = By.xpath("//h5[text()='Campaigns']/../../div[@class='ibox-content']//table//tbody//td[6]");
    By campaignBudgetedCostLabelLocator = By.xpath("//h5[text()='Campaigns']/../../div[@class='ibox-content']//table//tbody//td[7]");
    By campaignActualCostLabelLocator = By.xpath("//h5[text()='Campaigns']/../../div[@class='ibox-content']//table//tbody//td[8]");
    By opportunityStatusLocator = By.xpath("//div//h5[text()='Opportunity']/../following-sibling::div//tbody//tr//td[1]");
    By opportunityProductNameLocator = By.xpath("//div//h5[text()='Opportunity']/../following-sibling::div//tbody//tr//td[2]");
    By opportunityProductPriceLocator = By.xpath("//div//h5[text()='Opportunity']/../following-sibling::div//tbody//tr//td[3]");
    By addReminderButtonLocator = By.xpath("//a[@class='btn btn-primary'][text()='Add reminder']");
    By reminderDateLabelLocator = By.xpath("//h5[text()='Reminder']/../../div[@class='ibox-content']//table//td[1]");
    By reminderTimeLabelLocator = By.xpath("//h5[text()='Reminder']/../../div[@class='ibox-content']//table//td[2]");
    By reminderDescriptionLabelLocator = By.xpath("//h5[text()='Reminder']/../../div[@class='ibox-content']//table//td[3]");


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public CustomerInformationPage(WebDriver driver) {
        super(driver);
    }


    //click add order button
    public void clickAddOrderButton() {

        driver.findElement(addOrderButtonLocator).click();
    }

    //click last payment date to open order information page
    public void clickLastPaymentDate() {
        driver.findElement(paymentDateLocator).click();
    }

    //click add opportunity button
    public void clickAddOpportunityButton() {
        driver.findElement(addOpportunityButtonLocator).click();
    }

    //get latest order display
    public OrderInformation getLatestOrderInformation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        OrderInformation orderInformation = new OrderInformation();

        List<WebElement> list = driver.findElements(paymentDateLocator);
        int a = list.size() - 1;
        orderInformation.setPaymentDate(driver.findElements(paymentDateLocator).get(a).getText());
        orderInformation.setTotalPrice(Double.parseDouble(driver.findElements(priceLocator).get(a).getText()));

        return orderInformation;
    }


    public void openEditCustomerInformationPage() {
        driver.findElement(editCustomerInformationButtonLocator).click();
    }

    public String getCustomerName() {
        return driver.findElement(customerNameLabelLocator).getText();
    }

    public Customer getCustomerInformation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Customer customer = new Customer();
        customer.setName(driver.findElement(customerNameLabelLocator).getText());
        customer.setEmail(driver.findElement(customerEmailLabelLocator).getText());
        customer.setPhone(driver.findElement(customerPhoneLabelLocator).getText());
        customer.setAddress(driver.findElement(customerAddressLabelLocator).getText());
        return customer;
    }

    public void openCampaignInformationPage() {
        driver.findElement(campaignNameLabelLocator).click();
    }

    //open Add customer into campaign page
    public void clickAddCampaignButton() {
        driver.findElement(addCampaignButtonLocator).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(customerNameLabelLocator));
    }

    public void openAddCampaignIntoCustomerPage() {
        driver.findElement(addCampaignButtonLocator).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(customerNameLabelLocator));
    }

    public Campaign getCampaignInformation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Campaign campaign = new Campaign();
        campaign.setName(driver.findElement(campaignNameLabelLocator).getText());
        campaign.setType(driver.findElement(campaignTypeLabelLocator).getText());
        campaign.setStatus(driver.findElement(campaignStatusLabelLocator).getText());
        campaign.setStartDate(driver.findElement(campaignStartDateLabelLocator).getText());
        campaign.setEndDate(driver.findElement(campaignEndDateLabelLocator).getText());
        campaign.setExpectedRevenue((int)Double.parseDouble(driver.findElement(campaignExpectedRevenueLabelLocator).getText()));
        campaign.setBudgetedCost((int)Double.parseDouble(driver.findElement(campaignBudgetedCostLabelLocator).getText()));
        campaign.setActualCost((int)Double.parseDouble(driver.findElement(campaignActualCostLabelLocator).getText()));
        return campaign;
    }


    public OpportunityInformation getLastOpportunityInformation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        OpportunityInformation o = new OpportunityInformation();
        List<WebElement> status = driver.findElements(opportunityStatusLocator);
        o.setStatus(status.get(status.size() - 1).getText());

        List<WebElement> name = driver.findElements(opportunityProductNameLocator);
        o.setProductName(name.get(name.size() - 1).getText());

        List<WebElement> price = driver.findElements(opportunityProductPriceLocator);
        String stringPrice = price.get(name.size() - 1).getText();
        o.setPrice(Double.parseDouble(stringPrice.substring(0, stringPrice.length() - 3)));

        return o;
    }

    public void openCreateReminderPage() {
        driver.findElement(addReminderButtonLocator).click();
    }

    public Reminder getReminderInformation() {
        Reminder reminder = new Reminder();
        reminder.setDate(driver.findElement(reminderDateLabelLocator).getText());
        reminder.setTime(driver.findElement(reminderTimeLabelLocator).getText());
        reminder.setDescription(driver.findElement(reminderDescriptionLabelLocator).getText());
        return reminder;
    }

    public boolean isReminderDisplay(String description){
        boolean display = true;
        List<WebElement> list = driver.findElements(reminderDescriptionLabelLocator);
        for (WebElement a : list){
//            if (a.getText())
        }
    }
}
