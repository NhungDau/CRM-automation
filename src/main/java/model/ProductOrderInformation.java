package model;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "ProductOrderInformation{" +
                "productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", productPrice=" + productPrice +
                ", totalPrice=" + totalPrice +
                ", paymentDate='" + paymentDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrderInformation that = (ProductOrderInformation) o;
        return Objects.equals(productName, that.productName) && Objects.equals(productQuantity, that.productQuantity) && Objects.equals(productPrice, that.productPrice) && Objects.equals(totalPrice, that.totalPrice) && Objects.equals(paymentDate, that.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productQuantity, productPrice, totalPrice, paymentDate);
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
    public ProductOrderInformation(){}
}
