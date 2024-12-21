package page;

import model.Revenue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v125.domsnapshot.model.StringIndex;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateRevenuePage {
    By yearTextBoxLocator = By.id("bookForm:year");
    By janTextBoxLocator = By.id("bookForm:January");
    By febTextBoxLocator = By.id("bookForm:February");
    By marTextBoxLocator = By.id("bookForm:March");
    By aprTextBoxLocator = By.id("bookForm:April");
    By mayTextBoxLocator = By.id("bookForm:May");
    By junTextBoxLocator = By.id("bookForm:June");
    By julTextBoxLocator = By.id("bookForm:July");
    By augTextBoxLocator = By.id("bookForm:August");
    By sepTextBoxLocator = By.id("bookForm:September");
    By octTextBoxLocator = By.id("bookForm:October");
    By novTextBoxLocator = By.id("bookForm:November");
    By decTextBoxLocator = By.id("bookForm:December");
    By saveButtonLocator = By.name("bookForm:j_idt97");

    WebDriver driver;
    WebDriverWait wait;

    public CreateRevenuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterJan(int jan) {
        driver.findElement(janTextBoxLocator).sendKeys(Integer.toString(jan));
    }

    public void enterFeb(int feb) {
        driver.findElement(febTextBoxLocator).sendKeys(Integer.toString(feb));
    }

    public void enterMar(int mar) {
        driver.findElement(marTextBoxLocator).sendKeys(Integer.toString(mar));
    }

    public void enterApr(int apr) {
        driver.findElement(aprTextBoxLocator).sendKeys(Integer.toString(apr));
    }

    public void enterMay(int may) {
        driver.findElement(mayTextBoxLocator).sendKeys(Integer.toString(may));
    }

    public void enterJun(int jun) {
        driver.findElement(junTextBoxLocator).sendKeys(Integer.toString(jun));
    }

    public void enterJul(int jul) {
        driver.findElement(julTextBoxLocator).sendKeys(Integer.toString(jul));
    }

    public void enterAug(int aug) {
        driver.findElement(augTextBoxLocator).sendKeys(Integer.toString(aug));
    }

    public void enterSep(int sep) {
        driver.findElement(sepTextBoxLocator).sendKeys(Integer.toString(sep));
    }

    public void enterOct(int oct) {
        driver.findElement(octTextBoxLocator).sendKeys(Integer.toString(oct));
    }

    public void enterNov(int nov) {
        driver.findElement(novTextBoxLocator).sendKeys(Integer.toString(nov));
    }

    public void enterDec(int dec) {
        driver.findElement(decTextBoxLocator).sendKeys(Integer.toString(dec));
    }

    public void enterYear(int year) {
        driver.findElement(yearTextBoxLocator).sendKeys(Integer.toString(year));
    }

    public void createRevenue(Revenue revenue) {
        enterYear(revenue.getYear());
        enterJan(revenue.getJan());
        enterFeb(revenue.getFeb());
        enterMar(revenue.getMar());
        enterApr(revenue.getApr());
        enterMay(revenue.getMay());
        enterJun(revenue.getJun());
        enterJul(revenue.getJul());
        enterAug(revenue.getAug());
        enterSep(revenue.getSep());
        enterOct(revenue.getOct());
        enterNov(revenue.getNov());
        enterDec(revenue.getDec());
    }

    public void clickSaveButton() {
        driver.findElement(saveButtonLocator).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(saveButtonLocator));
    }
}
