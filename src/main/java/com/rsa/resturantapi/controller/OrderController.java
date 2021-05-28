package com.rsa.resturantapi.controller;

import com.rsa.resturantapi.entity.OrderEntity;
import com.rsa.resturantapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> findOrder(@PathVariable Long orderId){
        return new ResponseEntity<>(orderService.findOrder(orderId),HttpStatus.OK);
    }

    @PostMapping(value = "/order",consumes = "application/json")
    public ResponseEntity<?> checkOrder(@RequestBody List<Long> itemsId){
        OrderEntity orderEntity =  orderService.addItemsToOrder(itemsId);
        return new ResponseEntity<>(orderEntity, HttpStatus.OK);
    }
}
