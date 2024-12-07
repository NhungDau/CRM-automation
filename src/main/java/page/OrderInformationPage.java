package page;

import model.ProductOrderInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderInformationPage {

    By paymentDateLocator = By.xpath("//span[@class='form-control m-b']");
    By productNameLocator = By.xpath("//tr//td[1]");
    By quantityLocator = By.xpath("//tr//td[2]");
    By priceLocator = By.xpath("//tr//td[3]");
    By totalPriceLocator = By.xpath("//tr//td[4]");

    ProductOrderInformation productOrderInformation;

    WebDriver driver;

    public OrderInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getCustomerOderInformation(){
        String productName = driver.findElement(productNameLocator).getText();
        Integer quantity = Integer.parseInt(driver.findElement(quantityLocator).getText());
        Double price = Double.parseDouble(driver.findElement(priceLocator).getText());
        Double totalPrice = Double.parseDouble(driver.findElement(totalPriceLocator).getText());
        String paymentDate = driver.findElement(paymentDateLocator).getText();

        productOrderInformation = new ProductOrderInformation(productName,price,quantity,totalPrice, paymentDate);
    }

    public ProductOrderInformation getProductOrderInformation(){
        return productOrderInformation;
    }

}
