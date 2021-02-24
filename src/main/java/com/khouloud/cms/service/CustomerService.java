package com.khouloud.cms.service;

import com.khouloud.cms.dao.CustomerDAO;
import com.khouloud.cms.exception.CustomerNotFoundException;
import com.khouloud.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    private int customerIdCount = 1;
    private List<Customer> CustomerList = new CopyOnWriteArrayList<>();




    //create customer
    public Customer addCustomer(Customer customer) {

        return customerDAO.save(customer);
    }

    //get all customers
    public List<Customer> getCustomers() {

        return customerDAO.findAll();
    }

    //get customer by id
    public Customer getCustomer(int customerId) {

        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);

        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record is not available..");

        return optionalCustomer.get();
    }

    //update customer
    public Customer updateCustomer(int customerId, Customer customer) {

        customer.setCustomerId(customerId);

        return customerDAO.save(customer);
    }

    //delete customer
    public void deleteCustomer(int customerId) {

        customerDAO.deleteById(customerId);
    }
}
