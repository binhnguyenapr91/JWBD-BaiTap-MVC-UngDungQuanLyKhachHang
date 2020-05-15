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
            default:
                listCustomer(req,resp);
        }
    }

    private void listCustomer(HttpServletRequest req, HttpServletResponse resp) {
        List<Customer> customers = this.customerService.findAll();
        req.setAttribute("listCustomer",customers);
        RequestDispatcher rd = req.getRequestDispatcher("customer.jsp");
        try {
            rd.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
