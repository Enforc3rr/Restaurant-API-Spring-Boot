package com.rsa.resturantapi.controller;

import com.rsa.resturantapi.entity.CustomerEntity;
import com.rsa.resturantapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerEntity customerEntity){
        return new ResponseEntity<>(customerService.addCustomer(customerEntity),HttpStatus.CREATED);
    }
    @GetMapping("/fetch")
    public ResponseEntity<?> getAllCustomers(){
        return new ResponseEntity<>(customerService.viewCustomers(),HttpStatus.OK);
    }
    //In Future We Won't need to pass in ID as a path Variable
    @GetMapping("/fetchOrders/{id}")
    public ResponseEntity<?> getAllOrdersByACustomer(@PathVariable long id){
        return new ResponseEntity<>(customerService.getAllOrders(id),HttpStatus.OK);
    }

}
