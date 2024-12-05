package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class CreateOrderPage {

    By getListProductByNameLocator = By.xpath("//tr[td/input[@type='checkbox']]/td[2]");
    By paymentDateTextboxLocator = By.xpath("//input[@id='j_idt74:pd']");

    Random random = new Random();



    WebDriver driver;

    public CreateOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addOrderByIndex(int a){
        List<WebElement> list = driver.findElements(getListProductByNameLocator);
        int index = random.nextInt(20)+1;
        int quantity = random.nextInt(list.size()+1);
        list.get(list.size()-1).click();

    }

}
