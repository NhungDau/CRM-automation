package model;

import com.github.javafaker.Faker;

import java.util.Objects;
import java.util.Random;

public class Campaign {

    String name;
    String type;
    String status;
    String startDate;
    String endDate;
    Integer expectedRevenue;
    Integer budgetedCost;
    Integer actualCost;
    String description;



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

    public Integer getExpectedRevenue() {
        return expectedRevenue;
    }

    public void setExpectedRevenue(Integer expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public Integer getBudgetedCost() {
        return budgetedCost;
    }

    public void setBudgetedCost(Integer budgetedCost) {
        this.budgetedCost = budgetedCost;
    }

    public Integer getActualCost() {
        return actualCost;
    }

    public void setActualCost(Integer actualCost) {
        this.actualCost = actualCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Campaign(String name, String type, String status, String startDate, String endDate, Integer expectedRevenue, Integer budgetedCost, Integer actualCost, String description) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.expectedRevenue = expectedRevenue;
        this.budgetedCost = budgetedCost;
        this.actualCost = actualCost;
        this.description = description;
    }


    public Campaign() {
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(name, campaign.name) && Objects.equals(type, campaign.type) && Objects.equals(status, campaign.status) && Objects.equals(startDate, campaign.startDate) && Objects.equals(endDate, campaign.endDate) && Objects.equals(expectedRevenue, campaign.expectedRevenue) && Objects.equals(budgetedCost, campaign.budgetedCost) && Objects.equals(actualCost, campaign.actualCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, status, startDate, endDate, expectedRevenue, budgetedCost, actualCost);
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", expectedRevenue=" + expectedRevenue +
                ", budgetedCost=" + budgetedCost +
                ", actualCost=" + actualCost +
                '}';
    }
}
