package com.rsa.resturantapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//@Entity
public class CustomerEntity {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    @OneToOne
    private OrderEntity orderEntity;

    public CustomerEntity() { }

    public CustomerEntity(String firstName, String lastName, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
