package com.rsa.resturantapi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int totalPriceOfDish;

    /*
    Fetch Type is of two types 1) Lazy 2) Eager
    LAZY -> It means that when i will load in the Orders then unless i won't need the name of dishes they won't load.
            It could be useful when a large number of items are going to be associated with the order , but when order
            number is less . Then This won't be much useful.
    Eager -> As soon as order loads up , items associated with order also loads at same time.
    */
    @ManyToMany(targetEntity = ItemEntity.class,
            cascade = { CascadeType.DETACH, CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH}
            ,fetch = FetchType.LAZY)
    /*
    Here We are making a new Table with name "order_item" , as it is a ManyToMany relation . So , It won't be wise
    with respect to design that we store everything under one table.
    And We are just simply Naming the headers of the table.
     */
    @JoinTable(
            name="order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> itemsList ;

    /*
    ManyToOne Relation is compulsion here bcuz we can have many orders by a single customer but every order must have a unique customer
    mappedBy is defined at the place where we have got OneToMany part.
     */
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.DETACH}
            ,targetEntity = CustomerEntity.class)
    private CustomerEntity customer;


    public OrderEntity() {}

    public OrderEntity(int totalPriceOfDish, ArrayList<ItemEntity> itemsList) {
        this.totalPriceOfDish = totalPriceOfDish;
        this.itemsList = itemsList;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTotalPriceOfDish() {
        return totalPriceOfDish;
    }

    public void setTotalPriceOfDish(int totalPriceOfDish) {
        this.totalPriceOfDish = totalPriceOfDish;
    }

    public List<ItemEntity> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<ItemEntity> itemsList) {
        this.itemsList = itemsList;
    }
}
