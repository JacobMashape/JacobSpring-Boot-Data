package com.psybergate.spring.controller;

import com.psybergate.spring.model.Audit;
import com.psybergate.spring.model.Customer;
import com.psybergate.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/getaudits")
    public ResponseEntity<List<Audit>> getAudits() {
        return new ResponseEntity<>(customerService.getAudits(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getcustomers")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }


    @RequestMapping(value = "/getcustomer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerNum) {
        return new ResponseEntity<>(customerService.getCustomer(customerNum).get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getaudit/{id}")
    public ResponseEntity<Audit> getAudit(@PathVariable("id") Long id) {
        return new ResponseEntity<>(customerService.getAudit(id).get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
    public void addCustomer(@RequestBody Customer customer) {
        Audit audit = new Audit(customer.getName() + " review", "PASSED");
        customerService.addCustomer(customer, audit);
    }
}
