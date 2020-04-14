package com.capg.controller;

import com.capg.entities.Customer;
import com.capg.service.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {
    private static Logger Log= LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private ICustomerService customerService;


   

    @GetMapping("/find")
    public ModelAndView findPage() {
        return new ModelAndView("findcustomer");
    }


    @GetMapping("/processfindcus")
    public ModelAndView customerDetails(@RequestParam("cusid")int cusId) {
      
        Customer customer= customerService.findById(cusId);
        return new ModelAndView("customerdetails", "customer", customer);
    }


    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("customerregister");// only provide view name
    }

    @GetMapping("/processregister")
    public ModelAndView registerCustomer(@RequestParam("cusname") String cusName) {
        Customer customer=new Customer();
        customer.setName(cusName);
        customer=ecustomerService.save(customer);
        return new ModelAndView("customerdetails",  "customer", customer);
    }

   
    }



}
