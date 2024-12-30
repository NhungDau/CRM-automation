package page;

import io.qameta.allure.Step;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //By emailTextBoxLocator = By.xpath("//input[@id='campaigntypeform:email']");
    By emailTextBoxLocator = By.id("campaigntypeform:email");
    By passwordTextBoxLocator = By.xpath("//input[@id='campaigntypeform:pass']");
    By loginButtonLocator = By.xpath("//input[@value='Login'][@class='btn btn-primary pull-right']");


    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailTextBoxLocator).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordTextBoxLocator).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

    @Step ("Login in CRM system")
    public void login(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickLoginButton();
    }

}
