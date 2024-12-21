package page;

import model.Revenue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RevenueInformationPage extends BasePage {
    By searchButtonLocator = By.xpath("//input[@class='btn btn-primary'][@value='Search']");
    By searchYearTextBoxLocator = By.xpath("//input[@name='bookForm:j_idt71']");
    By expectedRevenueOfJanLocator = By.xpath("//table[@class=\"table table-striped table-bordered table-hover dataTables-example\"]/tbody/tr[2]/td[2]");
    By expectedRevenueOfFebLocator = By.xpath("//table[@class=\"table table-striped table-bordered table-hover dataTables-example\"]/tbody/tr[3]/td[2]");
    By expectedRevenueOfMarLocator = By.xpath("//table[@class=\"table table-striped table-bordered table-hover dataTables-example\"]/tbody/tr[4]/td[2]");
    By expectedRevenueOfAprLocator = By.xpath("//table[@class=\"table table-striped table-bordered table-hover dataTables-example\"]/tbody/tr[5]/td[2]");
    By expectedRevenueOfMayLocator = By.xpath("//table[@class=\"table table-striped table-bordered table-hover dataTables-example\"]/tbody/tr[6]/td[2]");
    By expectedRevenueOfJunLocator = By.xpath("//table[@class=\"table table-striped table-bordered table-hover dataTables-example\"]/tbody/tr[7]/td[2]");
    By expectedRevenueOfJulLocator = By.xpath("//table[@class=\"table table-striped table-bordered table-hover dataTables-example\"]/tbody/tr[8]/td[2]");
    By expectedRevenueOfAugLocator = By.xpath("//table[@class=\"table table-striped table-bordered table-hover dataTables-example\"]/tbody/tr[9]/td[2]");
    By expectedRevenueOfSepLocator = By.xpath("//table[@class=\"table table-striped table-bordered table-hover dataTables-example\"]/tbody/tr[10]/td[2]");
    By expectedRevenueOfOctLocator = By.xpath("//table[@class=\"table table-striped table-bordered table-hover dataTables-example\"]/tbody/tr[11]/td[2]");
    By expectedRevenueOfNovLocator = By.xpath("//table[@class=\"table table-striped table-bordered table-hover dataTables-example\"]/tbody/tr[12]/td[2]");
    By expectedRevenueOfDecLocator = By.xpath("//table[@class=\"table table-striped table-bordered table-hover dataTables-example\"]/tbody/tr[13]/td[2]");

    WebDriver driver;

    public RevenueInformationPage(WebDriver driver) {
        super(driver);
    }

    public void searchRevenueByYear(String year) {
        driver.findElement(searchYearTextBoxLocator).click();
        driver.findElement(searchYearTextBoxLocator).clear();
        driver.findElement(searchYearTextBoxLocator).sendKeys(year);
        driver.findElement(searchButtonLocator).click();
    }

    public Revenue getRevenueResult() {
        Revenue revenue = new Revenue();

        revenue.setJan(Integer.parseInt(driver.findElement(expectedRevenueOfJanLocator).getText().replace("VND", "")));
        revenue.setFeb(Integer.parseInt(driver.findElement(expectedRevenueOfFebLocator).getText().replace("VND", "")));
        revenue.setMar(Integer.parseInt(driver.findElement(expectedRevenueOfMarLocator).getText().replace("VND", "")));
        revenue.setApr(Integer.parseInt(driver.findElement(expectedRevenueOfAprLocator).getText().replace("VND", "")));
        revenue.setMay(Integer.parseInt(driver.findElement(expectedRevenueOfMayLocator).getText().replace("VND", "")));
        revenue.setJun(Integer.parseInt(driver.findElement(expectedRevenueOfJunLocator).getText().replace("VND", "")));
        revenue.setJul(Integer.parseInt(driver.findElement(expectedRevenueOfJulLocator).getText().replace("VND", "")));
        revenue.setAug(Integer.parseInt(driver.findElement(expectedRevenueOfAugLocator).getText().replace("VND", "")));
        revenue.setSep(Integer.parseInt(driver.findElement(expectedRevenueOfSepLocator).getText().replace("VND", "")));
        revenue.setOct(Integer.parseInt(driver.findElement(expectedRevenueOfOctLocator).getText().replace("VND", "")));
        revenue.setNov(Integer.parseInt(driver.findElement(expectedRevenueOfNovLocator).getText().replace("VND", "")));
        revenue.setDec(Integer.parseInt(driver.findElement(expectedRevenueOfDecLocator).getText().replace("VND", "")));

        return revenue;
    }
}
