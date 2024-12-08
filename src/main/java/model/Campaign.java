package model;

public class Campaign {
    String name;
    String type;
    String status;
    String startDate;
    String endDate;
    Double expectedRevenue;
    Double budgetedCost;
    Double actualCost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getExpectedRevenue() {
        return expectedRevenue;
    }

    public void setExpectedRevenue(Double expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public Double getBudgetedCost() {
        return budgetedCost;
    }

    public void setBudgetedCost(Double budgetedCost) {
        this.budgetedCost = budgetedCost;
    }

    public Double getActualCost() {
        return actualCost;
    }

    public void setActualCost(Double actualCost) {
        this.actualCost = actualCost;
    }

//    public Campaign(String name, String type, String status, String startDate, String endDate, Double expectedRevenue, Double budgetedCost, Double actualCost) {
//        this.name = name;
//        this.type = type;
//        this.status = status;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.expectedRevenue = expectedRevenue;
//        this.budgetedCost = budgetedCost;
//        this.actualCost = actualCost;
//    }
}
