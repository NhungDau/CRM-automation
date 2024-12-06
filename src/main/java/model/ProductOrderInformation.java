package model;

public class ProductOrderInformation {

    private String productName;
    private Integer productQuantity;
    private Double productPrice;
    private Double totalPrice;
    private String paymentDate;

    public ProductOrderInformation(String productName, Double productPrice, Integer productQuantity, Double totalPrice, String paymentDate) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.totalPrice = totalPrice;
        this.paymentDate = paymentDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public ProductOrderInformation productOrderInformationInCreateOrderPage(String productName, double price, int quantity ,double totalPrice, String paymentDate){
        return new ProductOrderInformation(productName,price,quantity,totalPrice,paymentDate);
    }
    public ProductOrderInformation productOrderInformationInCustomerInformationPage(String productName, double price, int quantity ,double totalPrice, String paymentDate){
        return new ProductOrderInformation(productName,price,quantity,totalPrice,paymentDate);
    }

}
