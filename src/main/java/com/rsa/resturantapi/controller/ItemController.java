package com.rsa.resturantapi.controller;

import com.rsa.resturantapi.entity.ItemEntity;
import com.rsa.resturantapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;


    @GetMapping("/fetchall")
    public ResponseEntity<?> getItems(){
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }

    @PostMapping(value = "/additem" , consumes = "application/json")
    public ResponseEntity<?> addItem(@RequestBody Iterable<ItemEntity> itemEntities){
        itemService.addItem(itemEntities);
        return new ResponseEntity<>(itemEntities,HttpStatus.CREATED);
    }
}
