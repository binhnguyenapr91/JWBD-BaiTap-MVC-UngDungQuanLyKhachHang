package controller;

import model.Customer;
import service.CustomerService;
import service.CustomerServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "create":
                navigateToCreateForm(req,resp);
                break;
            case "read":
                navigateToViewForm(req,resp);
                break;
            case "update":
                navigateToUpdateForm(req,resp);
                break;
            case "delete":
                navigateToDeleteForm(req,resp);
                break;
            default:
                listCustomer(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "create":
                createCustomer(req,resp);
                break;
            case "update":
                updateCustomer(req,resp);
                break;
            case "delete":
                deleteCustomer(req,resp);
                break;
            default:
                listCustomer(req,resp);
        }
    }

    private void createCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int customerId = Integer.parseInt(req.getParameter("customerId"));
        String customerName = req.getParameter("customerName");
        String customerAddress = req.getParameter("customerAddress");

        Customer customer = new Customer(customerId, customerName, customerAddress);
        this.customerService.addCustomer(customer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("createCustomer.jsp");
        req.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("customerId"));
        String name = req.getParameter("customerName");
        String address = req.getParameter("customerAddress");
        Customer customer = this.customerService.findById(id-1);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            customer.setCustomerName(name);
            customer.setCustomerAddress(address);
            this.customerService.updateCustomerById(id-1, customer);
            req.setAttribute("customer", customer);
            req.setAttribute("message", "Customer information was updated");
            dispatcher = req.getRequestDispatcher("updateCustomer.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("customerId"));
        Customer customer = this.customerService.findById(id-1);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            this.customerService.deleteCustomerById(id-1);
        }
        try {
            resp.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void navigateToCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("createCustomer.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void navigateToViewForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = this.customerService.findById(id-1);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = req.getRequestDispatcher("error404.jsp");
        } else {
            req.setAttribute("customer", customer);
            dispatcher = req.getRequestDispatcher("viewCustomer.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void navigateToUpdateForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = this.customerService.findById(id-1);
        RequestDispatcher requestDispatcher;
        if(customer == null){
            requestDispatcher = req.getRequestDispatcher("error404.jsp");
        }else{
            req.setAttribute("customer",customer);
            requestDispatcher = req.getRequestDispatcher("updateCustomer.jsp");
        }
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void navigateToDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = this.customerService.findById(id-1);
        RequestDispatcher requestDispatcher;
        if(customer == null){
            requestDispatcher = req.getRequestDispatcher("error404.jsp");
        }else{
            req.setAttribute("customer",customer);
            requestDispatcher = req.getRequestDispatcher("deleteCustomer.jsp");
        }
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void listCustomer(HttpServletRequest req, HttpServletResponse resp) {
        List<Customer> customers = this.customerService.findAll();
        req.setAttribute("listCustomer",customers);
        RequestDispatcher rd = req.getRequestDispatcher("listCustomer.jsp");
        try {
            rd.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
