package com.rsa.resturantapi.entity;

import antlr.CommonAST;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dishName;
    private int dishPrice;

    @ManyToMany(targetEntity = OrderEntity.class,cascade = CascadeType.ALL)
    @JoinTable(
            name="order_item",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    @JsonIgnore
    private List<OrderEntity> orderEntity;



    public ItemEntity() { }

    public ItemEntity(String dishName, int dishPrice) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
    }

    public List<OrderEntity> getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(List<OrderEntity> orderEntity) {
        this.orderEntity = orderEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(int dishPrice) {
        this.dishPrice = dishPrice;
    }
}
