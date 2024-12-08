package model;

import java.util.Objects;

public class OpportunityInformation {

    private String status;
    private String productName;
    private Double price;

    public OpportunityInformation(String status, String productName, Double price) {
        this.status = status;
        this.productName = productName;
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpportunityInformation that = (OpportunityInformation) o;
        return Objects.equals(status, that.status) && Objects.equals(productName, that.productName) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, productName, price);
    }
}
