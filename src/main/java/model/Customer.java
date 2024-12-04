package model;

import com.github.javafaker.Faker;

public class Customer {

    private static final Faker faker = new Faker();
    private String name;
    private String email;
    private String phone;
    private String address;

    public Customer(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Customer random() {
        return new Customer(faker.name().firstName(),faker.internet().emailAddress(),faker.phoneNumber().phoneNumber(),faker.address().fullAddress());
    }
}
