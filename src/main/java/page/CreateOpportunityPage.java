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
    public void createOpportunity(){
        random = new Random();

        WebElement dropdownElement = driver.findElement(statusDropdownLocator);
        dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();
        Random random1 = new Random();
        int randomOptionIndex = random1.nextInt(options.size());


        List<WebElement> productNamelist = driver.findElements(productPriceLocator);
        int a = random.nextInt(productNamelist.size()+1);

        List<WebElement> priceList = driver.findElements(productPriceLocator);


        //click checkbox
        List<WebElement> checkboxlist = driver.findElements(checkboxLocator);
        checkboxlist.get(a).click();
        //select random status
        dropdown.selectByIndex(randomOptionIndex);
        //get status
        String statusOptionTextValue = dropdown.getFirstSelectedOption().getText();
        //get product name
        String productName = productNamelist.get(a).getText();
        //get product price
        Double price = Double.parseDouble(priceList.get(a).getText());

        //add information to object
        opportunityInformation = new OpportunityInformation(statusOptionTextValue,productName, price);

        //click add opportunity button
        driver.findElement(createOpportunityLocator).click();

    }

}
