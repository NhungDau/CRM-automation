package page;

import model.Revenue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RevenueInformationPage extends BasePage {
    By searchButtonLocator = By.xpath("//input[@class='btn btn-primary'][@value='Search']");
    By searchYearTextBoxLocator = By.xpath("//input[@name='bookForm:j_idt71']");


    WebDriver driver;

    public RevenueInformationPage(WebDriver driver) {
        super(driver);
    }

    public void searchRevenueByYear(int year) {
        driver.findElement(searchYearTextBoxLocator).sendKeys(String.valueOf(year));
        driver.findElement(searchButtonLocator).click();
    }

    public Revenue getRevenueResult() {
        Revenue revenue = new Revenue();

        return revenue;
    }
}
