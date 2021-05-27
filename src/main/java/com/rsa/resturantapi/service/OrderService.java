package com.rsa.resturantapi.service;

import com.rsa.resturantapi.dao.OrderRepo;
import com.rsa.resturantapi.entity.ItemEntity;
import com.rsa.resturantapi.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ItemService itemService;

    public OrderEntity addItemsToOrder(List<Long> itemsId){
        OrderEntity orderEntity = new OrderEntity();
        ArrayList<ItemEntity> itemEntityList = new ArrayList<>();
        int total = 0 ;
        for(Long itemId : itemsId){
            ItemEntity itemEntity = itemService.findOneItem(itemId);
            total = total + itemEntity.getDishPrice();
            itemEntityList.add(itemEntity);
        }
        orderEntity.setItemsList(itemEntityList);
        orderEntity.setTotalPriceOfDish(total);
        orderRepo.save(orderEntity);
        return orderEntity;
    }
}
