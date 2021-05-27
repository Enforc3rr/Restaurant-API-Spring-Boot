package com.rsa.resturantapi.controller;

import com.rsa.resturantapi.entity.OrderEntity;
import com.rsa.resturantapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping(value = "/order",consumes = "application/json")
    public ResponseEntity<?> checkOrder(@RequestBody List<Long> itemsId){
        OrderEntity orderEntity =  orderService.addItemsToOrder(itemsId);
        return new ResponseEntity<>(orderEntity, HttpStatus.OK);
    }
}
