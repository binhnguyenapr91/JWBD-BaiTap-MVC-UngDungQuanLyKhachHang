package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();
    public void addCustomer(Customer customer);
    public void updateCustomerById(int customerId,Customer customer);
    public void deleteCustomerById(int customerId);
    public void readCustomerById(int customerId);
    public Customer findById(int id);
}
