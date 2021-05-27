package com.rsa.resturantapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int totalPriceOfDish;
    @ManyToMany(targetEntity = ItemEntity.class,cascade = CascadeType.ALL)
    @JoinTable(
            name="order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemEntity> itemsList ;

    public OrderEntity() {}
    public OrderEntity(int totalPriceOfDish, ArrayList<ItemEntity> itemsList) {
        this.totalPriceOfDish = totalPriceOfDish;
        this.itemsList = itemsList;
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
