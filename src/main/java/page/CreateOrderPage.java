package page;

import model.ProductOrderInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class CreateOrderPage  {

    By getListProductByNameLocator = By.xpath("//tr[td/input[@type='checkbox']]/td[2]");
    By getListCheckboxLocator = By.xpath("//tr/td/input[@type='checkbox']");
    By getListQuantityTextBoxLocator = By.xpath("//tr[td/input[@type='checkbox']]/td[4]/input");
    By getListProductPriceLocator = By.xpath("//tr[td/input[@type='checkbox']]/td[3]");
    By paymentDateTextboxLocator = By.xpath("//input[@id='j_idt74:pd']");


    Random random = new Random();
    LocalDate today = LocalDate.now();
    // date format yyy-mm-dd
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String paymentdate = today.format(formatter);

    int quantity = random.nextInt(20)+1;

    WebDriver driver;

    public CreateOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //enter paymentdate
    public void enterPaymentDate(String paymentDate){
        driver.findElement(paymentDateTextboxLocator).sendKeys(paymentDate);
    }
    //click checkbox
    public void clickCheckboxByIndex(int index){
        List<WebElement> list = driver.findElements(getListCheckboxLocator);
        list.get(index).click();
    }
    //enter product quantity
    public void enterQuantityByIndex(int index){
        List<WebElement> list = driver.findElements(getListQuantityTextBoxLocator);
        list.get(index).sendKeys(String.valueOf(quantity));
    }
    //get product price
    public double getProductPriceByIndex(int index){
        List<WebElement> list = driver.findElements(getListProductPriceLocator);
        return Double.parseDouble(list.get(index).getText());
    }

    public void addOrderByIndex(){
        ProductOrderInformation productOrderInformation;
        List<WebElement> list = driver.findElements(getListProductByNameLocator);

        int index = random.nextInt(list.size()+1);

        //enter payment date
        enterPaymentDate(paymentdate);
        //check checkbox
        clickCheckboxByIndex(index);
        //enter quantity
        enterQuantityByIndex(index);
        //get product name
        String productName = list.get(index).getText();
        //get product price
        double price = getProductPriceByIndex(index);
        double totalPrice = price*quantity;
        //productOrderInformation.productOrderInformation(productName,price,quantity);
        productOrderInformation = new ProductOrderInformation(productName, price,quantity,totalPrice,paymentdate);



    }

}
