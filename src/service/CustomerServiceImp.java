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
    }

    @Override
    public List<Customer> findAll() {
        return listCustomer;
    }
}
