package com.rsa.resturantapi.service;

import com.rsa.resturantapi.dao.ItemRepo;
import com.rsa.resturantapi.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepo itemRepo;

    public ItemEntity findOneItem(Long itemId){
       return itemRepo.findById(itemId).get();
    }

    public List<ItemEntity> getAllItems(){
        return itemRepo.findAll();
    }
    public void addItem(Iterable<ItemEntity> itemEntities){
        itemRepo.saveAll(itemEntities);
    }

}
