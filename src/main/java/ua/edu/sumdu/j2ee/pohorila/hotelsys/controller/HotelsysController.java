package ua.edu.sumdu.j2ee.pohorila.hotelsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Customer;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Order;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.Room;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.model.User;
import ua.edu.sumdu.j2ee.pohorila.hotelsys.service.HotelsysService;

import java.awt.print.Pageable;
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

    @GetMapping("/updateRoomPrice")
    public ModelAndView updateRoomPricePage(){
        ModelAndView model = new ModelAndView("updateRoomPrice");
        return model;
    }

    @PostMapping("/updateRoomPrice")
    public String updateRoomPrice(@ModelAttribute("price") int price, @ModelAttribute("roomNumber") int id){
        hotelsysService.updateRoomPrice(id, price);
        return "redirect:/rooms.html";
    }

    @GetMapping("/updateCustomerPhone")
    public ModelAndView updateCustomerPhonePage(){
        ModelAndView model = new ModelAndView("updateCustomerPhone");
        return model;
    }

    @PostMapping("/updateCustomerPhone")
    public String updateCustomerPhone(@ModelAttribute("phone") String phone, @ModelAttribute("id") int id){
        hotelsysService.updateCustomerPhone(id, phone);
        return "redirect:/customers.html";
    }

    @GetMapping("/updateUserMgr")
    public ModelAndView updateUserMgrPage(){
        ModelAndView model = new ModelAndView("updateUserMgr");
        return model;
    }

    @PostMapping("/updateUserMgr")
    public String updateUserMgr(@ModelAttribute("userId") int userId, @ModelAttribute("managerId") int mgrId){
        hotelsysService.updateUserMgr(userId, mgrId);
        return "redirect:/users.html";
    }

    @GetMapping("/updateUserPhone")
    public ModelAndView updateUserPhonePage(){
        ModelAndView model = new ModelAndView("updateUserPhone");
        return model;
    }

    @PostMapping("/updateUserPhone")
    public String updateUserPhone(@ModelAttribute("userId") int userId, @ModelAttribute("phone") String phone){
        hotelsysService.updateUserPhone(userId, phone);
        return "redirect:/users.html";
    }

        @GetMapping("/updateUserRole")
    public ModelAndView updateUserRolePage(){
        ModelAndView model = new ModelAndView("updateUserRole");
        return model;
    }

    @PostMapping("/updateUserRole")
    public String updateUserRole(@ModelAttribute("userId") int userId, @ModelAttribute("roleId") int roleId){
        hotelsysService.updateUserRole(userId, roleId);
        return "redirect:/users.html";
    }

    @GetMapping("/addOrder")
    public ModelAndView addOrderPage(){
        ModelAndView model = new ModelAndView("addOrder");
        return model;
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute("order") Order order){
        hotelsysService.addOrder(order.getOrderId(), order.getCustomerId(), order.getRoomNumber());
        return "redirect:/orders.html";
    }

    @RequestMapping("/deleteOrder")
    public ModelAndView deleteOrder(){
        ModelAndView model = new ModelAndView("deleteOrder");
        ArrayList<Order> objects = hotelsysService.getAllOrders().getArr();
        model.addObject("ordersObj", objects);
        return model;
    }

    @PostMapping("/deleteOrder")
    public String deleteOrder(@ModelAttribute("orderId") int id){
        hotelsysService.removeOrder(id);
        return "redirect:/orders.html";
    }

    @RequestMapping("/orders")
    public ModelAndView getOrders(@PageableDefault(sort = "id", direction = Sort.Direction.DESC)Pageable pageable) {
        ModelAndView model = new ModelAndView("orders");
        ArrayList<Order> objects = hotelsysService.getAllOrders().getArr();
        model.addObject("ordersObj", objects);
        return model;
    }

}