import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;

import java.sql.Driver;

public class TC02 {

    LoginPage loginPage;


    @BeforeMethod
    public void initData() {
        Driver.driver = new ChromeDriver();
        loginPage = new LoginPage();
        Driver.driver.manage().window().maximize();
        Driver.driver.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");


    }

    @Test
    public void TC02() {
        loginPage.login("vyvanviet@gmail.com","abc123");
    }

    @AfterMethod
    public void cleanUp() {
        Driver.driver.quit();
    }
}
