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

    By productNameLocator = By.xpath("//tr[td/input[@type='checkbox']]/td[2]");
    By checkboxLocator = By.xpath("//tr/td/input[@type='checkbox']");
    By quantityTextBoxLocator = By.xpath("//tr[td/input[@type='checkbox']]/td[4]/input");
    By priceLocator = By.xpath("//tr[td/input[@type='checkbox']]/td[3]");
    By paymentDateTextboxLocator = By.xpath("//input[@id='j_idt74:pd']");
    By createOrderButtonLocator = By.xpath("//input[@value='Create order']");


    Random random;
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
        List<WebElement> list = driver.findElements(checkboxLocator);
        list.get(index).click();
    }
    //enter product quantity
    public void enterQuantityByIndex(int index){
        Random random = new Random();
        int quantity = random.nextInt(20)+1;

        List<WebElement> list = driver.findElements(quantityTextBoxLocator);
        list.get(index).sendKeys(String.valueOf(quantity));
    }

    //click create order button
    public void clickCreateOrderButton(){
        driver.findElement(createOrderButtonLocator).click();
    }
    //get product price
    public double getProductPriceByIndex(int index){
        List<WebElement> list = driver.findElements(priceLocator);
        return Double.parseDouble(list.get(index).getText());
    }

    //get total product in page
    public int getTotalProduct(){
        List<WebElement> list = driver.findElements(productNameLocator);
        return list.size();
    }

    public void selectProductByRandomIndex(int a){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        product.setProductName(driver.findElements(productNameLocator).get(a).getText());

        Double price = Double.parseDouble(driver.findElements(priceLocator).get(a).getText());
        product.setProductPrice(price);


        Integer quantity = Integer.parseInt(driver.findElements(quantityTextBoxLocator).get(a).getAttribute("value"));
        product.setProductQuantity(quantity);

        product.setTotalPrice(price*quantity);

        product.setPaymentDate(driver.findElement(paymentDateTextboxLocator).getAttribute("value"));

        return product;
    }



}
