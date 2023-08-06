package com.cache.hazelcast.controller;

import com.cache.hazelcast.entity.Customer;
import com.cache.hazelcast.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomer(@PathVariable("id") String id){
        logger.info("Id = "+ id);
       return customerService.getCustomer(Integer.parseInt(id));
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer cus){
        return customerService.updateCustomer(cus);
    }


    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomer();
    }
}
