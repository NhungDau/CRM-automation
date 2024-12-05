package model;

public class ProductOrderInformation {

    private String productName;
    private Integer productQuantity;
    private Double productPrice;

    public ProductOrderInformation(String productName, Double productPrice, Integer productQuantity) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public ProductOrderInformation() {
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

    public ProductOrderInformation productOrderInformation(String productName, double price, int quantity){
        return new ProductOrderInformation(this.productName,productPrice,productQuantity);
    }
}
