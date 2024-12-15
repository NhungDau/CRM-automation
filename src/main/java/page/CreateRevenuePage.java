package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public CreateRevenuePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSaveButton() {
        driver.findElement(saveButtonLocator).click();
    }
}
