package ua.edu.sumdu.j2ee.pohorila.hotelsys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Customer;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.service.CustomerService;

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class CustomerController {
    @Autowired
    public CustomerService customerService;
    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @RequestMapping("/deleteCustomer")
    public ModelAndView deleteCustomer(){
        ModelAndView model = new ModelAndView("deleteCustomer");
        ArrayList<Customer> objects = customerService.getAllCustomer().getArr();
        model.addObject("customersObj", objects);
        logger.info("deleteCustomer controller objects:"+objects.toString());
        return model;
    }

    @PostMapping("/deleteCustomer")
    public String deleteCustomer(@ModelAttribute("customerId") int customerId){
        customerService.removeCustomer(customerId);
        logger.info("deleteCustomer controller id:" + customerId);
        return "redirect:/customers.html";
    }

    @GetMapping("/addCustomer")
    public ModelAndView addCustomerPage(){
        ModelAndView model = new ModelAndView("addCustomer");
        logger.info("addCustomer controller");
        return model;
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer){
        customerService.addCustomer(customer.getName(), customer.getPhoneNumber());
        logger.info("addCustomer controller "+customer.toString());
        return "redirect:/customers.html";
    }


    @GetMapping("/updateCustomerPhone")
    public ModelAndView updateCustomerPhonePage(){
        ModelAndView model = new ModelAndView("updateCustomerPhone");
        logger.info("updateCustomerPhone controller");
        return model;
    }

    @PostMapping("/updateCustomerPhone")
    public String updateCustomerPhone(@ModelAttribute("phone") String phone, @ModelAttribute("id") int id){
        customerService.updateCustomerPhone(id, phone);
        logger.info("updateCustomerPhone controller, id:" +id+ " phone:"+phone);
        return "redirect:/customers.html";
    }



    @RequestMapping("/customers/{sort}")
    public ModelAndView getCustomers(@PathVariable String sort) {
        ModelAndView model = new ModelAndView("customers");
        ArrayList<Customer> objects = customerService.getAllCustomer().getArr();
        if(sort.equals("id")){
            Collections.sort(objects, Customer.idComparator);
        }
        if(sort.equals("name")){
            Collections.sort(objects, Customer.nameComparator);
        }
        if(sort.equals("phoneNumber")){
            Collections.sort(objects, Customer.phoneComparator);
        }
        model.addObject("customersObj", objects);
        logger.info("getCustomers");
        return model;
    }

}
