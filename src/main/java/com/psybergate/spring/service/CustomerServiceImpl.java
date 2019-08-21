package com.psybergate.spring.service;

import com.psybergate.spring.model.Audit;
import com.psybergate.spring.model.Customer;
import com.psybergate.spring.repository.AuditRepository;
import com.psybergate.spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AuditRepository auditRepository;


    @Override
    public Optional<Audit> getAudit(Long id) {
        return  auditRepository.findById(id);
    }

    @Override
    public Optional<Customer> getCustomer(Long customerNum) {
        return customerRepository.findById(customerNum);
    }


    @Override
    public List<Customer> getCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public List<Audit> getAudits() {
        return auditRepository.findAll();
    }

    @Override
    public void addCustomer(Customer customer, Audit audit) {
        customerRepository.save(customer);
        auditRepository.save(audit);
    }
}
