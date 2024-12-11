package page;

import model.ProductOrderInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
    By createOrderButtonLocator = By.xpath("//input[@value='Create order']");


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
        Random random = new Random();
        int quantity = random.nextInt(20)+1;

        List<WebElement> list = driver.findElements(getListQuantityTextBoxLocator);
        list.get(index).sendKeys(String.valueOf(quantity));
    }

    //click create order button
    public void clickCreateOrderButton(){
        driver.findElement(createOrderButtonLocator).click();
    }
    //get product price
    public double getProductPriceByIndex(int index){
        List<WebElement> list = driver.findElements(getListProductPriceLocator);
        return Double.parseDouble(list.get(index).getText());
    }

    public void addOrderByIndex(int a){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        List<WebElement> list = driver.findElements(getListProductByNameLocator);

        //enter payment date
        LocalDate today = LocalDate.now();
            // date format yyy-mm-dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String paymentdate = today.format(formatter);

        enterPaymentDate(paymentdate);

        //check checkbox
        clickCheckboxByIndex(a);
        //enter quantity
        enterQuantityByIndex(a);

    }

    public ProductOrderInformation getProductOrderInformation(int a){

        ProductOrderInformation product =  new ProductOrderInformation();

        product.setProductName(driver.findElements(getListProductByNameLocator).get(a).getText());

        Double price = Double.parseDouble(driver.findElements(getListProductPriceLocator).get(a).getText());
        product.setProductPrice(price);


        Integer quantity = Integer.parseInt(driver.findElements(getListQuantityTextBoxLocator).get(a).getText());
        product.setProductQuantity(quantity);

        product.setTotalPrice(price*quantity);

        product.setPaymentDate(driver.findElement(paymentDateTextboxLocator).getText());

        return product;
    }



}
