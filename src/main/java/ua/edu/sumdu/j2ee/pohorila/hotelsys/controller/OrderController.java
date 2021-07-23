package ua.edu.sumdu.j2ee.pohorila.hotelsys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Order;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.service.OrderService;

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class OrderController {
    @Autowired
    public OrderService orderService;
    Logger logger = LoggerFactory.getLogger(OrderController.class);


    @GetMapping("/addOrder")
    public ModelAndView addOrderPage(){
        ModelAndView model = new ModelAndView("addOrder");
        logger.info("addOrder controller");
        return model;
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute("order") Order order){
        orderService.addOrder(order.getCustomerId(), order.getRoomNumber());
        logger.info("addOrder controller, order" +order);
        return "redirect:/orders.html";
    }

    @RequestMapping("/deleteOrder")
    public ModelAndView deleteOrder(){
        ModelAndView model = new ModelAndView("deleteOrder");
        ArrayList<Order> objects = orderService.getAllOrders().getArr();
        model.addObject("ordersObj", objects);
        logger.info("deleteOrder controller");
        return model;
    }

    @PostMapping("/deleteOrder")
    public String deleteOrder(@ModelAttribute("orderId") int id){
        orderService.removeOrder(id);
        logger.info("deleteOrder controller, id:" +id);
        return "redirect:/orders.html";
    }

    @RequestMapping(value = "/orders/{sort}")
    public ModelAndView getOrders(@PathVariable String sort) {
        ModelAndView model = new ModelAndView("orders");
        ArrayList<Order> objects = orderService.getAllOrders().getArr();
        if(sort.equals("id")){
            Collections.sort(objects, Order.idComparator);
        }
        if(sort.equals("customerId")){
            Collections.sort(objects, Order.customerComparator);
        }
        if(sort.equals("roomNumber")){
            Collections.sort(objects, Order.roomComparator);
        }
        model.addObject("ordersObj", objects);
        logger.info("getOrders");
        return model;
    }

}
