package com.psybergate.spring.service;

import com.psybergate.spring.model.Audit;
import com.psybergate.spring.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<Customer> getCustomer(Long customerNum);

    Optional<Audit> getAudit(Long id);

    List<Customer> getCustomers();

    List<Audit> getAudits();

    void addCustomer(Customer customer,Audit audit);

}
