package com.khouloud.cms.api;

import com.khouloud.cms.model.Customer;
import com.khouloud.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    //create customer
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {

        return customerService.addCustomer(customer);
    }

    //get all customers
    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    //get customer by id
    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId) {
        return customerService.getCustomer(customerId);
    }

    //update customer
    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }

    //delete customer
    @DeleteMapping(value = "/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId) {
        customerService.deleteCustomer(customerId);
    }
}
