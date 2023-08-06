package com.cache.hazelcast.service;

import com.cache.hazelcast.entity.Customer;
import com.cache.hazelcast.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CacheManager cacheManager;
    //key is the unique way to identify the cache and when the id is same the method does not get executed instead
    //loaded from the cache
    //@Cacheable indicates that the method should be cached and value is the alias of the cachenames
    @Cacheable(cacheNames = "allCustomerCache",key = "'oneData'")
    public List<Customer> getAllCustomer(){
        return customerDao.findAll();
    }
    //Without adding the CachePut when we update the value in db it will not get reflected in the cache
    // therefore we'll get wrong results in the request

//    @CachePut(cacheNames = "allCustomerCache", key = "'oneData'")
//    public List<Customer> updateCustomer(Customer cus){
//        Customer customer = customerDao.save(cus);
//        updateCache(customer);
//        return customerDao.findAll();
//    }

    @CachePut(value = "customerCache", key = "'oneData'")
    public Customer updateCustomer(Customer cus){
        return customerDao.save(cus);
    }
    @Cacheable(value = "customerCache", key = "'oneData'")
    public Optional<Customer> getCustomer(int id){
        return customerDao.findById(id);
    }

    private void updateCache(Customer updatedCustomer){
        Cache customerCache = cacheManager.getCache("allCustomerCache");
        if(customerCache != null){
            customerCache.put(updatedCustomer.getId(), updatedCustomer);
        }
    }
}
