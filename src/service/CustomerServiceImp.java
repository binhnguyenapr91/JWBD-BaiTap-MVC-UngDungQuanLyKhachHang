package service;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImp implements CustomerService {
    static List<Customer> listCustomer;
    static{
        listCustomer = new ArrayList<>();
        listCustomer.add(new Customer(1,"BinhNguyen","HaNoi"));
        listCustomer.add(new Customer(2,"HoaiPham","NinhBinh"));
        listCustomer.add(new Customer(3,"LamNguyen","HaNoi"));
        listCustomer.add(new Customer(4,"ThinhBui","NinhBinh"));
        listCustomer.add(new Customer(5,"ThanhNguyen","HaNoi"));
        listCustomer.add(new Customer(6,"TienNguyen","NinhBinh"));
    }

    @Override
    public List<Customer> findAll() {
        return listCustomer;
    }

    @Override
    public void addCustomer(Customer customer) {
        listCustomer.add(customer);
    }

    @Override
    public Customer findById(int customerId) {
        return listCustomer.get(customerId);
    }
    @Override
    public void updateCustomerById(int customerId, Customer customer) {
        listCustomer.set(customerId,customer);
    }

    @Override
    public void deleteCustomerById(int customerId) {
        listCustomer.remove(customerId);
    }

    @Override
    public void readCustomerById(int customerId) {

    }


}
