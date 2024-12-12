package page;

import model.OpportunityInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class CreateOpportunityPage {

    By productNameLocator = By.xpath("//tr//td[3]");
    By productPriceLocator = By.xpath("//tr//td[4]");
    By checkboxLocator = By.xpath("//tr//td[1]");
    By statusDropdownLocator = By.xpath("//tr//td[2]//select");
    By createOpportunityLocator = By.xpath("//input[@value='Create opportunity']");

    WebDriver driver;

    public CreateOpportunityPage(WebDriver driver) {
        this.driver = driver;
    }

    Select dropdown;
    Random random;
    OpportunityInformation opportunityInformation;


    //create opportunity
    public void createOpportunityByIndex(int a) {

        //click checkbox
        List<WebElement> checkboxlist = driver.findElements(checkboxLocator);
        checkboxlist.get(a).click();

        //select random status

        dropdown = new Select(driver.findElement(statusDropdownLocator));
        List<WebElement> options = dropdown.getOptions();
        Random random1 = new Random();
        int randomOptionIndex = random1.nextInt(options.size());

        dropdown.selectByIndex(randomOptionIndex);
    }

    //get opportunity information
    public OpportunityInformation getOpportunityInformationopportunityInformation(int a) {
        opportunityInformation = new OpportunityInformation();
        //get status

        List<WebElement> statusDropdown = driver.findElements(statusDropdownLocator);
        WebElement dropdownByIndex = statusDropdown.get(a);
        Select dropdown = new Select(dropdownByIndex);
        opportunityInformation.setStatus(dropdown.getFirstSelectedOption().getText());

        //get product name
        opportunityInformation.setProductName(driver.findElements(productPriceLocator).get(a).getText());

        //get product price
        opportunityInformation.setPrice(Double.parseDouble(driver.findElements(productPriceLocator).get(a).getText()));


        return opportunityInformation;
    }

    //click add oppotunity button
    public void clickAddOpportunityButton() {
        driver.findElement(createOpportunityLocator).click();
    }
}
