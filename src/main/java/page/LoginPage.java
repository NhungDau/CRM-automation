package page;

import constant.Driver;
import model.User;
import org.openqa.selenium.By;

public class LoginPage {
    //By emailTextBoxLocator = By.xpath("//input[@id='campaigntypeform:email']");
    By emailTextBoxLocator = By.id("campaigntypeform:email");
    By passwordTextBoxLocator = By.xpath("//input[@id='campaigntypeform:pass']");
    By loginButtonLocator = By.xpath("//input[@value='Login'][@class='btn btn-primary pull-right']");



    public void enterEmail(String email) {
        Driver.driver.findElement(emailTextBoxLocator).sendKeys(email);
    }

    public void enterPassword(String password) {
        Driver.driver.findElement(passwordTextBoxLocator).sendKeys(password);
    }

    public void clickLoginButton() {
        Driver.driver.findElement(loginButtonLocator).click();
    }

    public void login(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickLoginButton();
    }

}
