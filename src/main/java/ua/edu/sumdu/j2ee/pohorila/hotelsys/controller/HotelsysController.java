package ua.edu.sumdu.j2ee.pohorila.hotelsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Customer;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Room;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.User;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.service.HotelsysService;

import java.util.ArrayList;

@Controller
public class HotelsysController {

    @Autowired
    public HotelsysService hotelsysService;

    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {

        String message = "<br><div style='text-align:center;'>"
                + "<h3>Hello World, this is Tested Spring MVC</h3></div><br><br>";
        return new ModelAndView("welcome", "message", message);
    }

    @RequestMapping("/users")
    public ModelAndView getUsers() {
        ModelAndView model = new ModelAndView("users");
        ArrayList<User> objects = hotelsysService.getAllUsers().getArr();
        model.addObject("usersObj", objects);
        return model;
    }

    @RequestMapping("/customers")
    public ModelAndView getCustomers() {
        ModelAndView model = new ModelAndView("customers");
        ArrayList<Customer> objects = hotelsysService.getAllCustomer().getArr();
        model.addObject("customersObj", objects);
        return model;
    }

    @RequestMapping("/rooms")
    public ModelAndView getRooms() {
        ModelAndView model = new ModelAndView("rooms");
        ArrayList<Room> objects = hotelsysService.getAllRooms().getArr();
        model.addObject("roomsObj", objects);
        return model;
    }

    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(){
        ModelAndView model = new ModelAndView("deleteUser");
        ArrayList<User> objects = hotelsysService.getAllUsers().getArr();
        model.addObject("usersObj", objects);
        return model;
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("userId") int userId){
        hotelsysService.removeUser(userId);
        return "redirect:/users.html";
    }

    @RequestMapping("/deleteCustomer")
    public ModelAndView deleteCustomer(){
        ModelAndView model = new ModelAndView("deleteCustomer");
        ArrayList<Customer> objects = hotelsysService.getAllCustomer().getArr();
        model.addObject("customersObj", objects);
        return model;
    }

    @PostMapping("/deleteCustomer")
    public String deleteCustomer(@ModelAttribute("customerId") int customerId){
        hotelsysService.removeCustomer(customerId);
        return "redirect:/customers.html";
    }

    @RequestMapping("/deleteRoom")
    public ModelAndView deleteRoom(){
        ModelAndView model = new ModelAndView("deleteRoom");
        ArrayList<Room> objects = hotelsysService.getAllRooms().getArr();
        model.addObject("roomsObj", objects);
        return model;
    }

    @PostMapping("/deleteRoom")
    public String deleteRoom(@ModelAttribute("roomNumber") int roomNumber){
        hotelsysService.removeRoom(roomNumber);
        return "redirect:/rooms.html";
    }


    @GetMapping("/addUser")
    public ModelAndView addUserPage(){
        ModelAndView model = new ModelAndView("addUser");
        return model;
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user")User user){
        hotelsysService.addUser(user.getName(), user.getManagerId(), user.getRoleId(), user.getUserId(), user.getPhoneNum(), user.getHotelID());
        return "redirect:/users.html";
    }

        @GetMapping("/addCustomer")
    public ModelAndView addCustomerPage(){
        ModelAndView model = new ModelAndView("addCustomer");
        return model;
    }

    @PostMapping("/addCustomer")
    public String addRoom(@ModelAttribute("customer") Customer customer){
        hotelsysService.addCustomer(customer.getName(), customer.getPhoneNumber());
        return "redirect:/customers.html";
    }

    @GetMapping("/addRoom")
    public ModelAndView addRoomPage(){
        ModelAndView model = new ModelAndView("addRoom");
        return model;
    }

    @PostMapping("/addRoom")
    public String addRoom(@ModelAttribute("room") Room room){
        hotelsysService.addRoom(room.getRoomNumber(), room.getRoomType(), room.getCapacity(), room.getPrice(), room.getHotelID());
        return "redirect:/rooms.html";
    }


}